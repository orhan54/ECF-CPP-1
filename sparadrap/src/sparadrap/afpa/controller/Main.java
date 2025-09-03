package sparadrap.afpa.controller;

import sparadrap.afpa.model.Commande;
import sparadrap.afpa.model.Lieu;
import sparadrap.afpa.model.Medecin;
import sparadrap.afpa.model.Patient;

import java.sql.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{
            initialisation();
            //menu();
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement du programme " + e.getMessage());
        }
    }

    // Initialisation de saisie du programme
    public static void initialisation() {
        try{
            Lieu lieu1 = new Lieu("12 rue de le guerre", "dupontjean@live.fr.com", "+33312345678", "Paris", 54000);
            Lieu lieu2 = new Lieu("2 rue de la paix", "martinpaul@gmail.com", "+33383813059", "pam", 54700);
            Patient p = new Patient("Dupont", "Jean", lieu1);
            Medecin m = new Medecin("Martin", "Paul", "1234567891234" , lieu2);
            Commande cmd1 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.DIRECT);
            Commande cmd2 = new Commande(new Date(System.currentTimeMillis()), Commande.TypeAchat.ORDONNANCE);

            System.out.println(p);
            System.out.println(m);
            System.out.println(cmd1);
            System.out.println(cmd2);
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}