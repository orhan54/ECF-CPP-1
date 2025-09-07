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
            Lieu lieu2 = new Lieu("2 rue de la paix", "martinpaul@gmail.com", "+33383813059", "pam", 54700);
            Lieu lieu3 = new Lieu("55 avenue des malades", "macif@gmail.com", "+33383812010", "dieulouard", 54380);
            Patient p = new Patient("Dupont", "Jean", lieu1);
            Medecin m = new Medecin("Martin", "Paul", "1234567891234" , lieu2);
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
            Mutuelle m1 = new Mutuelle("macif", 30, 54, lieu3);

            System.out.println(m1);
            System.out.println(p);
            System.out.println(m);
            System.out.println(cmd1);
            System.out.println(cmd2);
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}