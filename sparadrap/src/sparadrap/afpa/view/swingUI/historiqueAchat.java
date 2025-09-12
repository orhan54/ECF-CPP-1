package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.Commande;
import sparadrap.afpa.model.Ordonnance;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

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

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        String[] colonnes = {"Date", "Type achat", "Nom medecin", "Nom patient", "Liste médicaments", "Quantité", "Prix"};
        tableModelHistorique = new DefaultTableModel(colonnes, 0);
        tableHistorique.setModel(tableModelHistorique);

        afficherCommande();
        //filtreComboBox();

        this.pack();
        this.setLocationRelativeTo(null);

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

//    private void filtreComboBox() {
//        comboBoxTypeHistoriqueAchat.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                comboValue = comboBoxTypeHistoriqueAchat.getSelectedItem().toString();
//
//                tableModelHistorique.setRowCount(0);
//
//                for(Commande c : Commande.getCommandes()) {
//                    if(comboValue == "achat direct") {
//                        tableModelHistorique.addRow(new Object[] {
//                                c.getDateCommandeCreation(),
//                                c.getNomMedecin(),
//                                c.getNomPatient(),
//                                c.getNomMedic(),
//                                c.getQuantite(),
//                                c.getPrix()
//                        });
//                    } else if (comboValue == "achat ordonnance") {
//                        tableModelHistorique.addRow(new Object[] {
//                                c.getDateCommandeCreation(),
//                                c.getNomMedecin(),
//                                c.getNomPatient(),
//                                c.getNomMedic(),
//                                c.getQuantite(),
//                                c.getPrix()
//                        });
//
//                    }
//                }
//
//            }
//        });
//    }

    private void afficherCommande() {
        tableModelHistorique.setRowCount(0);

        if(Commande.getCommandes().isEmpty()){
            tableModelHistorique.addRow(new Object[]{"","","","","","",""});
        }else{
            for(Commande commande : Commande.getCommandes()){
                tableModelHistorique.addRow(new Object[]{
                        commande.getDateCommande(),
                        commande.getTypeAchat(),
                        commande.getNomMedecin(),
                        commande.getNomPatient(),
                        commande.getNomMedic(),
                        commande.getQuantite(),
                        commande.getPrix()
                });
            }
        }
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
