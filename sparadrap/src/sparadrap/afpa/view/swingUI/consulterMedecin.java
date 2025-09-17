package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.Medecin;
import sparadrap.afpa.model.Ordonnance;
import sparadrap.afpa.model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class consulterMedecin extends JFrame {
    private JPanel contentPane;
    private JLabel titreMenu;
    private JTable tableMedecin;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton quitterButton;
    private JButton retourButton;
    private JComboBox<String> comboBoxMedecin;
    private JButton créerUnMédecinButton;
    private JComboBox comboBoxInformation;
    private JTable tableFiltreInformation;
    private JLabel titreFiltreInfo;
    private String selectedValue;

    private DefaultTableModel tableModelMedecin;

    private String[] HEADER_PATIENT = new String[] {"id", "Nom", "Prenom", "Adresse", "Code postal", "Ville", "Téléphone", "Email", "Numero sécurité social", "Date de naissance", "Mutuelle", "Medecin"};
    private String[] HEADER_ORDONNANCE = new String[] {"Date", "Nom médecin", "Nom patient", "Liste des médicaments"};

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

        comboBoxInformation.addItem("Choisir le filtre...");
        comboBoxInformation.addItem("Liste des patients du médecin");
        comboBoxInformation.addItem("Liste des ordonnances du médecin");

        comboBoxInformation.setSelectedIndex(0);

        remplirComboBox();
        displayInformation();
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
        créerUnMédecinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creerMedecin();
            }
        });
        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMedecin();
            }
        });
        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMedecin();
            }
        });
    }

    public void displayInformation() {
        switch (comboBoxMedecin.getSelectedIndex()) {
            case 0:
                titreMenu.setText("Choisir un filtre : ");
            case 1:
                titreFiltreInfo.setText("Listes des patients : ");
                configureTable(Patient.getPatients(), HEADER_PATIENT);
                constructDataTable(Patient.getPatients(), HEADER_PATIENT);
                break;
            case 2:
//                titreFiltreInfo.setText("Liste des ordonnances : ");
//                configureTable(Ordonnance.getOrdonnances(), HEADER_ORDONNANCE);
//                constructDataTable(Ordonnance.getOrdonnances(), HEADER_ORDONNANCE);
//                break;
        }
    }

    private <T> void configureTable(List<Patient> patients, String[] header) {
        TableModel model = new DefaultTableModel(header, 0);
        this.tableFiltreInformation.setModel(model);
        this.tableFiltreInformation.revalidate();
        this.tableFiltreInformation.repaint();
    }

    private <T> void constructDataTable(List<T> dataListe, String[] header) {
        // Création des données tu tableau filtre
        String[][] data = new String[dataListe.size()][header.length];

        // Remplissage du tableau selon le filtre
        for (int i = 0; i < dataListe.size(); i++) {
            Object obj = dataListe.get(i);
            if(obj instanceof Patient) {
                Patient p = (Patient) obj;
                data[i][0] = String.valueOf(p.getId());
                data[i][1] = p.getNom();
                data[i][2] = p.getPrenom();
                data[i][3] = p.getLieu().getAdresse();
                data[i][4] = String.valueOf(p.getLieu().getCodePostal());
                data[i][5] = p.getLieu().getVille();
                data[i][6] = p.getLieu().getTelephone();
                data[i][7] = String.valueOf(p.getLieu().getEmail());
                data[i][8] = p.getNumeroSecuriteSociale();
                data[i][9] = p.getDateNaissance();
                data[i][10] = String.valueOf(p.getMutuelle());
                data[i][11] = String.valueOf(p.getMedecin());
            }else if(obj instanceof Ordonnance) {
                Ordonnance o = (Ordonnance) obj;
                data[i][0] = o.getDate();
                data[i][1] = o.getNomMedecin();
                data[i][2] = o.getNomPatient();
                data[i][3] = o.getMedicaments().toString();
            }
        }
    }

    private void remplirComboBox() {
        comboBoxMedecin.removeAllItems();

        comboBoxMedecin.addItem("Choisir un médecin");
        comboBoxMedecin.setSelectedIndex(0);

        for(Medecin m : Medecin.getMedecins()) {
            comboBoxMedecin.addItem(m.getNom() + " " + m.getPrenom());
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

    private void creerMedecin() {
        registerMedecin registerMedecin = new registerMedecin();
        try{
            registerMedecin.setVisible(true);
        }catch(Exception e){
            System.out.println("Error sur le lancement de la view creation d'un médecin" +e.getMessage());
        }
    }

    private void updateMedecin() {
        try{
            String selected = (String) comboBoxMedecin.getSelectedItem();
            for(Medecin m : Medecin.getMedecins()) {
                if(selectedValue.equals(m.getNom() + " " + m.getPrenom())) {
                    registerMedecin updateMedecin = new registerMedecin(m);
                    updateMedecin.setVisible(true);
                    System.out.println(m);
                }
            }
        }catch(Exception e){
            System.out.println("Error au lancement de la view updateMedecin" +e.getMessage());
        }
    }

    private void deleteMedecin() {
        int selectedRow = tableMedecin.getSelectedRow();

        if(selectedRow >= 0 && selectedValue != null) {
            Medecin medecinToRemove = null;
            for(Medecin m : Medecin.getMedecins()) {
                if(selectedValue.equals(m.getNom() + " " + m.getPrenom())) {
                    medecinToRemove = m;
                    break;
                }
            }

            if(medecinToRemove != null) {
                Medecin.getMedecins().remove(medecinToRemove);

                // Mise à jour comboBox
                comboBoxMedecin.removeItem(selectedValue);

                // Vider le tableau après suppression
                tableModelMedecin.setRowCount(0);

                // Rénitialiser la selection
                selectedValue = null;
                comboBoxMedecin.setSelectedIndex(0); // revient sur "Choisir un médecin"

            }
        }
    }

//    private void afficherMedecin() {  // *** Afficher tout les medecins ***
//        tableModelMedecin.setRowCount(0);
//
//        if(Medecin.getMedecins().isEmpty()) {
//            tableModelMedecin.addRow(new Object[]{"", "", "", "", "", "", ""});
//        }else{
//            for(Medecin m : Medecin.getMedecins()) {
//                tableModelMedecin.addRow(new Object[]{
//                        m.getNom(),
//                        m.getPrenom(),
//                        m.getLieu().getAdresse(),
//                        m.getLieu().getCodePostal(),
//                        m.getLieu().getVille(),
//                        m.getLieu().getTelephone(),
//                        m.getLieu().getEmail(),
//                        m.getNumeroAgreement()
//                });
//            }
//        }
//    }

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
