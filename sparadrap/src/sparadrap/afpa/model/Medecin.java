package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.positifInt;

public class Medecin extends Personne {
    // Attribut de la classe Medecin
    private String numeroAgreement;

    // List des medecins enregistrer
    private static List<Medecin> medecins = new ArrayList<Medecin>();

    // Constructeur avec les extends de la classe Personne et de la classe Lieu
    public Medecin(String pNom, String pPrenom, String numeroAgreement, Lieu lieu) throws SaisieException {
        super(pNom, pPrenom, lieu);
        this.setNumeroAgreement(numeroAgreement);
    }

    // Afficher la List des medecins
    public static List<Medecin> getMedecins() {
        return medecins;
    }

    // Getters et Setters
    public String getNumeroAgreement() {
        return this.numeroAgreement;
    }

    public void setNumeroAgreement(String pNumeroAgreement) throws SaisieException {
        if (!positifInt(String.valueOf(pNumeroAgreement)) && String.valueOf(pNumeroAgreement).length() == 9) {
            throw new SaisieException("Error sur numéro agreement : " + pNumeroAgreement);
        }else{
            this.numeroAgreement = pNumeroAgreement;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Médecin :\n");
        sb.append("- Nom : ").append(getNom()).append("\n");
        sb.append("- Prénom : ").append(getPrenom()).append("\n");
        sb.append("- Numero agréement : ").append(numeroAgreement).append("\n");
        if (getLieu() != null) {
            sb.append(getLieu().toString());
        }
        return sb.toString();
    }
}
