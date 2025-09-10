package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Date;

public class MainSwingUI {
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            initialisation();
            Menu myMenu = new Menu();
            myMenu.setVisible(true);
        }catch (Exception e) {
            System.out.println("Error au lancement de la vue Swing " + e.getMessage());
        }
    }

    public static void initialisation() {
        try{
            Lieu lieu1 = new Lieu("12 rue de le guerre", "dupontjean@live.fr.com", "+33312345678", "Nancy", 54000);
            Lieu lieu2 = new Lieu("2 rue de la paix", "martinpaul@gmail.com", "+33383813059", "PAM", 54700);
            Lieu lieu3 = new Lieu("55 avenue des malades", "macif@gmail.com", "+33383812010", "Dieulouard", 54380);
            Lieu lieu4 = new Lieu("205 avenue de la liberté", "francemutuelle@live.fr", "+33356843890", "Bordeaux", 33000);
            Lieu lieu5 = new Lieu("10 place Stanislas", "mutuelleverte@live.fr", "+33383391234", "Nancy", 54000);
            Lieu lieu6 = new Lieu("48 rue Nationale", "francemaladie@live.fr", "+33387225678", "Metz", 57000);
            Lieu lieu7 = new Lieu("3 rue Sainte Catherine", "mutuelleeurope@gmail.com", "+33556874532", "Strasbourg", 67000);

            Mutuelle m1 = new Mutuelle("macif", 30, 54, lieu3);
            Mutuelle m2 = new Mutuelle("France Mutuelle", 30, 57, lieu4);
            Mutuelle m3 = new Mutuelle("Mutuelle Verte", 30, 88, lieu5);
            Mutuelle m4 = new Mutuelle("France Maladie", 30, 88, lieu6);
            Mutuelle m5 = new Mutuelle("Mutuelle Europe", 30, 88, lieu7);

            Medecin med1 = new Medecin("Martin", "Paul", "1234567891234", lieu2);
            Medecin med2 = new Medecin("Robert", "François", "2234567891234", lieu3);
            Medecin med3 = new Medecin("Dubois", "Anne", "3234567891234", lieu4);
            Medecin med4 = new Medecin("Morel", "Hélène", "4234567891234", lieu5);
            Medecin med5 = new Medecin("Lefevre", "Julien", "5234567891234", lieu6);

            Patient p1 = new Patient("Dupont", "Jean","16-05-1985", lieu1, m1, med1);
            Patient p2 = new Patient("Martin", "Claire", "20-06-1982", lieu2, m2, med2);
            Patient p3 = new Patient("Durand", "Paul", "19-02-1975", lieu3, m3, med3);
            Patient p4 = new Patient("Petit", "Sophie", "25-10-1973", lieu4, m4, med4);
            Patient p5 = new Patient("Bernard", "Lucas", "22-09-1965", lieu5, m5, med5);

            Commande cmd1 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.DIRECT,
                    "Dr Martin",
                    "Jean Dupont",
                    "Doliprane",
                    2,
                    4.5
            );

            Commande cmd2 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.ORDONNANCE,
                    "Dr Bernard",
                    "Paul Durand",
                    "Amoxicilline",
                    1,
                    12.0
            );

            // Ajout des medicaments dans initialisation
            Medicament medic1 = new Medicament(20, "10-05-2025", 10.50, "Cardiotoniques", "Digoxine");
            Medicament medic2 = new Medicament(50, "02-09-2025", 5.99, "Bêta-bloquants", "Bisoprolol");
            Medicament medic3 = new Medicament(80, "28-05-2025", 9.99, "Diurétiques", "Mannitol");
            Medicament medic4 = new Medicament(120, "22-01-2025", 25.99, "Hypnotiques", "Méthaqualone");
            Medicament medic5 = new Medicament(100, "02-03-2025", 15.99, "Triptans", "Élétriptan");

            // Ajout des mutuelle
            Mutuelle.getMutuelles().add(m1);
            Mutuelle.getMutuelles().add(m2);
            Mutuelle.getMutuelles().add(m3);
            Mutuelle.getMutuelles().add(m4);
            Mutuelle.getMutuelles().add(m5);

            // Ajout des medecins
            Medecin.getMedecins().add(med1);
            Medecin.getMedecins().add(med2);
            Medecin.getMedecins().add(med3);
            Medecin.getMedecins().add(med4);
            Medecin.getMedecins().add(med5);

            // Ajout des patients
            Patient.getPatients().add(p1);
            Patient.getPatients().add(p2);
            Patient.getPatients().add(p3);
            Patient.getPatients().add(p4);
            Patient.getPatients().add(p5);

            // Ajout dans la listes des medicaments
            Medicament.getMedicaments().add(medic1);
            Medicament.getMedicaments().add(medic2);
            Medicament.getMedicaments().add(medic3);
            Medicament.getMedicaments().add(medic4);
            Medicament.getMedicaments().add(medic5);

            System.out.println(m1);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(med1);
            System.out.println(cmd1);
            System.out.println(cmd2);
            System.out.println(Medicament.getMedicaments());
        }catch(Exception e){
            System.out.println("Erreur de la vue initialisation menu swing " + e.getMessage());
        }
    }
}
