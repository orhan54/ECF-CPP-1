package sparadrap.afpa.model;

public class Lieu  {

    // attibuts de la classe Lieu
    private String adresse, email, telephone, ville;
    private int codePostal;

    public Lieu(String adresse, String email, String telephone, String ville, int codePostal) {
        this.setAdresse(adresse);
        this.setEmail(email);
        this.setTelephone(telephone);
        this.setVille(ville);
        this.setCodePostal(codePostal);
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
        StringBuilder sbl = new StringBuilder();
        sbl.append("- Adresse: ").append(this.adresse).append("\n");
        sbl.append("- Email: ").append(this.email).append("\n");
        sbl.append("- Telephone: ").append(this.telephone).append("\n");
        sbl.append("- Ville: ").append(this.ville).append("\n");
        sbl.append("- CodePostal: ").append(this.codePostal).append("\n");

        return sbl.toString();
    }
}
