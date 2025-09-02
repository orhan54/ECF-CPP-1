package sparadrap.afpa.model;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    // Attribut de la classe Commande
    private Date dateCommande;
    private String nomPersonne, prenomPersonne;

    // List des commandes enregistrer
    private static List<Commande> commandes = new ArrayList<Commande>();

    // Constructeur de la classe Commande
    public Commande(Date dateCommande, String nomPersonne, String prenomPersonne) {
        this.dateCommande = dateCommande;
        this.nomPersonne = nomPersonne;
        this.prenomPersonne = prenomPersonne;
    }

    // Afficher la list de Commande
    public static List<Commande> getCommandes() {
        return commandes;
    }

    // Getters et Setters
    public Date getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public String getNomPersonne() {
        return this.nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    public String getPrenomPersonne() {
        return this.prenomPersonne;
    }

    public void setPrenomPersonne(String prenomPersonne) {
        this.prenomPersonne = prenomPersonne;
    }

    // toString de la classe Commande
    @Override
    public String toString() {
        return
            "- Date Commande : " + dateCommande + ("\n") +
            "- Nom de la commande : " + nomPersonne + ("\n") +
            "- Prenom de la commande : " + prenomPersonne + ("\n");
    }

}
