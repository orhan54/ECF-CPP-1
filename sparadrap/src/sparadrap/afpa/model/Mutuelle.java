package sparadrap.afpa.model;

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
    public Mutuelle(String adresse, String email, String telephone, String ville, int codePostal) {
        super(adresse, email, telephone, ville, codePostal);
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
    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxPriseEnCharge() {
        return this.tauxPriseEnCharge;
    }

    public void setTauxPriseEnCharge(double tauxPriseEnCharge) {
        this.tauxPriseEnCharge = tauxPriseEnCharge;
    }

    public int getDepartement() {
        return this.departement;
    }

    public void setDepartement(int departement) {
        this.departement = departement;
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
