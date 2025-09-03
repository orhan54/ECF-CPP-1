package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.positifInt;

public class Medecin extends Personne {
    // Attribut de la classe Medecin
    private int numeroAgreement;

    // List des medecins enregistrer
    private static List<Medecin> medecins = new ArrayList<Medecin>();

    // Constructeur avec les extends de la classe Personne et de la classe Lieu
    public Medecin(String pNom, String pPrenom, String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        super(pNom, pPrenom, pAdresse, pEmail, pTelephone, pVille, pCodePostal);
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

    public void setNumeroAgreement(int pNumeroAgreement) throws SaisieException {
        if (!positifInt(String.valueOf(pNumeroAgreement)) && String.valueOf(pNumeroAgreement).length() == 9) {
            throw new SaisieException("Error sur numéro agreement : " + pNumeroAgreement);
        }else{
            this.numeroAgreement = pNumeroAgreement;
        }
    }

    // toString de la classe Personne et de la classe Medecin

    @Override
    public String toString() {
        return super.toString()
        + "- Numero Agreement: " + numeroAgreement;
    }
}
