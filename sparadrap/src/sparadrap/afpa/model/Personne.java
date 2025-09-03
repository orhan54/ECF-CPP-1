package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import static sparadrap.afpa.utility.RegexUtility.regexAlpha;

public class Personne {
    // Ajoute obj Lieu dans la classe Personne
    Lieu lieu = new Lieu("2 rue de la paix", "test@test.fr", "+33383819000", "pam", 54700);

    // Attribut de la classe personne
    private String nom, prenom;

    // Constructeur de la classe Personne
    public Personne(String pNom, String pPrenom, String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        this.setNom(pNom);
        this.setPrenom(pPrenom);
    }

    // Getters et Setters pour acceder au attributs prive de la classe
    public String getNom() {
        return this.nom;
    }

    public void setNom(String pNom) throws SaisieException {
        if (!regexAlpha(pNom) && pNom.isEmpty()) {
            throw new SaisieException("Error sur le nom de la personne : " + pNom);
        }else{
            this.nom = pNom;
        }
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String pPrenom)  throws SaisieException {
        if (!regexAlpha(pPrenom) && pPrenom.isEmpty()) {
            throw new SaisieException("Error sur le prenom de la personne : " + pPrenom);
        }else{
            this.prenom = pPrenom;
        }
    }

    // Le toString de la classe Personne dpuis un StringBuilder
    @Override
    public String toString() {
        return super.toString() +
            "- Nom : " + nom + ("\n") +
            "- Prenom : " + prenom + ("\n");
    }
}
