package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Mutuelle extends Lieu {
    // Attribut de la classe Mutuelle
    private String nom;
    private double tauxPriseEnCharge;
    private int departement;

    // List des mutuelles
    private static List<Mutuelle> mutuelles = new ArrayList<Mutuelle>();

    // Constucteur qui extends de la classe Lieu
    public Mutuelle(String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        super(pAdresse, pEmail, pTelephone, pVille, pCodePostal);
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
    public void setNom(String pNom) {
        this.nom = pNom;
    }

    public double getTauxPriseEnCharge() {
        return this.tauxPriseEnCharge;
    }

    public void setTauxPriseEnCharge(double pTauxPriseEnCharge) {
        this.tauxPriseEnCharge = pTauxPriseEnCharge;
    }

    public int getDepartement() {
        return this.departement;
    }

    public void setDepartement(int pDepartement) {
        this.departement = pDepartement;
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
