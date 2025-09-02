package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.dateValide;
import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Commande {
    // Attribut de la classe Commande
    private Date dateCommande;
    private String nomPersonne, prenomPersonne;

    // List des commandes enregistrer
    private static List<Commande> commandes = new ArrayList<Commande>();

    // Constructeur de la classe Commande
    public Commande(Date pDateCommande, String pNomPersonne, String pPrenomPersonne) throws SaisieException {
        this.setDateCommande(pDateCommande);
        this.setNomPersonne(pNomPersonne);
        this.setPrenomPersonne(pPrenomPersonne);
    }

    // Afficher la list de Commande
    public static List<Commande> getCommandes() {
        return commandes;
    }

    // Getters et Setters
    public Date getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(Date pDateCommande) throws SaisieException {
        if (!dateValide(String.valueOf(pDateCommande))){
            throw new SaisieException("Erreur sur le format de la date : ");
        }else{
            this.dateCommande = pDateCommande;
        }
    }

    public String getNomPersonne() {
        return this.nomPersonne;
    }

    public void setNomPersonne(String pNomPersonne) throws SaisieException {
        if (!regexAlpha(pNomPersonne)){
            throw new SaisieException("Erreur sur le nom de la personne : ");
        }else{
            this.nomPersonne = pNomPersonne;
        }
    }

    public String getPrenomPersonne() {
        return this.prenomPersonne;
    }

    public void setPrenomPersonne(String pPrenomPersonne) throws SaisieException {
        if (!regexAlpha(pPrenomPersonne)){
            throw new SaisieException("Erreur sur le prenom de la personne : ");
        }else{
            this.prenomPersonne = pPrenomPersonne;
        }
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
