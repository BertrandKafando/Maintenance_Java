package metier;

public class Entreprise {
    private int id_entr;
    private String nom;
    private String telephone;
    private String email;
    private String adresse;

    public Entreprise(int id_entr, String nom, String telephone, String email, String adresse) {
        this.id_entr = id_entr;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    public Entreprise(String nom, String telephone, String email,String adresse) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    public int getId_entr() {
        return id_entr;
    }

    public void setId_entr(int id_entr) {
        this.id_entr = id_entr;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return nom;
    }
}
