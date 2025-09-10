package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class validationAchat extends JFrame {
    private JPanel contentPane;
    private JButton btnRetourAchat;
    private JButton btnValiderAchat;
    private JButton buttonQuitterAchat;
    private JLabel titreValideAchat;
    private JTextField inputNomMedic;
    private JTextField inputQuantiteMedic;
    private JButton btnAjouterMedicamentList;
    private JTextField inputNomMedecin;
    private JTextField inputNomPatient;
    private JButton btnDelete;
    private JTable tableMedic;
    private JTable tableMedicDispo;
    private JLabel titreTypeLabel;
    private boolean commandeAjoutee = false;

    private DefaultTableModel tableModelCommande;
    private DefaultTableModel tableModelMedicDispo;

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

        // Affichage du type d’achat
        if (typeAchat.equalsIgnoreCase("direct")) {
            titreTypeLabel.setText("DIRECT");
        } else if (typeAchat.equalsIgnoreCase("ordonnance")) {
            titreTypeLabel.setText("ORDONNANCE");
        }

        // Tableau des médicaments disponibles
        String[] colonne = {"Quantité", "Date mise en service", "Prix", "Categorie", "Nom"};
        tableModelMedicDispo = new DefaultTableModel(colonne, 0);
        tableMedicDispo.setModel(tableModelMedicDispo);

        // Tableau des commandes
        String[] colonnes = {"Type achat", "Nom medecin", "Nom patient", "Nom medicament", "Quantite", "Prix", "Date"};
        tableModelCommande = new DefaultTableModel(colonnes, 0);
        tableMedic.setModel(tableModelCommande);

        // Afficher médicaments disponibles
        afficherListeMedicDispo();

        this.pack();
        this.setLocationRelativeTo(null);
        btnValiderAchat.setEnabled(false);

        // Listeners
        btnRetourAchat.addActionListener(e -> retour());
        btnValiderAchat.addActionListener(e -> valider());
        buttonQuitterAchat.addActionListener(e -> quitter());
        btnAjouterMedicamentList.addActionListener(e -> {
            try {
                ajouter();
            } catch (SaisieException ex) {
                throw new RuntimeException(ex);
            }
        });
        btnDelete.addActionListener(e -> deleteMedic());
    }

    private void ajouter() throws SaisieException {
        String typeAchatStr = titreTypeLabel.getText().trim().toUpperCase();
        String nomMedecin = inputNomMedecin.getText().trim().toUpperCase();
        String nomPatient = inputNomPatient.getText().trim().toUpperCase();
        String nomMedic = inputNomMedic.getText().trim().toUpperCase();
        int quantite;

        // Vérification de la quantité
        try {
            quantite = Integer.parseInt(inputQuantiteMedic.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La quantité doit être un nombre entier",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Recherche du médicament
        double prix = 0;
        Medicament medicamentTrouve = null;
        for (Medicament medicament : Medicament.getMedicaments()) {
            if (medicament.getNom().equalsIgnoreCase(nomMedic)) {
                prix = medicament.getPrix();
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

        // Conversion du texte en enum TypeAchat
        Commande.TypeAchat typeAchat;
        if (typeAchatStr.equals("DIRECT")) {
            typeAchat = Commande.TypeAchat.DIRECT;
        } else if (typeAchatStr.equals("ORDONNANCE")) {
            typeAchat = Commande.TypeAchat.ORDONNANCE;
        } else {
            JOptionPane.showMessageDialog(this,
                    "Type d'achat invalide (valeurs possibles : Direct ou Ordonnance)",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Création de la commande
        Commande commande = new Commande(
                new java.sql.Date(System.currentTimeMillis()),
                typeAchat,
                nomMedecin,
                nomPatient,
                nomMedic,
                quantite,
                prix
        );

        Commande.getCommandes().add(commande);

        // Ajout dans la JTable
        tableModelCommande.addRow(new Object[]{
                commande.getTypeAchat(),
                commande.getNomMedecin(),
                commande.getNomPatient(),
                commande.getNomMedic(),
                commande.getQuantite(),
                commande.getPrix(),
                commande.getDateCommandeCreation()
        });

        commandeAjoutee = true;
        btnValiderAchat.setEnabled(true);

        JOptionPane.showMessageDialog(this,
                "Commande ajoutée avec succès !",
                "Succès", JOptionPane.INFORMATION_MESSAGE);
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
                        medicaments.getPrix(),
                        medicaments.getCategorie(),
                        medicaments.getNom(),
                });
            }
        }
    }

    private void deleteMedic() {
        int selectedRow = tableMedic.getSelectedRow();
        if (selectedRow >= 0) {
            tableModelCommande.removeRow(selectedRow);
        }
    }

    private void retour() {
        this.dispose();
    }

    private void valider() {
        int reponse = JOptionPane.showConfirmDialog(validationAchat.this,
                "Voulez-vous confirmer la commande ?", "Confirmation",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(validationAchat.this,
                "Voulez-vous quitter l'application ?", "Quitter",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
