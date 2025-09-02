package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Patient extends Personne {

    // Attribut de la classe Client
    private String numeroSecuriteSociale;

    // Lis des patients enregistrer
    private static List<Patient> patients = new ArrayList<Patient>();

    // Constructeur avec les extends de la classe Personne et de la classe Lieu
    public Patient(String pNom, String pPrenom, String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        super(pNom, pPrenom, pAdresse, pEmail, pTelephone, pVille, pCodePostal);
        this.numeroSecuriteSociale = generateNumSecu();
    }

    // Afficher la list des patients
    public static List<Patient> getPatients() {
        return patients;
    }

    private static String generateNumSecu() {
        Random random = new Random();
        StringBuilder numSecu = new StringBuilder();

        // la premiere boucle for pour choisir un chiffre entre 1 et 2 pour le numero de securité social
        for(int i = 0; i < 1; i++) {
            numSecu.append(random.nextInt(2) + 1);
            // le deuxieme for pour les 14 chiffres suivent pour faire une longueur de 15 chiffre total
            for (int j = 0; j < 14; j++) {
                numSecu.append(random.nextInt(10)); // Ajoute un chiffre entre 0 et 9
            }
        }

        if(numSecu.length()!=15){
            System.out.println("Error sur le numero de sécurité social : ");
        }
        return numSecu.toString();
    }

    // Getters et Setters
    public String getNumeroSecuriteSociale() {
        return this.numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String pNumeroSecuriteSociale) {
        if (numeroSecuriteSociale.length()!=15) {
            System.out.println("Error sur le numero de sécurité social : ");
        }else if (numeroSecuriteSociale.length()==15) {
            this.numeroSecuriteSociale = pNumeroSecuriteSociale;
        }
    }

    // toString de la classe Personne et de la classe Client
    @Override
    public String toString() {
        return super.toString()
            + "- Numero de sécurité social : " + this.getNumeroSecuriteSociale();
    }
}
