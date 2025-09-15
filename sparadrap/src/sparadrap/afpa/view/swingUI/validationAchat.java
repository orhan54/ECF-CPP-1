package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class validationAchat extends JFrame {
    private JPanel contentPane;
    private JButton btnRetourAchat;
    private JButton btnValiderAchat;
    private JButton buttonQuitterAchat;
    private JLabel titreValideAchat;
    private JTextField inputQuantiteMedic;
    private JButton btnAjouterMedicamentList;
    private JButton btnDelete;
    private JTable tableMedic;
    private JTable tableMedicDispo;
    private JLabel titreTypeLabel;
    private JComboBox<String> comboBoxPatient;
    private JComboBox<String> comboBoxMedicament;
    private JComboBox<String> comboBoxMedecin;
    private JTextField textFieldPrixTotalPayer;

    // Nouveaux composants pour la prise en charge mutuelle
    private JCheckBox checkBoxMutuelle;
    private JComboBox<String> comboBoxMutuelle;
    private JLabel labelPrixTotal;
    private JLabel labelDeductionMutuelle;
    private JLabel labelPrixAPayer;
    private JLabel labelTauxMutuelle;

    private boolean commandeAjoutee = false;

    private DefaultTableModel tableModelCommande;
    private DefaultTableModel tableModelMedicDispo;

    // Liste temporaire pour stocker les médicaments de la commande en cours
    private List<Medicament> medicamentsCommande = new ArrayList<>();
    private List<Integer> quantitesMedicaments = new ArrayList<>();

    public validationAchat(String typeAchat) {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(1600, 1000);

        // Fenêtre
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        // Initialisation des nouveaux composants
        initializeNewComponents();

        // Affichage du type d'achat
        if (typeAchat.equalsIgnoreCase("direct")) {
            titreTypeLabel.setText("DIRECT");
            // Masquer les options de mutuelle pour achat direct
            setMutuelleComponentsVisible(false);
        } else if (typeAchat.equalsIgnoreCase("ordonnance")) {
            titreTypeLabel.setText("ORDONNANCE");
            // Afficher les options de mutuelle pour ordonnance
            setMutuelleComponentsVisible(true);
        }

        // Tableau des médicaments disponibles
        String[] colonne = {"Quantité", "Date mise en service", "Prix", "Categorie", "Nom"};
        tableModelMedicDispo = new DefaultTableModel(colonne, 0);
        tableMedicDispo.setModel(tableModelMedicDispo);

        // Tableau des médicaments ajoutés à la commande
        String[] colonnes = {"Nom medicament", "Quantite", "Prix unitaire", "Prix total"};
        tableModelCommande = new DefaultTableModel(colonnes, 0);
        tableMedic.setModel(tableModelCommande);

        // Remplir les données
        afficherListeMedicDispo();
        remplirComboBoxMedecin();
        remplirComboBoxClient();
        remplirComboBoxMedicament();
        remplirComboBoxMutuelle();

        this.pack();
        this.setLocationRelativeTo(null);
        btnValiderAchat.setEnabled(false);

        // Listeners
        btnRetourAchat.addActionListener(e -> retour());
        btnValiderAchat.addActionListener(e -> valider());
        buttonQuitterAchat.addActionListener(e -> quitter());
        btnAjouterMedicamentList.addActionListener(e -> {
            try {
                ajouterMedicamentAuPanier();
            } catch (SaisieException ex) {
                JOptionPane.showMessageDialog(this,
                        "Erreur lors de l'ajout : " + ex.getMessage(),
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnDelete.addActionListener(e -> supprimerMedicamentDuPanier());

        // Listeners pour la mutuelle
        checkBoxMutuelle.addActionListener(e -> {
            comboBoxMutuelle.setEnabled(checkBoxMutuelle.isSelected());
            mettreAJourAffichagePrix();
        });
        comboBoxMutuelle.addActionListener(e -> mettreAJourAffichagePrix());
    }

    // Initialiser les nouveaux composants pour la prise en charge mutuelle
    private void initializeNewComponents() {
        checkBoxMutuelle = new JCheckBox("Prise en charge mutuelle");
        checkBoxMutuelle.setSelected(false);

        comboBoxMutuelle = new JComboBox<>();
        comboBoxMutuelle.setEnabled(false);

        labelPrixTotal = new JLabel("Prix total : 0,00€");
        labelDeductionMutuelle = new JLabel("Déduction mutuelle : 0,00€");
        labelPrixAPayer = new JLabel("Prix à payer : 0,00€");
        labelTauxMutuelle = new JLabel("Taux : 0%");

        // TODO: Vous devrez ajouter ces composants à votre interface graphique
        // selon votre layout manager dans le fichier .form correspondant
    }

    // Gérer la visibilité des composants liés à la mutuelle
    private void setMutuelleComponentsVisible(boolean visible) {
        if (checkBoxMutuelle != null) checkBoxMutuelle.setVisible(visible);
        if (comboBoxMutuelle != null) comboBoxMutuelle.setVisible(visible);
        if (labelDeductionMutuelle != null) labelDeductionMutuelle.setVisible(visible);
        if (labelTauxMutuelle != null) labelTauxMutuelle.setVisible(visible);
    }

    // Remplir la comboBox des mutuelles
    private void remplirComboBoxMutuelle() {
        comboBoxMutuelle.removeAllItems();
        comboBoxMutuelle.addItem("-- Sélectionner une mutuelle --");
        for (Mutuelle mutuelle : Mutuelle.getMutuelles()) {
            String item = mutuelle.getNom() + " (" + String.format("%.1f", mutuelle.getTauxPriseEnCharge()) + "%)";
            comboBoxMutuelle.addItem(item);
        }
    }

    // Récupérer la mutuelle sélectionnée
    private Mutuelle getMutuelleSelectionnee() {
        if (comboBoxMutuelle.getSelectedIndex() <= 0) {
            return null;
        }

        String selectedItem = comboBoxMutuelle.getSelectedItem().toString();
        String nomMutuelle = selectedItem.split(" \\(")[0]; // Extraire le nom avant la parenthèse

        for (Mutuelle mutuelle : Mutuelle.getMutuelles()) {
            if (mutuelle.getNom().equals(nomMutuelle)) {
                return mutuelle;
            }
        }
        return null;
    }

    // Mettre à jour l'affichage des prix selon la prise en charge mutuelle
    private void mettreAJourAffichagePrix() {
        double prixTotal = calculerPrixTotalPanier();
        double deduction = 0.0;
        double prixAPayer = prixTotal;
        String tauxText = "Taux : 0%";

        if (titreTypeLabel.getText().equals("ORDONNANCE") &&
                checkBoxMutuelle.isSelected()) {

            Mutuelle mutuelleSelectionnee = getMutuelleSelectionnee();
            if (mutuelleSelectionnee != null) {
                double tauxMutuelle = mutuelleSelectionnee.getTauxPriseEnCharge() / 100.0;
                deduction = prixTotal * tauxMutuelle;
                prixAPayer = prixTotal - deduction;
                tauxText = "Taux : " + String.format("%.1f", mutuelleSelectionnee.getTauxPriseEnCharge()) + "%";
            }
        }

        labelPrixTotal.setText(String.format("Prix total : %.2f€", prixTotal));
        labelDeductionMutuelle.setText(String.format("Déduction mutuelle : %.2f€", deduction));
        labelPrixAPayer.setText(String.format("Prix à payer : %.2f€", prixAPayer));
        labelTauxMutuelle.setText(tauxText);
    }

    // Calculer le prix total du panier
    private double calculerPrixTotalPanier() {
        double total = 0.0;
        for (int i = 0; i < medicamentsCommande.size(); i++) {
            total += medicamentsCommande.get(i).getPrix() * quantitesMedicaments.get(i);
        }
        return total;
    }

    // Afficher la list item combobox nom et prénom medecin
    private void remplirComboBoxMedecin() {
        comboBoxMedecin.removeAllItems();
        for(Medecin medecin : Medecin.getMedecins()) {
            comboBoxMedecin.addItem(medecin.getNom() + " " + medecin.getPrenom());
        }
    }

    // Afficher la list item combobox nom et prénom client
    private void remplirComboBoxClient() {
        comboBoxPatient.removeAllItems();
        for(Patient patient : Patient.getPatients()) {
            comboBoxPatient.addItem(patient.getNom() + " " + patient.getPrenom());
        }
    }

    // Afficher la list item combobox nom medicament
    private void remplirComboBoxMedicament() {
        comboBoxMedicament.removeAllItems();
        for (Medicament medicament : Medicament.getMedicaments()) {
            comboBoxMedicament.addItem(medicament.getNom());
        }
    }

    // Ajouter un médicament au panier de la commande
    private void ajouterMedicamentAuPanier() throws SaisieException {
        String nomMedic = comboBoxMedicament.getSelectedItem().toString().trim();
        int quantite;

        // Vérification de la quantité
        try {
            quantite = Integer.parseInt(inputQuantiteMedic.getText().trim());
            if (quantite <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La quantité doit être un nombre entier positif",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Recherche du médicament
        Medicament medicamentTrouve = null;
        for (Medicament medicament : Medicament.getMedicaments()) {
            if (medicament.getNom().equalsIgnoreCase(nomMedic)) {
                medicamentTrouve = medicament;
                break;
            }
        }

        if (medicamentTrouve == null) {
            JOptionPane.showMessageDialog(this,
                    "Médicament introuvable",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Vérifier si le médicament n'est pas déjà dans le panier
        boolean dejaPresent = false;
        for (int i = 0; i < medicamentsCommande.size(); i++) {
            if (medicamentsCommande.get(i).getNom().equalsIgnoreCase(nomMedic)) {
                // Mise à jour de la quantité si le médicament est déjà présent
                quantitesMedicaments.set(i, quantitesMedicaments.get(i) + quantite);
                dejaPresent = true;
                break;
            }
        }

        if (!dejaPresent) {
            // Créer une copie du médicament avec la nouvelle quantité pour cette commande
            Medicament medicamentCommande = new Medicament(
                    quantite,
                    medicamentTrouve.getDateMiseEnService(),
                    medicamentTrouve.getPrix(),
                    medicamentTrouve.getCategorie(),
                    medicamentTrouve.getNom()
            );

            medicamentsCommande.add(medicamentCommande);
            quantitesMedicaments.add(quantite);
        }

        // Rafraîchir l'affichage du panier
        rafraichirTableauPanier();

        // Vider le champ quantité
        inputQuantiteMedic.setText("");

        // Activer le bouton valider si au moins un médicament est ajouté
        btnValiderAchat.setEnabled(!medicamentsCommande.isEmpty());

        // Mettre à jour l'affichage des prix
        mettreAJourAffichagePrix();

        JOptionPane.showMessageDialog(this,
                "Médicament ajouté au panier !",
                "Succès", JOptionPane.INFORMATION_MESSAGE);
    }

    // Rafraîchir l'affichage du tableau panier
    private void rafraichirTableauPanier() {
        tableModelCommande.setRowCount(0);

        for (int i = 0; i < medicamentsCommande.size(); i++) {
            Medicament med = medicamentsCommande.get(i);
            int qty = quantitesMedicaments.get(i);
            double prixTotal = med.getPrix() * qty;

            tableModelCommande.addRow(new Object[]{
                    med.getNom(),
                    qty,
                    String.format("%.2f€", med.getPrix()),
                    String.format("%.2f€", prixTotal)
            });
        }
    }

    private void afficherListeMedicDispo() {
        tableModelMedicDispo.setRowCount(0);

        if (Medicament.getMedicaments().isEmpty()) {
            tableModelMedicDispo.addRow(new Object[]{"-", "Aucun medicament", "", "", ""});
        } else {
            for (Medicament medicaments : Medicament.getMedicaments()) {
                tableModelMedicDispo.addRow(new Object[]{
                        medicaments.getQuantite(),
                        medicaments.getDateMiseEnService(),
                        String.format("%.2f€", medicaments.getPrix()),
                        medicaments.getCategorie(),
                        medicaments.getNom(),
                });
            }
        }
    }

    // Supprimer médicament du panier
    private void supprimerMedicamentDuPanier() {
        int selectedRow = tableMedic.getSelectedRow();
        if (selectedRow >= 0 && selectedRow < medicamentsCommande.size()) {
            medicamentsCommande.remove(selectedRow);
            quantitesMedicaments.remove(selectedRow);
            rafraichirTableauPanier();

            // Désactiver le bouton valider si plus de médicaments
            btnValiderAchat.setEnabled(!medicamentsCommande.isEmpty());

            // Mettre à jour l'affichage des prix
            mettreAJourAffichagePrix();

            JOptionPane.showMessageDialog(this,
                    "Médicament retiré du panier",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Veuillez sélectionner un médicament à supprimer",
                    "Aucune sélection", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void retour() {
        int reponse = JOptionPane.showConfirmDialog(this,
                "Des médicaments sont dans le panier. Voulez-vous vraiment annuler ?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    private void valider() {
        if (medicamentsCommande.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Aucun médicament dans le panier",
                    "Panier vide", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Vérifier que les ComboBox ont des sélections
        if (comboBoxMedecin.getSelectedItem() == null || comboBoxPatient.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this,
                    "Veuillez sélectionner un médecin et un patient",
                    "Information manquante", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Vérifier la mutuelle si nécessaire
        Mutuelle mutuelleSelectionnee = null;
        boolean priseEnCharge = false;

        if (titreTypeLabel.getText().equals("ORDONNANCE") && checkBoxMutuelle.isSelected()) {
            mutuelleSelectionnee = getMutuelleSelectionnee();
            if (mutuelleSelectionnee == null) {
                JOptionPane.showMessageDialog(this,
                        "Veuillez sélectionner une mutuelle",
                        "Mutuelle manquante", JOptionPane.WARNING_MESSAGE);
                return;
            }
            priseEnCharge = true;
        }

        // Calculer les prix
        double prixTotal = calculerPrixTotalPanier();
        double prixAPayer = prixTotal;
        double deduction = 0.0;

        if (priseEnCharge && mutuelleSelectionnee != null) {
            double tauxMutuelle = mutuelleSelectionnee.getTauxPriseEnCharge() / 100.0;
            deduction = prixTotal * tauxMutuelle;
            prixAPayer = prixTotal - deduction;
        }

        // Message de confirmation avec détails des prix
        StringBuilder messageConfirmation = new StringBuilder();
        messageConfirmation.append("Voulez-vous confirmer la commande avec ")
                .append(medicamentsCommande.size())
                .append(" médicament(s) ?\n\n");
        messageConfirmation.append("Prix total : ").append(String.format("%.2f€", prixTotal)).append("\n");

        if (priseEnCharge && mutuelleSelectionnee != null) {
            messageConfirmation.append("Mutuelle : ").append(mutuelleSelectionnee.getNom()).append("\n");
            messageConfirmation.append("Taux de prise en charge : ").append(String.format("%.1f%%", mutuelleSelectionnee.getTauxPriseEnCharge())).append("\n");
            messageConfirmation.append("Déduction mutuelle : ").append(String.format("%.2f€", deduction)).append("\n");
            messageConfirmation.append("Prix à payer : ").append(String.format("%.2f€", prixAPayer)).append("\n");
        }

        int reponse = JOptionPane.showConfirmDialog(this,
                messageConfirmation.toString(),
                "Confirmation",
                JOptionPane.YES_NO_OPTION);

        if (reponse == JOptionPane.YES_OPTION) {
            try {
                // Récupérer les informations
                String typeAchatStr = titreTypeLabel.getText().trim().toUpperCase();
                String nomMedecin = comboBoxMedecin.getSelectedItem().toString().trim();
                String nomPatient = comboBoxPatient.getSelectedItem().toString().trim();

                // Conversion du texte en enum TypeAchat
                Commande.TypeAchat typeAchat;
                if (typeAchatStr.equals("DIRECT")) {
                    typeAchat = Commande.TypeAchat.DIRECT;
                } else {
                    typeAchat = Commande.TypeAchat.ORDONNANCE;
                }

                // Calculer la quantité totale
                int quantiteTotale = quantitesMedicaments.stream().mapToInt(Integer::intValue).sum();

                // Créer la commande avec la mutuelle
                Commande commande = new Commande(
                        new java.sql.Date(System.currentTimeMillis()),
                        typeAchat,
                        nomMedecin,
                        nomPatient,
                        new ArrayList<>(medicamentsCommande),
                        quantiteTotale,
                        prixTotal,
                        mutuelleSelectionnee,
                        priseEnCharge
                );

                // Ajouter la commande à la liste globale
                Commande.getCommandes().add(commande);

                // Message de succès
                StringBuilder messageSucces = new StringBuilder();
                messageSucces.append("Commande validée avec succès !\n\n");
                messageSucces.append("Nombre de médicaments : ").append(medicamentsCommande.size()).append("\n");
                messageSucces.append("Quantité totale : ").append(quantiteTotale).append("\n");
                messageSucces.append("Prix total : ").append(String.format("%.2f€", prixTotal)).append("\n");

                if (priseEnCharge && mutuelleSelectionnee != null) {
                    messageSucces.append("Mutuelle : ").append(mutuelleSelectionnee.getNom()).append("\n");
                    messageSucces.append("Déduction : ").append(String.format("%.2f€", deduction)).append("\n");
                    messageSucces.append("Prix final à payer : ").append(String.format("%.2f€", prixAPayer)).append("\n");
                }

                JOptionPane.showMessageDialog(this,
                        messageSucces.toString(),
                        "Commande validée", JOptionPane.INFORMATION_MESSAGE);

                this.dispose();

            } catch (SaisieException e) {
                JOptionPane.showMessageDialog(this,
                        "Erreur lors de la création de la commande : " + e.getMessage(),
                        "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(this,
                "Voulez-vous quitter l'application ?", "Quitter",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}