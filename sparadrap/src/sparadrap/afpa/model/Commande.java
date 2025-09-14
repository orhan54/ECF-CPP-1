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
    private List<Medicament> medicaments; // Remplace nomMedic
    private int quantite;
    private double prix;
    private Mutuelle mutuelle; // Référence à la mutuelle du patient
    private boolean priseEnChargeMutuelle; // Si la commande utilise la mutuelle

    private static List<Commande> commandes = new ArrayList<>();

    /**
     * Constructeur avec liste de médicaments et mutuelle
     *
     * @param pDateCommande         the date commande
     * @param pTypeAchat            the type achat
     * @param nomMedecin            the nom medecin
     * @param nomPatient            the nom patient
     * @param medicaments           the liste des medicaments
     * @param quantite              the quantite
     * @param prix                  the prix
     * @param mutuelle              the mutuelle du patient
     * @param priseEnChargeMutuelle the prise en charge mutuelle
     * @throws SaisieException the saisie exception
     */
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    List<Medicament> medicaments,
                    int quantite,
                    double prix,
                    Mutuelle mutuelle,
                    boolean priseEnChargeMutuelle) throws SaisieException {
        this.setDateCommande(pDateCommande);
        this.setTypeAchat(pTypeAchat);
        this.nomMedecin = nomMedecin;
        this.nomPatient = nomPatient;
        this.setMedicaments(medicaments);
        this.quantite = quantite;
        this.prix = prix;
        this.mutuelle = mutuelle;
        this.priseEnChargeMutuelle = priseEnChargeMutuelle;
    }

    /**
     * Constructeur avec un seul médicament et mutuelle
     *
     * @param pDateCommande         the date commande
     * @param pTypeAchat            the type achat
     * @param nomMedecin            the nom medecin
     * @param nomPatient            the nom patient
     * @param medicament            the medicament unique
     * @param quantite              the quantite
     * @param prix                  the prix
     * @param mutuelle              the mutuelle du patient
     * @param priseEnChargeMutuelle the prise en charge mutuelle
     * @throws SaisieException the saisie exception
     */
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    Medicament medicament,
                    int quantite,
                    double prix,
                    Mutuelle mutuelle,
                    boolean priseEnChargeMutuelle) throws SaisieException {
        this.setDateCommande(pDateCommande);
        this.setTypeAchat(pTypeAchat);
        this.nomMedecin = nomMedecin;
        this.nomPatient = nomPatient;
        this.medicaments = new ArrayList<>();
        if (medicament != null) {
            this.medicaments.add(medicament);
        }
        this.quantite = quantite;
        this.prix = prix;
        this.mutuelle = mutuelle;
        this.priseEnChargeMutuelle = priseEnChargeMutuelle;
    }

    /**
     *
     * @param pDateCommande the date commande
     * @param pTypeAchat    the type achat
     * @param nomMedecin    the nom medecin
     * @param nomPatient    the nom patient
     * @param medicaments   the medicaments
     * @param quantite      the quantite
     * @param prix          the prix
     * @throws SaisieException the saisie exception
     */
// Constructeurs de compatibilité (sans mutuelle)
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    List<Medicament> medicaments,
                    int quantite,
                    double prix) throws SaisieException {
        this(pDateCommande, pTypeAchat, nomMedecin, nomPatient, medicaments, quantite, prix, null, false);
    }

    /**
     *
     * @param pDateCommande the date commande
     * @param pTypeAchat    the type achat
     * @param nomMedecin    the nom medecin
     * @param nomPatient    the nom patient
     * @param medicament    the medicament
     * @param quantite      the quantite
     * @param prix          the prix
     * @throws SaisieException the saisie exception
     */
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    Medicament medicament,
                    int quantite,
                    double prix) throws SaisieException {
        this(pDateCommande, pTypeAchat, nomMedecin, nomPatient, medicament, quantite, prix, null, false);
    }

    /**
     *
     * @param pDateCommande         the date commande
     * @param pTypeAchat            the type achat
     * @param nomMedecin            the nom medecin
     * @param nomPatient            the nom patient
     * @param medicaments           the medicaments
     * @param quantite              the quantite
     * @param prix                  the prix
     * @param priseEnChargeMutuelle the prise en charge mutuelle
     * @throws SaisieException the saisie exception
     */
