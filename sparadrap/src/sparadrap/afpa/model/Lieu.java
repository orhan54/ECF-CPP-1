package sparadrap.afpa.model;

import sparadrap.afpa.exception.SaisieException;
import static sparadrap.afpa.utility.RegexUtility.*;

public class Lieu {

    // attributs
    private String adresse, email, telephone, ville;
    private int codePostal;

    // constructeur
    public Lieu(String pAdresse, String pEmail, String pTelephone, String pVille, int pCodePostal) throws SaisieException {
        this.setAdresse(pAdresse);
        this.setEmail(pEmail);
        this.setTelephone(pTelephone);
        this.setVille(pVille);
        this.setCodePostal(pCodePostal);
    }

    // Getters & Setters
    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String pAdresse) throws SaisieException {
        if (!validateAdresse(pAdresse)) {
            throw new SaisieException("Erreur adresse invalide : " + pAdresse);
        }
        this.adresse = pAdresse;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String pEmail) throws SaisieException {
        if (!validate(pEmail)) {
            throw new SaisieException("Erreur sur adresse email : " + pEmail);
        }
        this.email = pEmail;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String pTelephone) throws SaisieException {
        if (!validatePhone(pTelephone)) {
            throw new SaisieException("Erreur sur téléphone : " + pTelephone);
        }
        this.telephone = pTelephone;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String pVille) throws SaisieException {
        if (!regexAlpha(pVille) || pVille.isEmpty()) {
            throw new SaisieException("Erreur sur le nom de la ville : " + pVille);
        }
        this.ville = pVille;
    }

    public int getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(int pCodePostal) throws SaisieException {
        String codeStr = String.valueOf(pCodePostal);
        if (!positifInt(codeStr) || codeStr.length() != 5) {
            throw new SaisieException("Erreur sur code postal : " + pCodePostal);
        }
        this.codePostal = pCodePostal;
    }

    @Override
    public String toString() {
        StringBuilder sbl = new StringBuilder();
        sbl.append("- Adresse: ").append(this.adresse).append("\n");
        sbl.append("- Email: ").append(this.email).append("\n");
        sbl.append("- Téléphone: ").append(this.telephone).append("\n");
        sbl.append("- Ville: ").append(this.ville).append("\n");
        sbl.append("- Code Postal: ").append(this.codePostal).append("\n");
        return sbl.toString();
    }
}
