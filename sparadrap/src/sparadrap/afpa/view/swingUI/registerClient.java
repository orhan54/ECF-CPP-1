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

    public registerClient() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(800, 800);

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
    }

    private void retour() {
        this.dispose();
    }

    private void valider() {

    }
}
