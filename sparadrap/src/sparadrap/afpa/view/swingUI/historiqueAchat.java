package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.Commande;
import sparadrap.afpa.model.Medicament;
import sparadrap.afpa.model.Ordonnance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class historiqueAchat extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBoxTypeHistoriqueAchat;
    private JTextField textFieldDate1; // Date debut
    private JTextField textFieldDate2; // Date fin
    private JButton buttonRetourHistorique;
    private JButton buttonValiderHistorique;
    private JButton buttonQuitterHistorique;
    private JLabel titreHistorique;
    private JTable tableHistorique;
    private JScrollBar scrollBar1;
    private String comboValue;

    private DefaultTableModel tableModelHistorique;

    public historiqueAchat() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(1600, 1000);

        // Les attributs
        this.setTitle("Sparadrap - Historique des Achats");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        // Colonnes adaptées à la nouvelle structure
        String[] colonnes = {"Date", "Type achat", "Nom medecin", "Nom patient", "Médicaments", "Quantité totale", "Prix total"};
        tableModelHistorique = new DefaultTableModel(colonnes, 0);
        tableHistorique.setModel(tableModelHistorique);

        // Initialisation des composants
        initialiserComboBox();
        afficherCommandes();

        // Ajout des placeholders pour les champs de date
        textFieldDate1.setToolTipText("Format: dd/MM/yyyy");
        textFieldDate2.setToolTipText("Format: dd/MM/yyyy");

        this.pack();
        this.setLocationRelativeTo(null);

        // Listeners
        buttonRetourHistorique.addActionListener(e -> retour());
        buttonValiderHistorique.addActionListener(e -> valider());
        buttonQuitterHistorique.addActionListener(e -> quitter());

        // Listener pour le filtre par type
        comboBoxTypeHistoriqueAchat.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                appliquerFiltres();
            }
        });
    }

    private void initialiserComboBox() {
        comboBoxTypeHistoriqueAchat.removeAllItems();
        comboBoxTypeHistoriqueAchat.addItem("Tous");
        comboBoxTypeHistoriqueAchat.addItem("DIRECT");
        comboBoxTypeHistoriqueAchat.addItem("ORDONNANCE");
    }

    private void afficherCommandes() {
        tableModelHistorique.setRowCount(0);

        if (Commande.getCommandes().isEmpty()) {
            tableModelHistorique.addRow(new Object[]{"Aucune commande", "", "", "", "", "", ""});
        } else {
            for (Commande commande : Commande.getCommandes()) {
                String medicamentsStr = construireChaineListeMedicaments(commande);

                tableModelHistorique.addRow(new Object[]{
                        commande.getDateCommandeCreation(),
                        commande.getTypeAchat().toString(),
                        commande.getNomMedecin(),
                        commande.getNomPatient(),
                        medicamentsStr,
                        commande.getQuantite(),
                        String.format("%.2f€", commande.getPrix())
                });
            }
        }
    }

    private String construireChaineListeMedicaments(Commande commande) {
        if (commande.getMedicaments() == null || commande.getMedicaments().isEmpty()) {
            return "Aucun médicament";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commande.getMedicaments().size(); i++) {
            Medicament med = commande.getMedicaments().get(i);
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(med.getNom()).append(" (").append(med.getQuantite()).append(")");
        }

        // Limiter la longueur pour l'affichage dans le tableau
        String result = sb.toString();
        if (result.length() > 50) {
            return result.substring(0, 47) + "...";
        }
        return result;
    }

    private void appliquerFiltres() {
        tableModelHistorique.setRowCount(0);

        String typeFiltre = comboBoxTypeHistoriqueAchat.getSelectedItem().toString();
        LocalDate dateDebut = null;
        LocalDate dateFin = null;

        // Parsing des dates si renseignées
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            if (!textFieldDate1.getText().trim().isEmpty()) {
                dateDebut = LocalDate.parse(textFieldDate1.getText().trim(), formatter);
            }
        } catch (DateTimeParseException e) {
            // Ignorer les erreurs de parsing pour l'instant
        }

        try {
            if (!textFieldDate2.getText().trim().isEmpty()) {
                dateFin = LocalDate.parse(textFieldDate2.getText().trim(), formatter);
            }
        } catch (DateTimeParseException e) {
            // Ignorer les erreurs de parsing pour l'instant
        }

        if (Commande.getCommandes().isEmpty()) {
            tableModelHistorique.addRow(new Object[]{"Aucune commande", "", "", "", "", "", ""});
            return;
        }

        for (Commande commande : Commande.getCommandes()) {
            boolean afficher = true;

            // Filtre par type
            if (!"Tous".equals(typeFiltre)) {
                if (!commande.getTypeAchat().toString().equals(typeFiltre)) {
                    afficher = false;
                }
            }

            // Filtre par date
            if (afficher && (dateDebut != null || dateFin != null)) {
                LocalDate dateCommande = commande.getDateCommande().toLocalDate();

                if (dateDebut != null && dateCommande.isBefore(dateDebut)) {
                    afficher = false;
                }

                if (dateFin != null && dateCommande.isAfter(dateFin)) {
                    afficher = false;
                }
            }

            if (afficher) {
                String medicamentsStr = construireChaineListeMedicaments(commande);

                tableModelHistorique.addRow(new Object[]{
                        commande.getDateCommandeCreation(),
                        commande.getTypeAchat().toString(),
                        commande.getNomMedecin(),
                        commande.getNomPatient(),
                        medicamentsStr,
                        commande.getQuantite(),
                        String.format("%.2f€", commande.getPrix())
                });
            }
        }

        // Afficher un message si aucun résultat
        if (tableModelHistorique.getRowCount() == 0) {
            tableModelHistorique.addRow(new Object[]{"Aucun résultat", "pour les critères", "de recherche", "sélectionnés", "", "", ""});
        }
    }

    private void valider() {
        // Validation des dates avant application des filtres
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dateValide = true;

        if (!textFieldDate1.getText().trim().isEmpty()) {
            try {
                LocalDate.parse(textFieldDate1.getText().trim(), formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this,
                        "Format de date début invalide. Utilisez le format dd/MM/yyyy",
                        "Erreur de date", JOptionPane.ERROR_MESSAGE);
                dateValide = false;
            }
        }

        if (!textFieldDate2.getText().trim().isEmpty() && dateValide) {
            try {
                LocalDate.parse(textFieldDate2.getText().trim(), formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(this,
                        "Format de date fin invalide. Utilisez le format dd/MM/yyyy",
                        "Erreur de date", JOptionPane.ERROR_MESSAGE);
                dateValide = false;
            }
        }

        // Vérifier que la date de début n'est pas postérieure à la date de fin
        if (dateValide && !textFieldDate1.getText().trim().isEmpty() && !textFieldDate2.getText().trim().isEmpty()) {
            try {
                LocalDate debut = LocalDate.parse(textFieldDate1.getText().trim(), formatter);
                LocalDate fin = LocalDate.parse(textFieldDate2.getText().trim(), formatter);

                if (debut.isAfter(fin)) {
                    JOptionPane.showMessageDialog(this,
                            "La date de début ne peut pas être postérieure à la date de fin",
                            "Erreur de période", JOptionPane.ERROR_MESSAGE);
                    dateValide = false;
                }
            } catch (DateTimeParseException e) {
                // Déjà géré plus haut
            }
        }

        if (dateValide) {
            appliquerFiltres();
            JOptionPane.showMessageDialog(this,
                    "Filtres appliqués avec succès !",
                    "Filtrage", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void retour() {
        this.dispose();
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