package metier;

import DAO.SingletonConnexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier{
    @Override
    public void ajouterOrdreTravail(OrdreTravail ot) {
        Connection conn= SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into ORDRETRAVAIL(DATE,TYPESERVICE,DESCRIPTION,TEMPS,BUDJET,PRIORITY,ETAT,ID_RESPONSABLE,ID_INTERVENANT,ID_ENTREPRISE) " +
                    "values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setDate(1,ot.getDate());
            pstm.setString(2,ot.getTypeService());
            pstm.setString(3,ot.getDescription());
            pstm.setInt(4,ot.getTemps());
            pstm.setDouble(5,ot.getBudget());
            pstm.setInt(6,ot.getPriorite());
            pstm.setBoolean(7, ot.isEtat());
            pstm.setInt(8,ot.getResponsable().getIdRespon);
            pstm.setInt(9,ot.getIntervenant().getIdIntervenant);
            pstm.setInt(10,ot.getEntreprise().getId);
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifierOrdreTravail(OrdreTravail ot) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("update ordretravail set date=?,set typeService=?,set description=?,set temps=?,set bugjet=?,set priority=?," +
                    "set etat=?,set id_responsable=?,set id_intervenant=?,set id_entreprise=?  where numOrdreTravail=?");
            pstm.setDate(1,ot.getDate());
            pstm.setString(2,ot.getTypeService());
            pstm.setString(3,ot.getDescription());
            pstm.setInt(4,ot.getTemps());
            pstm.setDouble(5,ot.getBudget());
            pstm.setInt(6,ot.getPriorite());
            pstm.setBoolean(7, ot.isEtat());
            pstm.setInt(8,ot.getResponsable().getIdRespon);
            pstm.setInt(9,ot.getIntervenant().getIdIntervenant);
            pstm.setInt(10,ot.getEntreprise().getId);
            pstm.setInt(11, ot.getNumOrdreTravail());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprimerOrdreTravail(OrdreTravail ot) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("delete from ordretravail where numOrdreTravail=?");
            pstm.setInt(1, ot.getNumOrdreTravail());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrdreTravail> getOrdreTravailIntervenant(Intervenant it) {
        Connection conn=SingletonConnexionDB.getConnection();
        List<OrdreTravail> ordreTravails=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from ORDRETRAVAIL where id_intervenant =?");
            pstm.setInt(1,it.getIdIntervenant);
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                PreparedStatement pstm1=conn.prepareStatement("select * from RESPONSABLE where ID_RESPON=?");
                pstm1.setInt(1,rs.getInt("ID_RESPONSABLE"));
                ResultSet rs1= pstm1.executeQuery();
                Responsable r=null;
                if(rs1.next()){
                    r=new Responsable(rs1.getInt("ID_RESPON"),rs1.getString("NOM"),rs1.getString("PRENOM"),rs1.getString("EMAIL"),
                            rs1.getString("TELEPHONE"), rs1.getString("ADRESSE"),rs1.getString("PASSWORD"));
                }
                PreparedStatement pstm2=conn.prepareStatement("select * from ENTREPRISE where ID=?");
                pstm2.setInt(1,rs.getInt("ID_ENTREPRISE"));
                ResultSet rs2= pstm2.executeQuery();
                Entreprise e=null;
                if(rs2.next()){
                    e=new Entreprise(rs2.getInt("ID"),rs2.getString("NOM"),rs2.getString("TELEPHONE"),rs2.getString("EMAIL"));
                }
                OrdreTravail ot=new OrdreTravail(rs.getDate("DATE"),rs.getString("TYPESERVICE"),rs.getString("DESCRIPTION"),
                        rs.getInt("TEMPS"),rs.getDouble("BUDJET"),rs.getInt("PRIORITY"),rs.getBoolean("ETAT"),r,it,e);
                ordreTravails.add(ot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ordreTravails;
    }
}
