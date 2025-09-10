package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Ordonnance {
    // Attributs pour la classe Ordonnance
    private LocalDateTime dateOrdonnance;
    private String nomMedecin, nomPatient;

    // Liste des médicaments pour cette ordonnance
    private List<Medicament> medicaments;

    // Liste statique de toutes les ordonnances
    private static List<Ordonnance> ordonnances = new ArrayList<>();

    /**
     * Constructeur pour la classe Ordonnance
     *
     * @param pNomMedecin           le nom du médecin
     * @param pNomPatient           le nom du patient
     * @param medicaments           la liste des médicaments
     * @throws SaisieException      exception de saisie
     */
    public Ordonnance(String pNomMedecin, String pNomPatient, List<Medicament> medicaments) throws SaisieException {
        this.dateOrdonnance = LocalDateTime.now();
        this.setNomMedecin(pNomMedecin);
        this.setNomPatient(pNomPatient);

        // Initialiser la liste des médicaments
        this.medicaments = new ArrayList<>();
        if (medicaments != null && !medicaments.isEmpty()) {
            this.medicaments.addAll(medicaments);
        }

        // Ajouter cette ordonnance à la liste statique
        Ordonnance.ordonnances.add(this);
    }

    /**
     * Constructeur sans liste de médicaments (ordonnance vide)
     *
     * @param pNomMedecin           le nom du médecin
     * @param pNomPatient           le nom du patient
     * @throws SaisieException      exception de saisie
     */
    public Ordonnance(String pNomMedecin, String pNomPatient) throws SaisieException {
        this(pNomMedecin, pNomPatient, new ArrayList<>());
    }

    // Méthodes pour gérer les médicaments

    /**
     * Ajoute un médicament à l'ordonnance
     *
     * @param medicament le médicament à ajouter
     */
    public void ajouterMedicament(Medicament medicament) {
        if (medicament != null) {
            this.medicaments.add(medicament);
        }
    }

    /**
     * Supprime un médicament de l'ordonnance
     *
     * @param medicament le médicament à supprimer
     * @return true si le médicament a été supprimé, false sinon
     */
    public boolean supprimerMedicament(Medicament medicament) {
        return this.medicaments.remove(medicament);
    }

    /**
     * Retourne la liste des médicaments (copie pour éviter les modifications externes)
     *
     * @return une copie de la liste des médicaments
     */
    public List<Medicament> getMedicaments() {
        return new ArrayList<>(this.medicaments);
    }

    // Méthodes statiques

    public static List<Ordonnance> getOrdonnances() {
        return new ArrayList<>(ordonnances); // Retourne une copie
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
     * Gets date ordonnance creation formatée.
     *
     * @return the date ordonnance creation formatter
     */
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
            throw new SaisieException("Erreur sur le nom du médecin : " + pNomMedecin);
        } else {
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
            throw new SaisieException("Erreur sur le nom du patient : " + pNomPatient);
        } else {
            this.nomPatient = pNomPatient;
        }
    }

    @Override
    public String toString() {
        StringBuilder sbo = new StringBuilder();
        sbo.append("\nOrdonnance :\n");
        sbo.append("- Date ordonnance : ").append(getDateOrdonnanceCreation()).append("\n");
        sbo.append("- Nom médecin : ").append(nomMedecin).append("\n");
        sbo.append("- Nom patient : ").append(nomPatient).append("\n");
        sbo.append("Liste des médicaments :\n");

        if (medicaments.isEmpty()) {
            sbo.append("  Aucun médicament prescrit\n");
        } else {
            for (int i = 0; i < medicaments.size(); i++) {
                sbo.append("  ").append(i + 1).append(". ").append(medicaments.get(i)).append("\n");
            }
        }

        return sbo.toString();
    }
}