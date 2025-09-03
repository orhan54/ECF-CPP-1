package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Personne {
    private String nom;
    private String prenom;
    private Lieu lieu; // composition : une personne a un lieu

    public Personne(String pNom, String pPrenom, Lieu lieu) throws SaisieException {
        this.setNom(pNom);
        this.setPrenom(pPrenom);
        this.setLieu(lieu);
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) throws SaisieException {
        if (!regexAlpha(pNom)){
            throw new SaisieException("Le nom n'est pas valide !");
        }else{
            this.nom = pNom;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String pPrenom) throws SaisieException {
        if (!regexAlpha(pPrenom)){
            throw new SaisieException("Le prenom n'est pas valide !");
        }else{
            this.prenom = pPrenom;
        }
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    // Le toString de la classe Personne dpuis un StringBuilder
    @Override
    public String toString() {
        return super.toString() +
            "- Nom : " + nom + ("\n") +
            "- Prenom : " + prenom + ("\n");
    }
}
