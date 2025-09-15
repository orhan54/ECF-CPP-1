package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.Lieu;
import sparadrap.afpa.model.Medecin;
import sparadrap.afpa.model.Mutuelle;
import sparadrap.afpa.model.Patient;

import javax.swing.*;
import java.awt.*;

public class registerClient extends JFrame {
    private int id;
    private JPanel contentPane;
    private JPanel logoRegisterClient;
    private JPanel mainRegisterClient;
    private JPanel footerRegisterClient;
    private JButton buttonRetourRegisterClient;
    private JButton buttonValideRegisterClient;
    private JTextField textFieldRegisterNom;
    private JTextField textFieldRegisterPrenom;
    private JTextField textFieldRegisterAdresse;
    private JTextField textFieldRegisterCodePostal;
    private JTextField textFieldRegisterVille;
    private JTextField textFieldRegisterTel;
    private JTextField textFieldRegisterEmail;
    private JTextField textFieldregisterNumSecu;
    private JTextField textFieldRegisterDateNaissance;
    private JLabel titreRegister;
    private JButton quitterButton;
    private JComboBox<String> comboBoxNomMedecin;
    private JComboBox<String> comboBoxMutuelle;

    public registerClient() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(1600, 1000);

        // Attributs fenêtre
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        remplirComboBox();

        this.pack();
        this.setLocationRelativeTo(null);

        // Actions boutons
        buttonRetourRegisterClient.addActionListener(e -> retour());
        buttonValideRegisterClient.addActionListener(e -> {
            try {
                valider();
            } catch (SaisieException ex) {
                JOptionPane.showMessageDialog(this, "Erreur : " + ex.getMessage());
            }
        });
        quitterButton.addActionListener(e -> quitter());
    }

    /**
     * Remplir les JComboBox avec les listes de médecins et mutuelles
     */
    private void remplirComboBox() {
        comboBoxNomMedecin.removeAllItems();
        for (Medecin med : Medecin.getMedecins()) {
            comboBoxNomMedecin.addItem(med.getNom() + " " + med.getPrenom());
        }

        comboBoxMutuelle.removeAllItems();
        for (Mutuelle mut : Mutuelle.getMutuelles()) {
            comboBoxMutuelle.addItem(mut.getNom());
        }
    }

    private void retour() {
        this.dispose();
    }

    private void valider() throws SaisieException {
        try {
            // Champs saisis
            String nom = textFieldRegisterNom.getText();
            String prenom = textFieldRegisterPrenom.getText();
            String adresse = textFieldRegisterAdresse.getText();
            int codePostal = Integer.parseInt(textFieldRegisterCodePostal.getText());
            String ville = textFieldRegisterVille.getText();
            String tel = textFieldRegisterTel.getText();
            String email = textFieldRegisterEmail.getText();
            String numSecu = textFieldregisterNumSecu.getText();
            String dateNaissance = textFieldRegisterDateNaissance.getText();

            // Sélection mutuelle et médecin
            String mutuelleNom = (String) comboBoxMutuelle.getSelectedItem();
            String medecinNomComplet = (String) comboBoxNomMedecin.getSelectedItem();

            Mutuelle mutuelleChoisie = null;
            for (Mutuelle m : Mutuelle.getMutuelles()) {
                if (m.getNom().equals(mutuelleNom)) {
                    mutuelleChoisie = m;
                    break;
                }
            }

            Medecin medecinChoisi = null;
            for (Medecin med : Medecin.getMedecins()) {
                String nomComplet = med.getNom() + " " + med.getPrenom();
                if (nomComplet.equals(medecinNomComplet)) {
                    medecinChoisi = med;
                    break;
                }
            }

            // Création du lieu
            Lieu lieu = new Lieu(adresse, email, tel, ville, codePostal);

            // Création et ajout du nouveau patient
            Patient newPatient = new Patient(nom, prenom, dateNaissance, lieu, mutuelleChoisie, medecinChoisi);
            newPatient.setNumeroSecuriteSociale(numSecu);

            Patient.getPatients().add(newPatient);

            JOptionPane.showMessageDialog(this,
                    "Nouveau patient ajouté avec succès !",
                    "Succès",
                    JOptionPane.INFORMATION_MESSAGE);

            consulterClient consulterClient = new consulterClient();
            consulterClient.setVisible(true);

        } catch (NumberFormatException e) {
            throw new SaisieException("Code postal ou Numéro de sécu invalide !");
        }
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(registerClient.this,
                "Voulez-vous quitter l'application ?", "Quitter",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
