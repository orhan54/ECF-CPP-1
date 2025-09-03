package sparadrap.afpa.controller;

import sparadrap.afpa.model.Lieu;
import sparadrap.afpa.model.Medecin;
import sparadrap.afpa.model.Patient;

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
            Lieu lieu = new Lieu("12 rue des Lilas", "test@mail.com", "+33612345678", "Paris", 75000);
            Patient p = new Patient("Dupont", "Jean", lieu);
            Medecin m = new Medecin("Martin", "Paul", "1234567891234" , lieu);

            System.out.println(p);
            System.out.println(m);
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}