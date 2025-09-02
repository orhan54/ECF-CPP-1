package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

public class Pharmacie {
    // Attribut de la classe Pharmacie
    private String nom;

    // Constructeur de la classe Pharmacie
    public Pharmacie(String pNom) throws SaisieException {
        this.setNom(pNom);
    }

    // Setters et Getters de la classe Pharmacie
    public String getNom() {
        return this.nom;
    }

    public void setNom(String pNom) {
        this.nom = pNom;
    }

    // toString de la classe Pharmacie avec un StringBuilder
    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        o.append("Le nom de la pharmacie est ").append(this.nom).append("\n");

        return o.toString();
    }
}
