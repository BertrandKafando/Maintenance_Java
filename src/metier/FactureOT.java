package metier;

import java.io.Serializable;
import java.sql.Date;

public class FactureOT implements Serializable {
    private int idFacture;
    private Date date;
    private int temps;
    private String Intervenant;
    private double montant;

    public FactureOT(Date date, int temps, String intervenant, double montant) {
        this.date = date;
        this.temps = temps;
        Intervenant = intervenant;
        this.montant = montant;
    }

    public int getIdFacture() {
        return idFacture;
    }

    public Date getDate() {
        return date;
    }

    public int getTemps() {
        return temps;
    }

    public String getIntervenant() {
        return Intervenant;
    }

    public double getMontant() {
        return montant;
    }
}
