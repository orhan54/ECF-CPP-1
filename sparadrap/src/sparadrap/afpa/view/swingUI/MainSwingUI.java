package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
            // Création des lieux
            Lieu lieu1 = new Lieu("12 rue de le guerre", "dupontjean@live.fr.com", "+33312345678", "Nancy", 54000);
            Lieu lieu2 = new Lieu("2 rue de la paix", "martinpaul@gmail.com", "+33383813059", "PAM", 54700);
            Lieu lieu3 = new Lieu("55 avenue des malades", "macif@gmail.com", "+33383812010", "Dieulouard", 54380);
            Lieu lieu4 = new Lieu("205 avenue de la liberté", "francemutuelle@live.fr", "+33356843890", "Bordeaux", 33000);
            Lieu lieu5 = new Lieu("10 place Stanislas", "mutuelleverte@live.fr", "+33383391234", "Nancy", 54000);
            Lieu lieu6 = new Lieu("48 rue Nationale", "francemaladie@live.fr", "+33387225678", "Metz", 57000);
            Lieu lieu7 = new Lieu("3 rue Sainte Catherine", "mutuelleeurope@gmail.com", "+33556874532", "Strasbourg", 67000);

            // Création des medicaments
            Medicament medic1 = new Medicament(5, "10-05-2025", 10.50, "Cardiotoniques", "Digoxine");
            Medicament medic2 = new Medicament(2, "02-09-2025", 5.99, "Bêta-bloquants", "Bisoprolol");
            Medicament medic3 = new Medicament(6, "28-05-2025", 9.99, "Diurétiques", "Mannitol");
            Medicament medic4 = new Medicament(2, "22-01-2025", 25.99, "Hypnotiques", "Méthaqualone");
            Medicament medic5 = new Medicament(4, "02-03-2025", 15.99, "Triptans", "Élétriptan");

            // Médicaments supplémentaires pour les commandes
            Medicament medic6 = new Medicament(10, "15-04-2025", 8.50, "Antibiotiques", "Amoxicilline");

            // Création de 5 ordonnances avec différents médicaments
            // Ordonnance 1 - Dr Martin pour Jean Dupont (2 médicaments)
            List<Medicament> medicamentsOrdo1 = new ArrayList<>();
            medicamentsOrdo1.add(medic1); // Digoxine
            medicamentsOrdo1.add(medic2); // Bisoprolol
            Ordonnance ordo1 = new Ordonnance("12/05/2025","Dr Martin Paul", "Jean Dupont", medicamentsOrdo1);

            // Ordonnance 2 - Dr Robert pour Claire Martin (1 médicament)
            List<Medicament> medicamentsOrdo2 = new ArrayList<>();
            medicamentsOrdo2.add(medic3); // Mannitol
            Ordonnance ordo2 = new Ordonnance("20/06/2025","Dr Robert François", "Claire Martin", medicamentsOrdo2);

            // Ordonnance 3 - Dr Dubois pour Paul Durand (3 médicaments)
            List<Medicament> medicamentsOrdo3 = new ArrayList<>();
            medicamentsOrdo3.add(medic1); // Digoxine
            medicamentsOrdo3.add(medic4); // Méthaqualone
            medicamentsOrdo3.add(medic5); // Élétriptan
            Ordonnance ordo3 = new Ordonnance("28/07/2025","Dr Dubois Anne", "Paul Durand", medicamentsOrdo3);

            // Ordonnance 4 - Dr Morel pour Sophie Petit (2 médicaments)
            List<Medicament> medicamentsOrdo4 = new ArrayList<>();
            medicamentsOrdo4.add(medic2); // Bisoprolol
            medicamentsOrdo4.add(medic3); // Mannitol
            Ordonnance ordo4 = new Ordonnance("29/07/2025","Dr Morel Hélène", "Sophie Petit", medicamentsOrdo4);

            // Ordonnance 5 - Dr Lefevre pour Lucas Bernard (1 médicament)
            List<Medicament> medicamentsOrdo5 = new ArrayList<>();
            medicamentsOrdo5.add(medic5); // Élétriptan
            Ordonnance ordo5 = new Ordonnance("05/08/2025","Dr Lefevre Julien", "Lucas Bernard", medicamentsOrdo5);

            // Création des mutuelles
            Mutuelle m1 = new Mutuelle("Macif", 30, 54, lieu3);
            Mutuelle m2 = new Mutuelle("France Mutuelle", 30, 57, lieu4);
            Mutuelle m3 = new Mutuelle("Mutuelle Verte", 30, 88, lieu5);
            Mutuelle m4 = new Mutuelle("France Maladie", 30, 88, lieu6);
            Mutuelle m5 = new Mutuelle("Mutuelle Europe", 30, 88, lieu7);

            // Création des médecins
            Medecin med1 = new Medecin("Dr Martin", "Paul", "1234567891234", lieu2);
            Medecin med2 = new Medecin("Dr Robert", "François", "2234567891234", lieu3);
            Medecin med3 = new Medecin("Dr Dubois", "Anne", "3234567891234", lieu4);
            Medecin med4 = new Medecin("Dr Morel", "Hélène", "4234567891234", lieu5);
            Medecin med5 = new Medecin("Dr Lefevre", "Julien", "5234567891234", lieu6);

            // Création des patients
            Patient p1 = new Patient("Dupont", "Jean","16-05-1985", lieu1, m1, med1);
            Patient p2 = new Patient("Martin", "Claire","20-06-1982", lieu2, m2, med2);
            Patient p3 = new Patient("Durand", "Paul","19-02-1975", lieu3, m3, med3);
            Patient p4 = new Patient("Petit", "Sophie", "25-10-1973", lieu4, m4, med4);
            Patient p5 = new Patient("Bernard", "Lucas", "22-09-1965", lieu5, m5, med5);

            // Création des commandes avec dates différentes
            // Commande 1 - Achat direct (pas de mutuelle)
            List<Medicament> medicamentsCmd1 = new ArrayList<>();
            medicamentsCmd1.add(medic1); // Digoxine
            Commande cmd1 = new Commande(Date.valueOf("2025-05-12"),
                    Commande.TypeAchat.DIRECT,
                    "Dr Martin",
                    "Jean Dupont",
                    medicamentsCmd1,
                    2,
                    21.0
            );

            // Commande 2 - Ordonnance avec mutuelle
            List<Medicament> medicamentsCmd2 = new ArrayList<>();
            medicamentsCmd2.add(medic6); // Amoxicilline
            Commande cmd2 = new Commande(Date.valueOf("2025-06-15"),
                    Commande.TypeAchat.ORDONNANCE,
                    "Dr Bernard",
                    "Paul Durand",
                    medicamentsCmd2,
                    5,
                    42.5,
                    true // prise en charge mutuelle activée
            );

            // Commande 3 - Achat direct (pas de mutuelle)
            List<Medicament> medicamentsCmd3 = new ArrayList<>();
            medicamentsCmd3.add(medic3); // Mannitol
            medicamentsCmd3.add(medic2); // Bisoprolol
            Commande cmd3 = new Commande(Date.valueOf("2025-07-01"),
                    Commande.TypeAchat.DIRECT,
                    "Dr Bernard",
                    "Paul Durand",
                    medicamentsCmd3,
                    4,
                    63.92
            );

            // Commande 4 - Achat direct avec un seul médicament
            Commande cmd4 = new Commande(Date.valueOf("2025-07-20"),
                    Commande.TypeAchat.DIRECT,
                    "Dr Bernard",
                    "Paul Durand",
                    medic4, // Méthaqualone
                    6,
                    155.94
            );

            // Commande 5 - Ordonnance avec mutuelle
            List<Medicament> medicamentsCmd5 = new ArrayList<>();
            medicamentsCmd5.add(medic5); // Élétriptan
            medicamentsCmd5.add(medic1); // Digoxine
            Commande cmd5 = new Commande(Date.valueOf("2025-08-05"),
                    Commande.TypeAchat.ORDONNANCE,
                    "Dr Bernard",
                    "Paul Durand",
                    medicamentsCmd5,
                    8,
                    210.0,
                    true // prise en charge mutuelle activée
            );

            // Ajout des mutuelles dans la liste statique
            System.out.println("=== MUTUELLES CRÉÉES ===");
            Mutuelle.getMutuelles().add(m1);
            Mutuelle.getMutuelles().add(m2);
            Mutuelle.getMutuelles().add(m3);
            Mutuelle.getMutuelles().add(m4);
            Mutuelle.getMutuelles().add(m5);

            // Ajout des medecins dans la liste statique
            System.out.println("=== MEDECINS CRÉÉES ===");
            Medecin.getMedecins().add(med1);
            Medecin.getMedecins().add(med2);
            Medecin.getMedecins().add(med3);
            Medecin.getMedecins().add(med4);
            Medecin.getMedecins().add(med5);

            // Ajout des patients dans la liste statique
            System.out.println("=== PATIENTS CRÉÉES ===");
            Patient.getPatients().add(p1);
            Patient.getPatients().add(p2);
            Patient.getPatients().add(p3);
            Patient.getPatients().add(p4);
            Patient.getPatients().add(p5);

            // Ajout dans la liste des medicaments
            System.out.println("=== MEDICAMENTS CRÉÉES ===");
            Medicament.getMedicaments().add(medic1);
            Medicament.getMedicaments().add(medic2);
            Medicament.getMedicaments().add(medic3);
            Medicament.getMedicaments().add(medic4);
            Medicament.getMedicaments().add(medic5);
            Medicament.getMedicaments().add(medic6); // Ajout du médicament supplémentaire

            // Ajout des commandes
            System.out.println("=== COMMANDES CRÉÉES ===");
            Commande.getCommandes().add(cmd1);
            Commande.getCommandes().add(cmd2);
            Commande.getCommandes().add(cmd3);
            Commande.getCommandes().add(cmd4);
            Commande.getCommandes().add(cmd5);

            // Affichage des informations
            System.out.println("=== INFORMATIONS CRÉÉES ===");
            System.out.println(m1);
            System.out.println(p1);
            System.out.println(p2);
            System.out.println(med1);

            // Affichage des commandes avec les nouvelles informations
            System.out.println("=== COMMANDES AVEC MÉDICAMENTS ===");
            System.out.println(cmd1);
            System.out.println(cmd2);
            System.out.println(cmd3);
            System.out.println(cmd4);
            System.out.println(cmd5);

            System.out.println("Medicaments disponibles : " + "\n" + Medicament.getMedicaments());

            // Affichage des ordonnances créées
            System.out.println("=== ORDONNANCES CRÉÉES ===");
            System.out.println(ordo1);
            System.out.println(ordo2);
            System.out.println(ordo3);
            System.out.println(ordo4);
            System.out.println(ordo5);

        }catch(Exception e){
            System.out.println("Erreur de la vue initialisation menu swing " + e.getMessage());
            e.printStackTrace();
        }
    }
}