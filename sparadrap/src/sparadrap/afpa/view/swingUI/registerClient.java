package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.Lieu;
import sparadrap.afpa.model.Medecin;
import sparadrap.afpa.model.Mutuelle;
import sparadrap.afpa.model.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerClient extends JFrame{
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
    private JTextField textFieldRegisterMutuelle;
    private JLabel titreRegister;
    private JButton quitterButton;
    private JComboBox comboBoxNomMedecin;
    private JComboBox comboBoxMutuelle;
    private Lieu Lieu;
    private Mutuelle Mutuelle;
    private Medecin Medecin;

    public registerClient() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(800, 900);

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(null);

        buttonRetourRegisterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
        buttonValideRegisterClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valider();
                } catch (SaisieException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });
    }

    private void retour() {
        this.dispose();
    }

    private void valider() throws SaisieException {
        String nom = textFieldRegisterNom.getText();
        String prenom = textFieldRegisterPrenom.getText();
        String adresse = textFieldRegisterAdresse.getText();
        String pCodePostal = textFieldRegisterCodePostal.getText();
        String ville = textFieldRegisterVille.getText();
        String tel = textFieldRegisterTel.getText();
        String email = textFieldregisterNumSecu.getText();
        int numSecu = Integer.parseInt(textFieldRegisterMutuelle.getText());
        String dateNaissance = textFieldRegisterDateNaissance.getText();
        String mutuelle = (String)comboBoxMutuelle.getSelectedItem();
        String nomMedecin = (String)comboBoxNomMedecin.getSelectedItem();

        int reponse = JOptionPane.showConfirmDialog(registerClient.this,
                "Voulez-vous ajouter le nouveau client ?", "Quitter",
                JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            Patient newPatient = new Patient(nom, prenom, adresse, Lieu , Mutuelle , Medecin);
            newPatient.setNom(nom);
            newPatient.setPrenom(prenom);
            newPatient.getLieu().setAdresse(adresse);
            newPatient.getLieu().setVille(ville);
            newPatient.getLieu().setCodePostal(Integer.parseInt(pCodePostal));
            newPatient.getLieu().setTelephone(tel);
            newPatient.getLieu().setEmail(email);
            newPatient.setNumeroSecuriteSociale(String.valueOf(numSecu));
            newPatient.setDateNaissance(dateNaissance);
            newPatient.getMutuelle().setNom(mutuelle);
            newPatient.getMedecin().setNom(nomMedecin);
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
