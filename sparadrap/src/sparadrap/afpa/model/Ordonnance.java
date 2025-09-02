package sparadrap.afpa.model;

import java.awt.*;
import java.util.Date;

public class Ordonnance {
    // Attribut pour la classe Ordonnance
    private Date dateOrdonnance;
    private String nomMedecin, nomPatient;
    private List listeDesMedicament;

    // Constructeur pour la classe Ordonnance
    public Ordonnance(Date dateOrdonnance, String nomMedecin, String nomPatient, List listeDesMedicament) {
        this.dateOrdonnance = dateOrdonnance;
        this.nomMedecin = nomMedecin;
        this.nomPatient = nomPatient;
        this.listeDesMedicament = listeDesMedicament;
    }

    // Getters et Setters pour accerder au attribut de la classe Ordonnance
    public Date getDateOrdonnance() {
        return this.dateOrdonnance;
    }

    public void setDateOrdonnance(Date dateOrdonnance) {
        this.dateOrdonnance = dateOrdonnance;
    }

    public String getNomMedecin() {
        return this.nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getNomPatient() {
        return this.nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public List getListeDesMedicament() {
        return this.listeDesMedicament;
    }

    public void setListeDesMedicament(List listeDesMedicament) {
        this.listeDesMedicament = listeDesMedicament;
    }

    // StringBuilder pour afficher le toString de Ordonnance
    public String toString() {
        StringBuilder o = new StringBuilder();
        o.append("Ordonnance : ").append("\n");
        o.append("- DateOrdonnance : ").append("\n");
        o.append(dateOrdonnance);
        o.append("- Nom medecin : ").append("\n");
        o.append(nomMedecin);
        o.append("- Nom patient : ").append("\n");
        o.append(nomPatient);
        o.append("- Liste medicament : ").append("\n");
        o.append(listeDesMedicament);

        return o.toString();
    }
}
