package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.dateValide;

/**
 * The type Commande.
 */
public class Commande {

    /**
     * The enum Type achat.
     */
    // Enum pour gérer les 2 types d'achat
    public enum TypeAchat {
        DIRECT,
        ORDONNANCE
    }

    // Attributs
    private Date dateCommande;
    private TypeAchat typeAchat;

    // Liste des commandes enregistrées
    private static List<Commande> commandes = new ArrayList<>();

    /**
     * Instantiates a new Commande.
     *
     * @param pDateCommande the date commande
     * @param pTypeAchat    the type achat
     * @throws SaisieException the saisie exception
     */
    // Constructeur
    public Commande(Date pDateCommande, TypeAchat pTypeAchat) throws SaisieException {
        this.setDateCommande(pDateCommande);
        this.setTypeAchat(pTypeAchat);
    }

    // Getters et Setters

    /**
     * Gets commandes.
     *
     * @return the commandes
     */
    // Méthode pour récupérer toutes les commandes
    public static List<Commande> getCommandes() {
        return commandes;
    }

    /**
     * Gets date commande.
     *
     * @return the date commande
     */
    public Date getDateCommande() {
        return this.dateCommande;
    }

    /**
     * Gets date commande creation.
     *
     * @return the date commande creation
     */
    // Retourne la date au format dd/MM/yyyy
    public String getDateCommandeCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateCommande.toLocalDate().format(formatter);
    }

    /**
     * Sets date commande.
     *
     * @param pDateCommande the date commande
     * @throws SaisieException the saisie exception
     */
    // Formater date
    public void setDateCommande(Date pDateCommande) throws SaisieException {
        // Conversion au format dd/MM/yyyy pour validation
        String dateStr = pDateCommande.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (!dateValide(dateStr)) {
            throw new SaisieException("Erreur sur le format de la date : " + dateStr);
        } else {
            this.dateCommande = pDateCommande;
        }
    }

    /**
     * Gets type achat.
     *
     * @return the type achat
     */
    public TypeAchat getTypeAchat() {
        return this.typeAchat;
    }

    public void setTypeAchat(TypeAchat pTypeAchat) {
        this.typeAchat = pTypeAchat;
    }

    // toString
    @Override
    public String toString() {
        return "- Date Commande : " + getDateCommandeCreation() + "\n"
                + "- Type Achat : " + typeAchat + "\n";
    }
}
