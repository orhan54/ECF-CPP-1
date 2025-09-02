package sparadrap.afpa.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Personne {

    // Attribut de la classe Client
    private int numeroSecuriteSociale;

    // Lis des patients enregistrer
    private static List<Patient> patients = new ArrayList<Patient>();

    // Constructeur avec les extends de la classe Personne et de la classe Lieu
    public Patient(String nom, String prenom, String adresse, String email, String telephone, String ville, int codePostal) {
        super(nom, prenom, adresse, email, telephone, ville, codePostal);
        this.setNumeroSecuriteSociale(numeroSecuriteSociale);
    }

    // Afficher la list des patients
    public static List<Patient> getPatients() {
        return patients;
    }

    // Getters et Setters
    public int getNumeroSecuriteSociale() {
        return this.numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(int numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    // toString de la classe Personne et de la classe Client
    @Override
    public String toString() {
        return super.toString()
            + "- Numero de sécurité social : " + numeroSecuriteSociale;
    }
}
