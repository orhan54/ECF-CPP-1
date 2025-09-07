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

    public String getDateCommandeCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateCommande.toLocalDate().format(formatter);
    }

    public void setDateCommande(Date pDateCommande) throws SaisieException {
        String dateStr = pDateCommande.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (!dateValide(dateStr)) {
            throw new SaisieException("Erreur sur le format de la date : " + dateStr);
        } else {
            this.dateCommande = pDateCommande;
        }
    }

    public TypeAchat getTypeAchat() { return this.typeAchat; }
    public void setTypeAchat(TypeAchat pTypeAchat) { this.typeAchat = pTypeAchat; }

    // Getters simples
    public String getNomMedecin() { return nomMedecin; }
    public String getNomPatient() { return nomPatient; }
    public String getNomMedic() { return nomMedic; }
    public int getQuantite() { return quantite; }
    public double getPrix() { return prix; }
}
