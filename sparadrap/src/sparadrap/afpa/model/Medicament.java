package sparadrap.afpa.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Medicament {
    // Attibut pour la classe Medicament
    private int quantite;
    private Date dateMiseEnService;
    private double prix;
    private String categorie, nom;

    // List des medicaments
    private static List<Medicament> medicaments = new ArrayList<Medicament>();

    // Constucteur de la classe Medicament
    public Medicament(int quantite, Date dateMiseEnService, double prix, String categorie, String nom) {
        quantite = this.quantite;
        this.dateMiseEnService = dateMiseEnService;
        this.prix = prix;
        this.categorie = categorie;
        this.nom = nom;
    }

    // Afficher la list des medicaments
    public static List<Medicament> getMedicaments() {
        return medicaments;
    }

    // Getters et Setters pour acceder au attribut
    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateMiseEnService() {
        return this.dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // StringBiulder dans mon toString de la classe Medicament
    public String toString() {
        StringBuilder m = new StringBuilder();
        m.append("- Quantité : ").append(this.quantite).append("\n");
        m.append("- Date mise en service : ").append(this.dateMiseEnService).append("\n");
        m.append("- Prix : ").append(this.prix).append("\n");
        m.append("- Categorie : ").append(this.categorie).append("\n");
        m.append("- Nom : ").append(this.nom).append("\n");

        return m.toString();
    }
}
