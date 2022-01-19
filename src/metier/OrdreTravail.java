package metier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrdreTravail {
    private int numOrdreTravail;
    private Date date;
    private String typeService;
    private String description;
    private int temps;
    private double budget;
    private int priorite;
    private boolean etat;
    private Responsable responsable;
    private Intervenant intervenant;
    private Entreprise entreprise;
    List<Materiel>materiels=new ArrayList<>();

    public OrdreTravail(int numOrdreTravail, Date date, String typeService, String description, int temps, double budget, int priorite, boolean etat, Responsable responsable, Intervenant intervenant, Entreprise entreprise) {
        this.numOrdreTravail = numOrdreTravail;
        this.date = date;
        this.typeService = typeService;
        this.description = description;
        this.temps = temps;
        this.budget = budget;
        this.priorite = priorite;
        this.etat = etat;
        this.responsable = responsable;
        this.intervenant = intervenant;
        this.entreprise = entreprise;
    }
    public OrdreTravail(Date date, String typeService, String description, int temps, double budget, int priorite, boolean etat, Responsable responsable, Intervenant intervenant, Entreprise entreprise) {
        this.date = date;
        this.typeService = typeService;
        this.description = description;
        this.temps = temps;
        this.budget = budget;
        this.priorite = priorite;
        this.etat = etat;
        this.responsable = responsable;
        this.intervenant = intervenant;
        this.entreprise = entreprise;
    }


    public OrdreTravail(int numOrdreTravail, int priorite) {
        this.numOrdreTravail = numOrdreTravail;
        this.priorite = priorite;
    }



    public int getNumOrdreTravail() {
        return numOrdreTravail;
    }

    public void setNumOrdreTravail(int numOrdreTravail) {
        this.numOrdreTravail = numOrdreTravail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        return "OrdreTravail{" +
                "numOrdreTravail=" + numOrdreTravail +
                ", date=" + date +
                ", typeService='" + typeService + '\'' +
                ", description='" + description + '\'' +
                ", temps=" + temps +
                ", budget=" + budget +
                ", priorite=" + priorite +
                ", etat=" + etat +
                ", responsable=" + responsable +
                ", intervenant=" + intervenant +
                ", entreprise=" + entreprise +
                ", materiels=" + materiels +
                '}';
    }
}
