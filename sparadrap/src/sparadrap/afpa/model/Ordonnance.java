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

    // Constructeur pour la classe Ordonnance
    public Ordonnance(Date dateOrdonnance, String pNomMedecin, String pNomPatient, List pListeDesMedicament) throws SaisieException {
        this.dateOrdonnance = LocalDateTime.now();
        this.setNomMedecin(pNomMedecin);
        this.setNomPatient(pNomPatient);
        this.setListeDesMedicament(pListeDesMedicament);
    }

    // Getters et Setters pour accerder au attribut de la classe Ordonnance
    public LocalDateTime getDateOrdonnance() {
        return this.dateOrdonnance;
    }

    // Retourne la date formatée
    public String getDateOrdonnanceCreation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOrdonnance.format(formatter);
    }

    public String getNomMedecin() {
        return this.nomMedecin;
    }

    public void setNomMedecin(String pNomMedecin) throws SaisieException {
        if (!regexAlpha(pNomMedecin) && !pNomMedecin.isEmpty()) {
            throw new SaisieException("Error sur le nom du medecin : "  + pNomMedecin);
        }else{
            this.nomMedecin = pNomMedecin;
        }
    }

    public String getNomPatient() {
        return this.nomPatient;
    }

    public void setNomPatient(String pNomPatient) throws SaisieException {
        if (!regexAlpha(pNomPatient) && !pNomPatient.isEmpty()) {
            throw new SaisieException("Error sur le nom du patient : "  + pNomPatient);
        }else{
            this.nomPatient = pNomPatient;
        }
    }

    public List getListeDesMedicament() {
        return this.listeDesMedicament;
    }

    public void setListeDesMedicament(List pListeDesMedicament) throws SaisieException {
        if (!regexAlpha(String.valueOf(pListeDesMedicament)) && String.valueOf(pListeDesMedicament).isEmpty()) {
            throw new SaisieException("Error sur la liste des medicaments : "  + pListeDesMedicament);
        }else{
            this.listeDesMedicament = pListeDesMedicament;
        }
    }

    // StringBuilder pour afficher le toString de Ordonnance
    public String toString() {
        StringBuilder o = new StringBuilder();
        o.append("Ordonnance : ").append("\n");
        o.append("- DateOrdonnance : ");
        o.append(getDateOrdonnance()).append("\n");
        o.append("- Nom medecin : ");
        o.append(nomMedecin).append("\n");
        o.append("- Nom patient : ");
        o.append(nomPatient).append("\n");
        o.append("- Liste medicament : ");
        o.append(listeDesMedicament);

        return o.toString();
    }
}
