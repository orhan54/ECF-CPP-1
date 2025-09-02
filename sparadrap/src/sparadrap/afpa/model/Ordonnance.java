package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ordonnance {
    // Attribut pour la classe Ordonnance
    private LocalDateTime dateOrdonnance;
    private String nomMedecin, nomPatient;
    private List listeDesMedicament;

    // Constructeur pour la classe Ordonnance
    public Ordonnance(Date pDateOrdonnance, String pNomMedecin, String pNomPatient, List pListeDesMedicament) throws SaisieException {
        this.dateOrdonnance = LocalDateTime.now();
        this.setNomMedecin(pNomMedecin);
        this.setNomPatient(pNomPatient);
        this.setListeDesMedicament(pListeDesMedicament);
    }

    // Getters et Setters pour accerder au attribut de la classe Ordonnance
    public String getDateOrdonnance() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateOrdonnance.format(formatter);
    }

    public String getNomMedecin() {
        return this.nomMedecin;
    }

    public void setNomMedecin(String pNomMedecin) {
        this.nomMedecin = pNomMedecin;
    }

    public String getNomPatient() {
        return this.nomPatient;
    }

    public void setNomPatient(String pNomPatient) {
        this.nomPatient = pNomPatient;
    }

    public List getListeDesMedicament() {
        return this.listeDesMedicament;
    }

    public void setListeDesMedicament(List pListeDesMedicament) {
        this.listeDesMedicament = pListeDesMedicament;
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
