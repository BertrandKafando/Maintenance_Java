package metier;

public class Intervenant {
    private int id_intervenant;
  private   String nom;
  private   String prenom;
  private   String email;
  private   String tel;
  private   String adresse;
  private   String password;

    public Intervenant(int id, String nom, String prenom, String email, String tel, String adresse, String password) {
        this.id_intervenant = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adresse = adresse;
        this.password = password;
    }

    public int getId_intervenant() {
        return id_intervenant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setId_intervenant(int id) {
        this.id_intervenant = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        return nom + ' ' + prenom;
=======
        return  nom +"  " +prenom ;
>>>>>>> 17a92ba1329dc58e19893c4ad69408a4b4b7b5a7
    }
}
