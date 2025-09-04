package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.Medicament;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static sparadrap.afpa.utility.RegexUtility.positifInt;
import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class validationAchat extends JFrame {
    private JPanel contentPane;
    private JComboBox comboBoxValideAchat;
    private JList list1;
    private JButton buttonRetourAchat;
    private JButton buttonValiderAchat;
    private JButton buttonQuitterAchat;
    private JLabel titreValideAchat;
    private JTextField textFieldInputNomMedic;
    private JTextField textFieldInputQuantiteMedic;
    private JButton buttonAjouterMedicamentList;

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

        this.pack();
        this.setLocationRelativeTo(null);

        buttonRetourAchat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
        buttonValiderAchat.addActionListener(new ActionListener() {
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
        buttonAjouterMedicamentList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouter();
            }
        });
    }

    private void ajouter() {
//        String nomMedicament = textFieldInputNomMedic.getText();
//        String quantiteMedicament = textFieldInputQuantiteMedic.getText();
//        try{
//            if (nomMedicament == null || quantiteMedicament == null) {
//                System.out.println("Error les champs ne peut pas etre vide");
//            } else if (!regexAlpha(nomMedicament) || !positifInt(quantiteMedicament)) {
//                System.out.println("Error dans les champs nom ou quantité");
//            }else{
//                Medicament.getMedicaments().add(nomMedicament);
//                Medicament.getMedicaments().add(quantiteMedicament);
//            }
//        }catch(Exception ex){
//            System.out.println("Error dans l'ajoute du medicament !" + ex.getMessage());
//        }
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
