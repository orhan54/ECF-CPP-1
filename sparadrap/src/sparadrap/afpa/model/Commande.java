package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.io.*;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.dateValide;

/**
 * The type Commande.
 */
public class Commande {
    public enum TypeAchat { DIRECT, ORDONNANCE }

    // Attributs
    private Date dateCommande;
    private TypeAchat typeAchat;
    private String nomMedecin;
    private String nomPatient;
    private String nomMedic;
    private int quantite;
    private double prix;

    private static List<Commande> commandes = new ArrayList<>();

    /**
     * Constructeur
     *
     * @param pDateCommande the p date commande
     * @param pTypeAchat    the p type achat
     * @param nomMedecin    the nom medecin
     * @param nomPatient    the nom patient
     * @param nomMedic      the nom medic
     * @param quantite      the quantite
     * @param prix          the prix
     * @throws SaisieException the saisie exception
     */
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    String nomMedic,
                    int quantite,
                    double prix) throws SaisieException {
        this.setDateCommande(pDateCommande);
        this.setTypeAchat(pTypeAchat);
        this.nomMedecin = nomMedecin;
        this.nomPatient = nomPatient;
        this.nomMedic = nomMedic;
        this.quantite = quantite;
        this.prix = prix;
    }

    public static List<Commande> getCommandes() { return commandes; }

    /**
     * Gets date commande.
     */
    public Date getDateCommande() { return this.dateCommande; }

    /**
     * Gets date commande creation.
     *
     * @return the date commande creation
     */
    public String getDateCommandeCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateCommande.toLocalDate().format(formatter);
    }

    /**
     * Sets date commande.
     *
     * @param pDateCommande the p date commande
     * @throws SaisieException the saisie exception
     */
    public void setDateCommande(Date pDateCommande) throws SaisieException {
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
    public TypeAchat getTypeAchat() { return this.typeAchat; }

    /**
     * Sets type achat.
     *
     * @param pTypeAchat the p type achat
     */
    public void setTypeAchat(TypeAchat pTypeAchat) { this.typeAchat = pTypeAchat; }

    // Getters
    /**
     * Gets nom medecin.
     *
     * @return the nom medecin
     */
    public String getNomMedecin() { return nomMedecin; }

    /**
     * Gets nom patient.
     *
     * @return the nom patient
     */
    public String getNomPatient() { return nomPatient; }

    /**
     * Gets nom medic.
     *
     * @return the nom medic
     */
    public String getNomMedic() { return nomMedic; }

    /**
     * Gets quantite.
     *
     * @return the quantite
     */
    public int getQuantite() { return quantite; }

    /**
     * Gets prix.
     *
     * @return the prix
     */
    public double getPrix() { return prix; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commande").append('\n');
        sb.append("- Date commande : ").append(getDateCommandeCreation()).append('\n');
        sb.append("- Type achat : ").append(typeAchat).append('\n');
        sb.append("- Nom medecin : ").append(nomMedecin).append('\n');
        sb.append("- Nom patient : ").append(nomPatient).append('\n');
        sb.append("- Nom medicament : ").append(nomMedic).append('\n');
        sb.append("- Quantite : ").append(quantite).append('\n');
        sb.append("- Prix : ").append(prix).append('\n');

        return sb.toString();
    }

}
