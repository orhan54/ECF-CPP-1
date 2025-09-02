package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

public class Personne extends Lieu {

    // Attribut de la classe personne
    private String nom, prenom;

    // Constructeur de la classe Personne
    public Personne(String pNom, String pPrenom, String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        super(pAdresse, pEmail, pTelephone, pVille, pCodePostal);
        this.setNom(pNom);
        this.setPrenom(pPrenom);
    }

    // Getters et Setters pour acceder au attributs prive de la classe
    public String getNom() {
        return this.nom;
    }

    public void setNom(String pNom) {
        this.nom = pNom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String pPrenom) {
        this.prenom = pPrenom;
    }

    // Le toString de la classe Personne dpuis un StringBuilder
    @Override
    public String toString() {
        return super.toString() +
            "- Nom : " + nom + ("\n") +
            "- Prenom : " + prenom + ("\n");
    }
}
