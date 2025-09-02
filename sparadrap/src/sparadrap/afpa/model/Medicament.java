package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import static sparadrap.afpa.utility.RegexUtility.*;

public class Medicament {
    // Attibut pour la classe Medicament
    private int quantite;
    private Date dateMiseEnService;
    private double prix;
    private String categorie, nom;

    // List des medicaments
    private static List<Medicament> medicaments = new ArrayList<Medicament>();

    // Constucteur de la classe Medicament
    public Medicament(int pQuantite, Date pDateMiseEnService, double pPrix, String pCategorie, String pNom) throws SaisieException {
        this.setQuantite(pQuantite);
        this.setDateMiseEnService(pDateMiseEnService);
        this.setPrix(pPrix);
        this.setCategorie(pCategorie);
        this.setNom(pNom);
    }

    // Afficher la list des medicaments
    public static List<Medicament> getMedicaments() {
        return medicaments;
    }

    // Getters et Setters pour acceder au attribut
    public int getQuantite() {
        return this.quantite;
    }

    public void setQuantite(int pQuantite) throws SaisieException {
        if (!positifInt(String.valueOf(pQuantite))) {
            throw new SaisieException("Error sur la quantité des médicaments : ");
        }else{
            this.quantite = pQuantite;
        }
    }

    public Date getDateMiseEnService() {
        return this.dateMiseEnService;
    }

    public void setDateMiseEnService(Date pDateMiseEnService) throws SaisieException {
        if(!dateValide(String.valueOf(pDateMiseEnService))){
            throw new SaisieException("Error sur la date de mise en service : ");
        }else{
            this.dateMiseEnService = pDateMiseEnService;
        }
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double pPrix) throws SaisieException {
        if (!positifInt(String.valueOf(pPrix))) {
            throw new SaisieException("Error sur le prix : ");
        }else{
            this.prix = pPrix;
        }
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String pCategorie) throws SaisieException {
        if (!regexAlpha(pCategorie)) {
            throw new SaisieException("Error sur le categorie : ");
        }else{
            this.categorie = pCategorie;
        }
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String pNom) throws SaisieException {
        if (!regexAlpha(pNom)) {
            throw new SaisieException("Error sur le nom : ");
        }else {
            this.nom = pNom;
        }
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
