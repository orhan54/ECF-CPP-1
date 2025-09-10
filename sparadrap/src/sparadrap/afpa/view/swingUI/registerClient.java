package sparadrap.afpa.view.swingUI;

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
                valider();
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

    private void valider() {
//        int reponse = JOptionPane.showConfirmDialog(registerClient.this,
//                "Voulez-vous ajouter le nouveau client ?", "Quitter",
//                JOptionPane.YES_NO_OPTION);
//        if (reponse == JOptionPane.YES_OPTION) {
//            Patient patients = null;
//            Patient.getPatients().add(patients);
//        }
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
