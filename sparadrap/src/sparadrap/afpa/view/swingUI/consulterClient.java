package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.exception.SaisieException;
import sparadrap.afpa.model.Patient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class consulterClient extends JFrame {
    private JPanel contentPane;
    private JLabel titreMenu;
    private JTable tableClient;
    private JButton modifierButton;
    private JButton supprimerButton;
    private JButton retourButton;
    private JButton infoButton;
    private JButton quitterButton;
    private JButton créerUnCompteButton;
    private JButton creerButton;

    private DefaultTableModel tableModelClient;

    public consulterClient() throws SaisieException {
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\Desktop\\ECF-CPP1_CICEK_Orhan\\ECF-CPP-1\\sparadrap\\src\\sparadrap\\afpa\\image\\miniLogo.png");
        Dimension dimension = new Dimension(800, 900);

        //les attributs
        this.setTitle("Sparadrap");
        this.setIconImage(imageIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(dimension);
        this.setResizable(false);
        this.setContentPane(contentPane);

        String[] colonnes = {"Nom", "Prenom", "Adresse", "Code postal", "Ville", "Téléphone", "Email", "Numero sécurité social", "Date de naissance", "Mutuelle", "Medecin"};
        tableModelClient = new DefaultTableModel(colonnes, 0);
        tableClient.setModel(tableModelClient);

        // Afficher les clients
        afficherClient();

        this.pack();
        this.setLocationRelativeTo(null);

        créerUnCompteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClient();
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClient();
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClient();
            }
        });

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

    private void afficherClient() throws SaisieException {
        tableModelClient.setRowCount(0);

        if(Patient.getPatients().isEmpty()) {
            tableModelClient.addRow(new Object[]{"Aucun client"});
        }else{
            for (Patient patients : Patient.getPatients()) {
                tableModelClient.addRow(new Object[]{
                    patients.getNom(),
                    patients.getPrenom(),
                    patients.getLieu().getAdresse(),
                    patients.getLieu().getCodePostal(),
                    patients.getLieu().getVille(),
                    patients.getLieu().getTelephone(),
                    patients.getLieu().getEmail(),
                    patients.getNumeroSecuriteSociale(),
                    patients.getDateNaissance(),
                    patients.getMutuelle()
                });
            }
        }
    }

    private void addClient() {
        registerClient registerClient = new registerClient();
        try {
            registerClient.setVisible(true);
        }catch(Exception e){
            System.out.println("Erreur sur la vue créer un client" + e.getMessage());
        }
    }

    private void updateClient() {

    }

    private void deleteClient() {
        int selectedRow = tableClient.getSelectedRow();
        if (selectedRow >= 0) {
            tableModelClient.removeRow(selectedRow);
        }
    }

    private void retour() {
        this.dispose();
    }

    private void quitter() {
        int reponse = JOptionPane.showConfirmDialog(consulterClient.this, "Voulez-vous quitter l'application ?", "Quitter", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
