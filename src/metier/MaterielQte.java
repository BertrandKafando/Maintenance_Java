package metier;

public class MaterielQte {
    private Materiel materiel;
    private int quantite;

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public MaterielQte(Materiel materiel, int quantite) {
        this.materiel = materiel;
        this.quantite = quantite;


    }
}
