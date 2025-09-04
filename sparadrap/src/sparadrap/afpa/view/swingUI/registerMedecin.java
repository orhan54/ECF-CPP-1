package sparadrap.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registerMedecin extends JFrame {
    private JPanel contentPane;
    private JPanel titreRegisterMedecin;
    private JPanel mainRegisterMedecin;
    private JPanel footerRegisterMedecin;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JButton buttonRetourRegisterMedecin;
    private JButton buttonValideRegisterMedecin;

    public registerMedecin() {
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

        buttonRetourRegisterMedecin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
        buttonValideRegisterMedecin.addActionListener(new ActionListener() {
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
