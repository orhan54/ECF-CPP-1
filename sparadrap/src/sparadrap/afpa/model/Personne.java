package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

/**
 * The type Personne.
 */
public class Personne {
    private String nom;
    private String prenom;
    private Lieu lieu; // composition : une personne a un lieu

    /**
     * Instantiates a new Personne.
     *
     * @param pNom              the nom
     * @param pPrenom           the prenom
     * @param lieu              the lieu
     * @throws SaisieException  the saisie exception
     */
    // constructeur de lma classe personne
    public Personne(String pNom, String pPrenom, Lieu lieu) throws SaisieException {
        this.setNom(pNom);
        this.setPrenom(pPrenom);
        this.setLieu(lieu);
    }

    // Getters & Setters

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param pNom              the nom
     * @throws SaisieException  the saisie exception
     */
    public void setNom(String pNom) throws SaisieException {
        if (!regexAlpha(pNom)){
            throw new SaisieException("Le nom n'est pas valide !");
        }else{
            this.nom = pNom;
        }
    }

    /**
     * Gets prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets prenom.
     *
     * @param pPrenom           the prenom
     * @throws SaisieException  the saisie exception
     */
    public void setPrenom(String pPrenom) throws SaisieException {
        if (!regexAlpha(pPrenom)){
            throw new SaisieException("Le prenom n'est pas valide !");
        }else{
            this.prenom = pPrenom;
        }
    }

    /**
     * Gets lieu.
     *
     * @return the lieu
     */
    public Lieu getLieu() {
        return lieu;
    }

    /**
     * Sets lieu.
     *
     * @param lieu the lieu
     */
    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    // StringBuilder pour afficher le toString de Personne
    @Override
    public String toString() {
        StringBuilder sbper = new StringBuilder();
        sbper.append("- Nom : ").append(getNom()).append("\n");
        sbper.append("- Prenom : ").append(getPrenom()).append("\n");
        if (getLieu() != null) {
            sbper.append(getLieu().toString());
        }
        return sbper.toString();
    }
}
