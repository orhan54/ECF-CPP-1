package sparadrap.afpa.model;

public class Pharmacie {
    // Attribut de la classe Pharmacie
    private String nom;

    // Constructeur de la classe Pharmacie
    public Pharmacie(String nom) {
        this.nom = nom;
    }

    // Setters et Getters de la classe Pharmacie
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // toString de la classe Pharmacie avec un StringBuilder
    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        o.append("Le nom de la pharmacie est ").append(this.nom).append("\n");

        return o.toString();
    }
}
