package sparadrap.afpa.model;

public class Personne {

    // Attribut de la classe personne
    private String nom, prenom;

    // Constructeur de la classe Personne
    public Personne(String nom, String prenom) {
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
    public String toString(){
        StringBuilder p = new StringBuilder();
        p.append("- Nom : ").append(this.nom).append("\n");
        p.append("- Prenom : ").append(this.prenom).append("\n");

        return p.toString();
    }
}
