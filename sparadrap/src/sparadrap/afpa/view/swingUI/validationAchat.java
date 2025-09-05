package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.Medicament;
import sparadrap.afpa.model.Ordonnance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

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

    private DefaultTableModel tableModel;
    private DefaultTableModel tableModelMedicDispo;

    public validationAchat() {

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(800, 800);

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        // Création du modele de tableau medicament disponible
        String[] colonne = {"quantite", "Date mise en service", "Prix", "Categorie", "Nom"};
        tableModelMedicDispo = new DefaultTableModel(colonne, 0);
        tableMedicDispo.setModel(tableModelMedicDispo);

        // Création du modele de tableau commande medicament
        String[] colonnes = {"Nom medecin", "Nom patient ", "Nom medicament" , "Quantite medic "};
        tableModel = new DefaultTableModel(colonnes, 0);
        tableMedic.setModel(tableModel);

        // Afficher Medicament List dispos ICI
        afficherListeMedicDispo();

        this.pack();
        this.setLocationRelativeTo(null);

        btnRetourAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
        btnValiderAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valider();
            }
        });
        buttonQuitterAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });
        btnAjouterMedicamentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ajouter();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMedic();
            }
        });
    }

    private  void ajouter() throws SaisieException {
        String nomMedecin = inputNomMedecin.getText().trim().toUpperCase();
        String nomPatient = inputNomPatient.getText().trim().toUpperCase();
        String nomMedic = inputNomMedic.getText().trim().toUpperCase();
        int quantite = Integer.parseInt(inputQuantiteMedic.getText().trim());


        try{
            quantite = Integer.parseInt(inputQuantiteMedic.getText().trim());
        }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La quantité doit etre un nombre entier",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(nomMedecin.equals("") && nomPatient.equals("") && nomMedic.equals("")){
            JOptionPane.showMessageDialog(this,
                    "Le nom du medecin, du patient et du medicament ne peuvent pas etre vides",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(!regexAlpha(nomMedecin) || !regexAlpha(nomPatient) || !regexAlpha(nomMedic)){
            JOptionPane.showMessageDialog(this,
                    "Error sur le nom du medecin et le nom du patient",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        Ordonnance ordonnance = new Ordonnance(nomMedecin, nomPatient, nomMedic, quantite);
        Ordonnance.getOrdonnances().add(ordonnance);

        JOptionPane.showMessageDialog(this,
                "Votre medicament est bien saisie",
                "Succès", JOptionPane.ERROR_MESSAGE);

        System.out.println("Votre medicament est bien saisie" + ordonnance);
    }

    private void afficherListeMedicDispo() {
        tableModelMedicDispo.setRowCount(0);

        if(Medicament.getMedicaments().isEmpty()){
            tableModelMedicDispo.addRow(new Object []{"-", "Aucun medicament", "", ""});
        }else{
            for(Medicament medicaments : Medicament.getMedicaments()) {
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

    }

    private void retour() {
        this.dispose();
    }

    private void valider() {

    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(validationAchat.this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
