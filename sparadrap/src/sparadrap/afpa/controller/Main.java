package sparadrap.afpa.controller;

import sparadrap.afpa.model.Patient;
import sparadrap.afpa.model.Personne;

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
            Patient p1 = new Patient("Joe", "Max", "5 avenue de la paix", "joemax@live.fr", "+33383820500", "nancy", 54000);
            Patient.getPatients().add(p1);
            System.out.println(p1.toString());
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}