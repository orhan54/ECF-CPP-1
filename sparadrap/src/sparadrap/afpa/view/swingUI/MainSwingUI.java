package sparadrap.afpa.view.swingUI;

import sparadrap.afpa.model.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.sql.Date;

public class MainSwingUI {
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
            Menu myMenu = new Menu();
            myMenu.setVisible(true);
            initialisation();
        }catch (Exception e) {
            System.out.println("Error au lancement de la vue Swing " + e.getMessage());
        }
    }

    public static void initialisation() {
        try{
            Lieu lieu1 = new Lieu("12 rue de le guerre", "dupontjean@live.fr.com", "+33312345678", "Nancy", 54000);
            Lieu lieu2 = new Lieu("2 rue de la paix", "martinpaul@gmail.com", "+33383813059", "pam", 54700);
            Lieu lieu3 = new Lieu("55 avenue des malades", "macif@gmail.com", "+33383812010", "dieulouard", 54380);
            Patient p = new Patient("Dupont", "Jean", lieu1);
            Medecin m = new Medecin("Martin", "Paul", "1234567891234" , lieu2);
            Commande cmd1 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.DIRECT);
            Commande cmd2 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.ORDONNANCE);
            Mutuelle m1 = new Mutuelle("macif", 30, 54, lieu3);

            // Ajout des medicaments dans initialisation
            Medicament medic1 = new Medicament(20, "10-05-2025", 10.50, "Cardiotoniques", "Digoxine");
            Medicament medic2 = new Medicament(50, "02-09-2025", 5.99, "Bêta-bloquants", "Bisoprolol");
            Medicament medic3 = new Medicament(80, "28-05-2025", 9.99, "Diurétiques", "Mannitol");
            Medicament medic4 = new Medicament(120, "22-01-2025", 25.99, "Hypnotiques", "Méthaqualone");
            Medicament medic5 = new Medicament(100, "02-03-2025", 15.99, "Triptans", "Élétriptan");

            // Ajout dans la listes des medicaments
            Medicament.getMedicaments().add(medic1);
            Medicament.getMedicaments().add(medic2);
            Medicament.getMedicaments().add(medic3);
            Medicament.getMedicaments().add(medic4);
            Medicament.getMedicaments().add(medic5);


            System.out.println(m1);
            System.out.println(p);
            System.out.println(m);
            System.out.println(cmd1);
            System.out.println(cmd2);
            System.out.println(Medicament.getMedicaments());
        }catch(Exception e){
            System.out.println("Erreur de la vue menu swing " + e.getMessage());
        }
    }
}
