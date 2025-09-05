package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.positifInt;
import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Ordonnance {
    // Attribut pour la classe Ordonnance
    private LocalDateTime dateOrdonnance;
    private String nomMedecin, nomPatient, nomMedic;
    private int quantiteMedic;

    // List des medicaments
    private static List<Ordonnance> ordonnances = new ArrayList<Ordonnance>();

    /**
     * Instantiates a new Ordonnance.
     *
//     * @param dateOrdonnance        the date ordonnance
     * @param pNomMedecin           the nom medecin
     * @param pNomPatient           the nom patient
     * @param pNomMedic  the nom du medicament
     * @param pQuantiteMedic the quantite medicament
     * @throws SaisieException      the saisie exception
     */
    // Constructeur pour la classe Ordonnance
    public Ordonnance(String pNomMedecin, String pNomPatient, String pNomMedic, int pQuantiteMedic) throws SaisieException {
        this.dateOrdonnance = LocalDateTime.now();
        this.setNomMedecin(pNomMedecin);
        this.setNomPatient(pNomPatient);
        this.setNomMedic(pNomMedic);
        this.setQuantiteMedic(pQuantiteMedic);
    }

    public static List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }

    // Getters et Setters

    /**
     * Gets date ordonnance.
     *
     * @return the date ordonnance
     */
    public LocalDateTime getDateOrdonnance() {
        return this.dateOrdonnance;
    }

    /**
     * Gets date ordonnance creation.
     *
     * @return the date ordonnance creation formatter
     */
    // Retourne la date formatée
    public String getDateOrdonnanceCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOrdonnance.format(formatter);
    }

    /**
     * Gets nom medecin.
     *
     * @return the nom medecin
     */
    public String getNomMedecin() {
        return this.nomMedecin;
    }

    /**
     * Sets nom medecin.
     *
     * @param pNomMedecin       the nom medecin
     * @throws SaisieException  the saisie exception
     */
    public void setNomMedecin(String pNomMedecin) throws SaisieException {
        if (!regexAlpha(pNomMedecin) && !pNomMedecin.isEmpty()) {
            throw new SaisieException("Error sur le nom du medecin : "  + pNomMedecin);
        }else{
            this.nomMedecin = pNomMedecin;
        }
    }

    /**
     * Gets nom patient.
     *
     * @return the nom patient
     */
    public String getNomPatient() {
        return this.nomPatient;
    }

    /**
     * Sets nom patient.
     *
     * @param pNomPatient       the nom patient
     * @throws SaisieException  the saisie exception
     */
    public void setNomPatient(String pNomPatient) throws SaisieException {
        if (!regexAlpha(pNomPatient) && !pNomPatient.isEmpty()) {
            throw new SaisieException("Error sur le nom du patient : "  + pNomPatient);
        }else{
            this.nomPatient = pNomPatient;
        }
    }

    /**
     * Gets nom medic.
     *
     * @return the nom medic
     */
    public String getNomMedic() {
        return this.nomMedic;
    }

    /**
     * Sets nom medic.
     *
     * @param pNomMedic the p nom medic
     * @throws SaisieException the saisie exception
     */
    public void setNomMedic(String pNomMedic) throws SaisieException {
        if (!regexAlpha(pNomMedic) && !pNomMedic.isEmpty()) {
            throw new SaisieException("Error sur le  nom du medic : "  + pNomMedic);
        }
        this.nomMedic = pNomMedic;
    }

    /**
     * Gets quantite medic.
     *
     * @return the quantite medic
     */
    public int getQuantiteMedic() {
        return this.quantiteMedic;
    }

    /**
     * Sets quantite medic.
     *
     * @param pQuantiteMedic the p quantite medic
     * @throws SaisieException the saisie exception
     */
    public void setQuantiteMedic(int pQuantiteMedic) throws SaisieException {
        if(!positifInt(String.valueOf(pQuantiteMedic))){
            throw new SaisieException("Error sur la quantite du medic : "  + pQuantiteMedic);
        }else{
            this.quantiteMedic = pQuantiteMedic;
        }
    }

    // StringBuilder pour afficher le toString de Ordonnance
    public String toString() {
        StringBuilder sbo = new StringBuilder();
        sbo.append("\n");
        sbo.append("Ordonnance : ").append("\n");
        sbo.append("- DateOrdonnance : ").append(getDateOrdonnanceCreation()).append("\n");
        sbo.append("- Nom medecin : ").append(nomMedecin).append("\n");
        sbo.append("- Nom patient : ").append(nomPatient).append("\n");
        sbo.append("Liste medicament : ").append("\n");
        sbo.append("- Nom medic : ").append(nomMedic).append("\n");
        sbo.append("- Quantite medic : ").append(quantiteMedic).append("\n");

        return sbo.toString();
    }
}
