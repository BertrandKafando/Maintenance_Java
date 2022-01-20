package metier;

public class Materiel {
    private  int id_materiel;
    private  String designation;

    public Materiel(int id_materiel, String designation) {
        this.id_materiel = id_materiel;
        this.designation = designation;
    }

    public Materiel(String designation) {
        this.designation = designation;
    }



    public int getId_materiel() {
        return id_materiel;
    }

    public void setId_materiel(int id_materiel) {
        this.id_materiel = id_materiel;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return designation;
    }
}
