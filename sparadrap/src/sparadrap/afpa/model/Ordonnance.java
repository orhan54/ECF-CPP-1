package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Ordonnance {
    // Attribut pour la classe Ordonnance
    private LocalDateTime dateOrdonnance;
    private String nomMedecin, nomPatient;
    private List listeDesMedicament;

    /**
     * Instantiates a new Ordonnance.
     *
     * @param dateOrdonnance        the date ordonnance
     * @param pNomMedecin           the nom medecin
     * @param pNomPatient           the nom patient
     * @param pListeDesMedicament   the liste des medicament
     * @throws SaisieException      the saisie exception
     */
    // Constructeur pour la classe Ordonnance
    public Ordonnance(Date dateOrdonnance, String pNomMedecin, String pNomPatient, List pListeDesMedicament) throws SaisieException {
        this.dateOrdonnance = LocalDateTime.now();
        this.setNomMedecin(pNomMedecin);
        this.setNomPatient(pNomPatient);
        this.setListeDesMedicament(pListeDesMedicament);
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
     * Gets liste des medicament.
     *
     * @return the liste des medicament
     */
    public List getListeDesMedicament() {
        return this.listeDesMedicament;
    }

    /**
     * Sets liste des medicament.
     *
     * @param pListeDesMedicament   the liste des medicament
     * @throws SaisieException      the saisie exception
     */
    public void setListeDesMedicament(List pListeDesMedicament) throws SaisieException {
        if (!regexAlpha(String.valueOf(pListeDesMedicament)) && String.valueOf(pListeDesMedicament).isEmpty()) {
            throw new SaisieException("Error sur la liste des medicaments : "  + pListeDesMedicament);
        }else{
            this.listeDesMedicament = pListeDesMedicament;
        }
    }

    // StringBuilder pour afficher le toString de Ordonnance
    public String toString() {
        StringBuilder sbo = new StringBuilder();
        sbo.append("Ordonnance : ").append("\n");
        sbo.append("- DateOrdonnance : ").append(getDateOrdonnance()).append("\n");
        sbo.append("- Nom medecin : ").append(nomMedecin).append("\n");
        sbo.append("- Nom patient : ").append(nomPatient).append("\n");
        sbo.append("Liste medicament : ").append("\n");
        sbo.append(listeDesMedicament);

        return sbo.toString();
    }
}
