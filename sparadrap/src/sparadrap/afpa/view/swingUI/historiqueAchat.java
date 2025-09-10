package sparadrap.afpa.view.swingUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class historiqueAchat extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBoxTypeHistoriqueAchat;
    private JTextField textFieldDateAchatDu;
    private JTextField textFieldDateAchatAu;
    private JButton buttonRetourHistorique;
    private JButton buttonValiderHistorique;
    private JButton buttonQuitterHistorique;
    private JLabel titreHistorique;
    private JTable tableHistorique;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JScrollBar scrollBar1;

    public historiqueAchat() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(1600, 1000);

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        this.pack();
        this.setLocationRelativeTo(null);

        comboBoxTypeHistoriqueAchat.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                selectTypeAchat();
            }
        });
        buttonRetourHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });

        buttonValiderHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valider();
            }
        });
        buttonQuitterHistorique.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });
    }

    private void selectTypeAchat() {

    }

    private void valider() {

    }

    private void retour() {
        this.dispose();
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(historiqueAchat.this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
