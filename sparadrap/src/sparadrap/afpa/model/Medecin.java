package sparadrap.afpa.model;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Personne {
    // Attribut de la classe Medecin
    private int numeroAgreement;

    // List des medecins enregistrer
    private static List<Medecin> medecins = new ArrayList<Medecin>();

    // Constructeur avec les extends de la classe Personne et de la classe Lieu
    public Medecin(String nom, String prenom, String adresse, String email, String telephone, String ville, int codePostal) {
        super(nom, prenom, adresse, email, telephone, ville, codePostal);
        this.setNumeroAgreement(numeroAgreement);
    }

    // Afficher la List des medecins
    public static List<Medecin> getMedecins() {
        return medecins;
    }

    // Getters et Setters
    public int getNumeroAgreement() {
        return this.numeroAgreement;
    }

    public void setNumeroAgreement(int numeroAgreement) {
        this.numeroAgreement = numeroAgreement;
    }

    // toString de la classe Personne et de la classe Medecin

    @Override
    public String toString() {
        return super.toString()
        + "- Numero Agreement: " + numeroAgreement;
    }
}
