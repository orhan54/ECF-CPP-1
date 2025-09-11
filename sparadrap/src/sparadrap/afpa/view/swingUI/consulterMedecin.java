package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.Medecin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class consulterMedecin extends JFrame {
    private JPanel contentPane;
    private JLabel titreMenu;
    private JTable tableMedecin;
    private JButton creerButton;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton quitterButton;
    private JButton retourButton;
    private JButton infoButton;
    private JComboBox<String> comboBoxMedecin;
    private String selectedValue;

    private DefaultTableModel tableModelMedecin;

    public consulterMedecin() {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(1600, 1000);

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        String[] colonnes = {"Nom", "Prénom", "Adresse", "Code postal", "Ville", "Téléphone", "Email", "Numéro d'agréement"};
        tableModelMedecin = new DefaultTableModel(colonnes, 0);
        tableMedecin.setModel(tableModelMedecin);

        remplirComboBox();
        //afficherMedecin();

        this.pack();
        this.setLocationRelativeTo(null);


        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retour();
            }
        });
        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quitter();
            }
        });
    }

    private void remplirComboBox() {
        comboBoxMedecin.removeAllItems();
        for(Medecin m : Medecin.getMedecins()) {
            if(comboBoxMedecin.getItemCount() < 1) {
                comboBoxMedecin.addItem("Choisir un medecin");
                comboBoxMedecin.setSelectedIndex(0);
            }else{
                comboBoxMedecin.addItem(m.getNom() + " " + m.getPrenom());
            }
        }
        comboBoxMedecin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                e.getSource();

                String selected = (String) comboBoxMedecin.getSelectedItem();
                selectedValue = selected;

                if(selected.equals(comboBoxMedecin.getSelectedItem())) {
                    tableModelMedecin.setRowCount(0);

                    for(Medecin m : Medecin.getMedecins()) {
                        if(selectedValue.equals(m.getNom() + " " + m.getPrenom())) {
                            tableModelMedecin.addRow(new Object[]{
                                m.getNom(),
                                m.getPrenom(),
                                m.getLieu().getAdresse(),
                                m.getLieu().getCodePostal(),
                                m.getLieu().getVille(),
                                m.getLieu().getTelephone(),
                                m.getLieu().getEmail(),
                                m.getNumeroAgreement()
                            });
                        }
                    }
                }

            }
        });
    }

    private void afficherMedecin() {
        tableModelMedecin.setRowCount(0);

        if(Medecin.getMedecins().isEmpty()) {
            tableModelMedecin.addRow(new Object[]{"", "", "", "", "", "", ""});
        }else{
            for(Medecin m : Medecin.getMedecins()) {
                tableModelMedecin.addRow(new Object[]{
                        m.getNom(),
                        m.getPrenom(),
                        m.getLieu().getAdresse(),
                        m.getLieu().getCodePostal(),
                        m.getLieu().getVille(),
                        m.getLieu().getTelephone(),
                        m.getLieu().getEmail(),
                        m.getNumeroAgreement()
                });
            }
        }
    }

    private void retour() {
        this.dispose();
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(consulterMedecin.this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

}
