package sparadrap.afpa.model;

public class Personne extends Lieu {

    // Attribut de la classe personne
    private String nom, prenom;

    // Constructeur de la classe Personne
    public Personne(String nom, String prenom, String adresse, String email, String telephone, String ville, int codePostal) {
        super(adresse, email, telephone, ville, codePostal);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    // Getters et Setters pour acceder au attributs prive de la classe
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Le toString de la classe Personne dpuis un StringBuilder
    @Override
    public String toString() {
        return super.toString() +
            "- Nom : " + nom + ("\n") +
            "- Prenom : " + prenom + ("\n");
    }
}
