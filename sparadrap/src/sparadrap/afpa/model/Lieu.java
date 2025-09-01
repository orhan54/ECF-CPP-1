package sparadrap.afpa.model;

public class Lieu extends Personne {

    // attibuts de la classe Lieu
    private String adresse, email, telephone, ville;
    private int codePostal;

    public Lieu(String nom, String prenom,  String adresse, String email, String telephone, String ville, int codePostal) {
        super(nom, prenom);
        this.setAdresse(adresse);
        this.setEmail(email);
        this.setTelephone(telephone);
        this.setVille(ville);
    }

    // Getters et Setters de la classe Lieu qui extends de Personne
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    // Recupere le super.toString de la classe personne et le toString de la classe Lieu
    @Override
    public String toString() {
        return super.toString()
        + "- Adrsese : " + adresse + ("\n")
        + "- Email : " + email + ("\n")
        + "- Telephone : " + telephone + ("\n")
        + "- Ville : " + ville + ("\n")
        + "-Code postal : " + codePostal + ("\n");
    }
}
