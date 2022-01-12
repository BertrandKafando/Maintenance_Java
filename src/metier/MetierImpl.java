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
                OrdreTravail ot=new OrdreTravail(rs.getDate("DATE"),rs.getString("TYPESERVICE"),rs.getString("DESCRIPTION"),
                        rs.getInt("TEMPS"),rs.getDouble("BUDJET"),rs.getInt("PRIORITY"),rs.getBoolean("ETAT"),
                        rs.getString("DATE_RECRUTEMENT"),d);
                profs.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  profs;
    }
}