// Constructeurs avec boolean seulement (pour compatibilité)
    public Commande(Date pDateCommande,
                    TypeAchat pTypeAchat,
                    String nomMedecin,
                    String nomPatient,
                    List<Medicament> medicaments,
                    int quantite,
                    double prix,
                    boolean priseEnChargeMutuelle) throws SaisieException {
        this(pDateCommande, pTypeAchat, nomMedecin, nomPatient, medicaments, quantite, prix, null, priseEnChargeMutuelle);
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
     * Gets medicaments.
     *
     * @return the liste des medicaments
     */
    public List<Medicament> getMedicaments() {
        return new ArrayList<>(this.medicaments); // Retourne une copie défensive
    }

    /**
     * Sets medicaments.
     *
     * @param medicaments the liste des medicaments
     */
    public void setMedicaments(List<Medicament> medicaments) {
        this.medicaments = new ArrayList<>();
        if (medicaments != null && !medicaments.isEmpty()) {
            this.medicaments.addAll(medicaments);
        }
    }

    /**
     * Ajouter un médicament à la commande.
     *
     * @param medicament the medicament à ajouter
     */
    public void ajouterMedicament(Medicament medicament) {
        if (medicament != null) {
            this.medicaments.add(medicament);
        }
    }

    /**
     * Supprimer un médicament de la commande.
     *
     * @param medicament the medicament à supprimer
     * @return true si le médicament a été supprimé, false sinon
     */
    public boolean supprimerMedicament(Medicament medicament) {
        return this.medicaments.remove(medicament);
    }

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

    /**
     * Gets mutuelle.
     *
     * @return the mutuelle
     */
    public Mutuelle getMutuelle() { return mutuelle; }

    /**
     * Sets mutuelle.
     *
     * @param mutuelle the mutuelle
     */
    public void setMutuelle(Mutuelle mutuelle) { this.mutuelle = mutuelle; }

    /**
     * Gets prise en charge mutuelle.
     *
     * @return true si prise en charge mutuelle, false sinon
     */
    public boolean isPriseEnChargeMutuelle() { return priseEnChargeMutuelle; }

    /**
     * Sets prise en charge mutuelle.
     *
     * @param priseEnChargeMutuelle the prise en charge mutuelle
     */
    public void setPriseEnChargeMutuelle(boolean priseEnChargeMutuelle) {
        this.priseEnChargeMutuelle = priseEnChargeMutuelle;
    }

    /**
     * Gets taux mutuelle utilisé pour cette commande.
     *
     * @return le taux de la mutuelle en décimal (ex: 0.30 pour 30%)
     */
    public double getTauxMutuelle() {
        if (mutuelle != null) {
            return mutuelle.getTauxPriseEnCharge() / 100.0; // Conversion pourcentage vers décimal
        }
        return 0.0;
    }

    /**
     * Calcule le prix total de la commande basé sur les médicaments.
     *
     * @return the prix total calculé
     */
    public double getPrixTotal() {
        double total = 0.0;
        for (Medicament med : medicaments) {
            total += med.getPrix() * med.getQuantite();
        }
        return total;
    }

    /**
     * Calcule le prix total après déduction mutuelle si applicable.
     *
     * @return le prix total après déduction mutuelle
     */
    public double getPrixTotalApresDeduction() {
        double prixTotal = getPrixTotal();

        // Si c'est une commande par ordonnance avec prise en charge mutuelle
        if (typeAchat == TypeAchat.ORDONNANCE && priseEnChargeMutuelle && mutuelle != null) {
            return prixTotal * (1 - getTauxMutuelle());
        }

        return prixTotal;
    }

    /**
     * Calcule le montant de la déduction mutuelle.
     *
     * @return le montant de la déduction
     */
    public double getMontantDeductionMutuelle() {
        if (typeAchat == TypeAchat.ORDONNANCE && priseEnChargeMutuelle && mutuelle != null) {
            return getPrixTotal() * getTauxMutuelle();
        }
        return 0.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Commande").append('\n');
        sb.append("- Date commande : ").append(getDateCommandeCreation()).append('\n');
        sb.append("- Type achat : ").append(typeAchat).append('\n');
        sb.append("- Nom medecin : ").append(nomMedecin).append('\n');
        sb.append("- Nom patient : ").append(nomPatient).append('\n');

        sb.append("- Médicaments : ").append('\n');
        if (medicaments.isEmpty()) {
            sb.append("  Aucun médicament dans la commande").append('\n');
        } else {
            for (int i = 0; i < medicaments.size(); i++) {
                sb.append("  ").append(i + 1).append(". ");
                sb.append("Nom: ").append(medicaments.get(i).getNom());
                sb.append(", Quantité: ").append(medicaments.get(i).getQuantite());
                sb.append(", Prix unitaire: ").append(medicaments.get(i).getPrix()).append("€");
                sb.append('\n');
            }
        }

        sb.append("- Quantite totale : ").append(quantite).append('\n');
        sb.append("- Prix : ").append(prix).append("€").append('\n');
        sb.append("- Prix total calculé : ").append(String.format("%.2f", getPrixTotal())).append("€").append('\n');

        if (typeAchat == TypeAchat.ORDONNANCE) {
            sb.append("- Prise en charge mutuelle : ").append(priseEnChargeMutuelle ? "Oui" : "Non").append('\n');
            if (priseEnChargeMutuelle && mutuelle != null) {
                sb.append("- Mutuelle : ").append(mutuelle.getNom()).append('\n');
                sb.append("- Taux de prise en charge : ").append(String.format("%.1f", mutuelle.getTauxPriseEnCharge())).append("%").append('\n');
                sb.append("- Déduction mutuelle : ").append(String.format("%.2f", getMontantDeductionMutuelle())).append("€").append('\n');
                sb.append("- Prix à payer : ").append(String.format("%.2f", getPrixTotalApresDeduction())).append("€").append('\n');
            }
        }

        return sb.toString();
    }
}