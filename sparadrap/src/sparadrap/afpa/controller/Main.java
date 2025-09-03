package sparadrap.afpa.controller;

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
            Patient p1 = new Patient("Joe", "Max", "5 rue de la paix", "joemax@live.fr", "+33383820500", "pam", 54700);
            Patient.getPatients().add(p1);
            System.out.println(p1.toString());
            Patient p2 = new Patient("Doe", "John", "2 rue de la guerre", "doejohn@test.fr", "+33602015759", "Nancy", 54000);
            Patient.getPatients().add(p2);
            System.out.println(p2.toString());
        }catch (Exception e) {
            System.out.println("Erreur dans le lancement de l'initialisation du programme " + e.getMessage());
        }
    }

}