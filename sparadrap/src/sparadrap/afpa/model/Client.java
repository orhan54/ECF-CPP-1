package sparadrap.afpa.model;

public class Client extends Personne {

    // Attribut de la classe Client
    private int numeroSecuriteSociale;

    public Client(String nom, String prenom) {
        super(nom, prenom);
        this.setNumeroSecuriteSociale(numeroSecuriteSociale);
    }

    // Getters et Setters
    public int getNumeroSecuriteSociale() {
        return this.numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(int numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    // toString de la classe Personne et de la classe Client
    @Override
    public String toString() {
        return super.toString()
            + "- Numero de sécurité social : " + numeroSecuriteSociale;
    }
}
