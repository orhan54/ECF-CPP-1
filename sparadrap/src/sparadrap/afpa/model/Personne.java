package sparadrap.afpa.model;

public class Personne {
    private String nom;
    private String prenom;
    private Lieu lieu; // composition : une personne a un lieu

    public Personne(String nom, String prenom, Lieu lieu) {
        this.nom = nom;
        this.prenom = prenom;
        this.lieu = lieu;
    }

    // Getters & Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
