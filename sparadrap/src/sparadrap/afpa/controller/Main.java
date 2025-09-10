package sparadrap.afpa.controller;

import sparadrap.afpa.model.*;

import java.awt.*;
import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TODO Add some userful code here
            //FIXME Add more class files:
            //-Diagramme class a modifier

        try{
            Main main = new Main();
            main.run();
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement du programme " + e.getMessage());
        }
    }

    public void run() {
        try{
            initialisation();
            //menu();
        }catch (Exception e) {
            System.out.println("Erreur de la vue accueill " + e.getMessage());
        }
    }

    // Initialisation de saisie du programme
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

            Patient p1 = new Patient("Dupont", "Jean","16-05-1985" , lieu1, m1);
            Patient p2 = new Patient("Martin", "Claire", "20-06-1982", lieu2, m2);
            Patient p3 = new Patient("Durand", "Paul", "19-02-1975", lieu3, m4);
            Patient p4 = new Patient("Petit", "Sophie", "25-10-1973", lieu4, m3);
            Patient p5 = new Patient("Bernard", "Lucas", "22-09-1965", lieu5, m1);

            Medecin med1 = new Medecin("Martin", "Paul", "1234567891234", lieu2, m1);
            Medecin med2 = new Medecin("Robert", "François", "2234567891234", lieu3, m3);
            Medecin med3 = new Medecin("Dubois", "Anne", "3234567891234", lieu4, m5);
            Medecin med4 = new Medecin("Morel", "Hélène", "4234567891234", lieu5, m3);
            Medecin med5 = new Medecin("Lefevre", "Julien", "5234567891234", lieu6, m2);

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

            System.out.println(m1);
            System.out.println(p1);
            System.out.println(med1);
            System.out.println(cmd1);
            System.out.println(cmd2);
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}