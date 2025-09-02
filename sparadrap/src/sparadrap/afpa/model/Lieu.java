package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;

import static sparadrap.afpa.utility.RegexUtility.*;

public class Lieu  {

    // attibuts de la classe Lieu
    private String adresse, email, telephone, ville;
    private int codePostal;

    public Lieu(String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        this.setAdresse(pAdresse);
        this.setEmail(pEmail);
        this.setTelephone(pTelephone);
        this.setVille(pVille);
        this.setCodePostal(pCodePostal);
    }

    // Getters et Setters de la classe Lieu qui extends de Personne
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String pAdresse) {           // trouver un regex exemple :  2 rue de la paix
        this.adresse = pAdresse;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String pEmail) throws SaisieException {
        if (!validate(pEmail)) {
            throw new SaisieException("Error sur adresse email : ");
        }else{
            this.email = pEmail;
        }
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String pTelephone) throws SaisieException {
        if (!validatePhone(pTelephone)) {
            throw new SaisieException("Error sur telephone : ");
        }else{
            this.telephone = pTelephone;
        }
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String pVille) throws SaisieException {
        if(!regexAlpha(pVille)) {
            throw new SaisieException("Error sur le nom de la ville : ");
        }else{
            this.ville = pVille;
        }
    }

    public int getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(int pCodePostal) throws SaisieException {
        if (!positifInt(String.valueOf(pCodePostal)) && String.valueOf(pCodePostal).length() == 5) {
            throw new SaisieException("Error sur code postal : ");
        }else{
            this.codePostal = pCodePostal;
        }
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
