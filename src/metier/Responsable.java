package metier;

import java.util.List;

public class Responsable {
    private int id_respon;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private String password;

    public Responsable(String nom, String prenom, String email, String telephone, String adresse, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
    }

    public Responsable() {
    }

    public Responsable(int id_respon, String nom, String prenom, String email, String telephone, String adresse, String password) {
        this.id_respon = id_respon;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.adresse = adresse;
        this.password = password;
    }

    public int getId_respon() {
        return id_respon;
    }

    public void setId_respon(int id_respon) {
        this.id_respon = id_respon;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  nom + "  " + prenom;
    }
}
