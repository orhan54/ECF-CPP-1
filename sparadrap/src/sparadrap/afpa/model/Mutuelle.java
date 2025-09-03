package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.positifInt;
import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Mutuelle extends Lieu {
    // Ajoute obj Lieu dans la classe Mutuelle
    Lieu lieu = new Lieu("2 rue de la paix", "test@test.fr", "+33383819000", "pam", 54700);

    // Attribut de la classe Mutuelle
    private String nom;
    private double tauxPriseEnCharge;
    private int departement;

    // List des mutuelles
    private static List<Mutuelle> mutuelles = new ArrayList<Mutuelle>();

    // Constucteur qui extends de la classe Lieu
    public Mutuelle(String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        super("2 rue de la paix", "test@test.fr", "+33383819000", "pam", 54700);
        this.setNom(nom);
        this.setTauxPriseEnCharge(tauxPriseEnCharge);
        this.setDepartement(departement);
    }

    // Afficher la list des Mutuelles
    public static List<Mutuelle> getMutuelles() {
        return mutuelles;
    }

    // Getters et Setters pour acceder au attribut
    public  String getNom() {
        return this.nom;
    }

    public void setNom(String pNom) throws SaisieException {
        if (!regexAlpha(pNom) && !pNom.isEmpty()) {
            throw new SaisieException("Error sur le nom de la mutuelle : " + pNom);
        }else{
            this.nom = pNom;
        }
    }

    public double getTauxPriseEnCharge() {
        return this.tauxPriseEnCharge;
    }

    public void setTauxPriseEnCharge(double pTauxPriseEnCharge) throws SaisieException {
        if (!positifInt(String.valueOf(pTauxPriseEnCharge)) && pTauxPriseEnCharge < 0){
            throw new SaisieException("Error sur le taux de prise en charge : " + pTauxPriseEnCharge);
        }else{
            this.tauxPriseEnCharge = pTauxPriseEnCharge;
        }
    }

    public int getDepartement() {
        return this.departement;
    }

    public void setDepartement(int pDepartement) throws SaisieException {
        if (!positifInt(String.valueOf(pDepartement)) && pDepartement < 0){
            throw new SaisieException("Error sur le numéro de departement : " + pDepartement);
        }else{
            this.departement = pDepartement;
        }
    }

    // affichage du super.toString avec la classe lieu
    @Override
    public String toString() {
        return super.toString()
            + "- Nom mutuelle : " + nom + ("\n")
            + "- Taux de prise en charge : " + tauxPriseEnCharge + ("\n")
            + "- Departement : " + departement + ("\n");
    }
}
