package metier;


import DAO.SingletonConnexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MetierImpl implements IMetier{
    public  static Intervenant StaticIntervenant=null;
    public static Responsable StaticResponsable=null;
    public void setPriorityOrdre(Date date){
        Connection conn= SingletonConnexionDB.getConnection();
        OrdreTravail ot=null;
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into ORDRETRAVAIL(date,typeService,description,temps,budjet,priority,etat,id_responsable,id_intervenant,id_entreprise values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setDate(1,new Date(ot.getDate().getTime()));
            pstm.setString(2,ot.getTypeService());
            pstm.setString(3,ot.getDescription());
            pstm.setInt(4,ot.getTemps());
            pstm.setDouble(5,ot.getBudget());
            pstm.setInt(6,ot.getPriorite());
            pstm.setBoolean(7, ot.isEtat());
            pstm.setInt(8,ot.getResponsable().getId_respon());
            pstm.setInt(9,ot.getIntervenant().getId_intervenant());
            pstm.setInt(10,ot.getEntreprise().getId_entr());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<OrdreTravail> getAllOrdreTravailSort() {
        return null;
    }

    @Override
    public List<OrdreTravail> getAllOrdreTravailParMC(String mot) {
        Connection conn=SingletonConnexionDB.getConnection();
        List<OrdreTravail> ordres=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from ORDRETRAVAIL where description like ?");
            pstm.setString(1,"%"+mot+"%");
            pstm.executeQuery();
            ResultSet rs= pstm.getResultSet();
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
                    e=new Entreprise(rs2.getInt("ID"),rs2.getString("NOM"),rs2.getString("TELEPHONE"),rs2.getString("EMAIL"),rs2.getString("ADRESSE"));
                }

                PreparedStatement stm=conn.prepareStatement("select * from intervenant where id_intervenant=?");
                stm.setInt(1,rs.getInt("id_intervenant"));
                ResultSet rs3=stm.executeQuery();
                Intervenant it=null;
                if(rs3.next()){
                    it=new Intervenant(rs3.getInt("id_intervenant"),rs3.getString("nom"),rs3.getString("prenom"),rs3.getString("email"),rs3.getString("telephone"),
                            rs3.getString("adresse"),rs3.getString("password"));
                }

                OrdreTravail ot=new OrdreTravail(rs.getInt("numOrdreTravail"),rs.getDate("DATE"),rs.getString("TYPESERVICE"),rs.getString("DESCRIPTION"),
                        rs.getInt("TEMPS"),rs.getDouble("BUDGET"),rs.getInt("PRIORITY"),rs.getBoolean("ETAT"),r,it,e);
                ordres.add(ot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ordres;
    }

    @Override
    public void ajouterOrdreTravail(OrdreTravail ot) {
        Connection conn= SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into ordreTravail(date,typeService,description,temps,budget,priority,etat,id_responsable,id_intervenant,id_entreprise) values (?,?,?,?,?,?,?,?,?,?)");
            pstm.setDate(1,ot.getDate());
            pstm.setString(2,ot.getTypeService());
            pstm.setString(3,ot.getDescription());
            pstm.setInt(4,ot.getTemps());
            pstm.setDouble(5,ot.getBudget());
            pstm.setInt(6,ot.getPriorite());
            pstm.setBoolean(7, ot.isEtat());
            pstm.setInt(8,ot.getResponsable().getId_respon());
            pstm.setInt(9,ot.getIntervenant().getId_intervenant());
            pstm.setInt(10,ot.getEntreprise().getId_entr());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifierOrdreTravail(OrdreTravail ot) {
        Connection conn = SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("update ordretravail set date=?,typeService=?,description=?,temps=?,budget=?,priority=?,etat=?,id_responsable=?,id_intervenant=?,id_entreprise=?  where numOrdreTravail=?");
            pstm.setDate(1, new Date(ot.getDate().getTime()));
            pstm.setString(2,ot.getTypeService());
            pstm.setString(3,ot.getDescription());
            pstm.setInt(4,ot.getTemps());
            pstm.setDouble(5,ot.getBudget());
            pstm.setInt(6,ot.getPriorite());
            pstm.setBoolean(7, ot.isEtat());
            pstm.setInt(8,ot.getResponsable().getId_respon());
            pstm.setInt(9,ot.getIntervenant().getId_intervenant());
            pstm.setInt(10,ot.getEntreprise().getId_entr());
            pstm.setInt(11, ot.getNumOrdreTravail());

            pstm.executeUpdate();
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
            pstm.setInt(1,it.getId_intervenant());
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
                    e=new Entreprise(rs2.getInt("ID"),rs2.getString("NOM"),rs2.getString("TELEPHONE"),rs2.getString("EMAIL"),rs2.getString("ADRESSE"));
                }
                OrdreTravail ot=new OrdreTravail(rs.getInt("numOrdreTravail"),rs.getDate("DATE"),rs.getString("TYPESERVICE"),rs.getString("DESCRIPTION"),
                        rs.getInt("TEMPS"),rs.getDouble("BUDGET"),rs.getInt("PRIORITY"),rs.getBoolean("ETAT"),r,it,e);
                ordreTravails.add(ot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ordreTravails;
    }

    @Override
    public List<OrdreTravail> getAllOrdreTravail() {
        Connection conn=SingletonConnexionDB.getConnection();
        List<OrdreTravail> ordreTravails=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from ORDRETRAVAIL ");
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
                    e=new Entreprise(rs2.getInt("ID"),rs2.getString("NOM"),rs2.getString("TELEPHONE"),rs2.getString("EMAIL"),rs2.getString("ADRESSE"));
                }

                PreparedStatement stm=conn.prepareStatement("select * from intervenant where id_intervenant=?");
                stm.setInt(1,rs.getInt("id_intervenant"));
                ResultSet rs3=stm.executeQuery();
                Intervenant it=null;
                if(rs3.next()){
                    it=new Intervenant(rs3.getInt("id_intervenant"),rs3.getString("nom"),rs3.getString("prenom"),rs3.getString("email"),rs3.getString("telephone"),
                            rs3.getString("adresse"),rs3.getString("password"));
                }
                OrdreTravail ot=new OrdreTravail(rs.getInt("numOrdreTravail"),rs.getDate("date"),rs.getString("TYPESERVICE"),rs.getString("DESCRIPTION"),
                        rs.getInt("TEMPS"),rs.getDouble("BUDGET"),rs.getInt("PRIORITY"),rs.getBoolean("ETAT"),r,it,e);
                ordreTravails.add(ot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ordreTravails;
    }

    @Override
    public void ajouterResponsable(Responsable responsable) {
        Connection connection= SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm=connection.prepareStatement("insert into responsable(nom,prenom,email,telephone,adresse,password) values (?,?,?,?,?,?)");
            stm.setString(1,responsable.getNom()); stm.setString(2,responsable.getPrenom()); stm.setString(3, responsable.getEmail());
            stm.setString(4, responsable.getTelephone());stm.setString(5, responsable.getAdresse());stm.setString(6,responsable.getPassword());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void supprimerResponsable(Responsable responsable) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("delete from responsable where id_respon=?");
            pstm.setInt(1,responsable.getId_respon());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void modifierlesinformations(Responsable responsable) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm=connection.prepareStatement("update responsable set nom=?,prenom=?,email=?,telephone=?,adresse=?,password=?"+"where id_respon=?");
            stm.setString(1,responsable.getNom()); stm.setString(2,responsable.getPrenom()); stm.setString(3, responsable.getEmail());
            stm.setString(4, responsable.getTelephone());stm.setString(5, responsable.getAdresse());stm.setString(6,responsable.getPassword());
            stm.setInt(7,responsable.getId_respon());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public Responsable getResponsable() {
        Connection connection=SingletonConnexionDB.getConnection();
        Responsable responsable=new Responsable();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from responsable ");
            ResultSet res= stm.executeQuery();
            if(res.next()){
                responsable.setId_respon(res.getInt(1));responsable.setNom(res.getString(2));responsable.setPrenom(res.getString(3));
                responsable.setEmail(res.getString(4));responsable.setTelephone(res.getString(5));responsable.setAdresse(res.getString(6));
                responsable.setPassword(res.getString(7));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return responsable;
    }

    @Override
    public List<Responsable> getResponsables() {

        Connection conn=SingletonConnexionDB.getConnection();
        List<Responsable> resps=new ArrayList<>();
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from responsable");
            ResultSet rs= pstm.executeQuery();
            while (rs.next()){
                Responsable r=new Responsable(rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("telephone"),rs.getString("adresse"),rs.getString("password"));
                resps.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  resps;
    }


    @Override
    public void ajouterMateriel(Materiel materiel) {
        Connection connection= SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm=connection.prepareStatement("insert into materiel(designation) values (?)");
            stm.setString(1,materiel.getDesignation());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void supprimerMateriel(Materiel materiel) {
        Connection conn=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement("delete from materiel where id_materiel=?");
            pstm.setInt(1,materiel.getId_materiel());
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void modifierMateriel(Materiel materiel) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm=connection.prepareStatement("update materiel set nom=? where id_materiel=?");
            stm.setInt(1,materiel.getId_materiel());
            stm.setString(2,materiel.getDesignation());
            stm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Materiel>getAllMateriel(){
        Connection conn = SingletonConnexionDB.getConnection();
        List<Materiel> materiels = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from materiel");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Materiel materiel = new Materiel(rs.getInt(1), rs.getString(2) );

                materiels.add(materiel);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return materiels;
    }

    @Override
    public List<MaterielQte> getMaterielsbyordres(OrdreTravail odt) {
        Connection conn=SingletonConnexionDB.getConnection();
        List<MaterielQte> mqs=new ArrayList<>();
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from materiel_ordre where id_ordretravail=? ");
            pstm.setInt(1,odt.getNumOrdreTravail());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                PreparedStatement pstm1 = conn.prepareStatement("select * from materiel where id_materiel=?");
                pstm1.setInt(1, rs.getInt("id_materiel"));
                ResultSet rs1 = pstm1.executeQuery();

                Materiel m=null;
                if (rs1.next()) {
                    m= new Materiel(rs1.getInt("id_materiel"), rs1.getString("designation"));
                }
                MaterielQte mq = new MaterielQte(m,rs.getInt("quantit??"));
                mqs.add(mq);
            }
        }catch (Exception e){
        e.printStackTrace();
    }
  return mqs;

    }

    @Override
    public void ajouterMaterielAOrdreTravail(OrdreTravail ot, Materiel materiel, int quantite){
        Connection conn=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into materiel_ordre(id_materiel,id_ordretravail,quantit??) values (?,?,?)");

            pstm.setInt(1,materiel.getId_materiel());
            pstm.setInt(2,ot.getNumOrdreTravail());
            pstm.setInt(3,quantite);

            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void ajouterEntreprise(Entreprise entreprise) {
        Connection connection=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=connection.prepareStatement("insert into entreprise(nom,telephone,email,adresse) values (?,?,?,?)");
            pstm.setString(1,entreprise.getNom());
            pstm.setString(2,entreprise.getTelephone()); pstm.setString(3,entreprise.getEmail());
            pstm.setString(4,entreprise.getAdresse());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void supprimerEntreprise(Entreprise entreprise) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("delete from entreprise where id_entr=?");
            pstm.setInt(1,entreprise.getId_entr());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    @Override
    public void modifierEntreprise(Entreprise entreprise) {
        Connection connection=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=connection.prepareStatement("update entreprise set nom=?,telephone=?,email=?");
            pstm.setString(1,entreprise.getNom()); pstm.setString(2,entreprise.getTelephone()); pstm.setString(3,entreprise.getEmail());
            pstm.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Entreprise nameEntrepriseToObject(String name){
        Connection conn = SingletonConnexionDB.getConnection();
        Entreprise entreprise = null;
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from entreprise where nom = ?");
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
                entreprise = new Entreprise(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString("ADRESSE"));
        } catch (Exception e){
            e.printStackTrace();
        }
        return entreprise;
    }

    @Override
    public List<Entreprise> getAllEntreprise() {

        Connection conn = SingletonConnexionDB.getConnection();
        List<Entreprise> entrprises = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from entreprise");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Entreprise entreprise = new Entreprise(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString("ADRESSE"));

                entrprises.add(entreprise);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entrprises;

    }
    @Override
    public Intervenant searchInterById(int id) {
        Connection conn=SingletonConnexionDB.getConnection();
        Intervenant inter = null;
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from intervenant where id_intervenant = ?" );
            pstm.setInt(1, id);
            ResultSet rs= pstm.executeQuery();
            if(rs != null){
                rs.next();
                inter = new Intervenant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return inter;
    }

    @Override
    public Intervenant searchInterByName(String name) {
        Connection conn=SingletonConnexionDB.getConnection();
        Intervenant inter = null;
        try {
            PreparedStatement pstm=conn.prepareStatement("select * from intervenant where nom LIKE ?" );
            pstm.setString(1, "%"+name+"%");
            ResultSet rs= pstm.executeQuery();
            if(rs != null){
                rs.next();
                inter = new Intervenant(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return inter;
    }

    @Override
    public void AddInter(Intervenant inter) {
        Connection conn=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("insert into Intervenant(nom,prenom,email,telephone,adresse,password) values (?,?,?,?,?,?)");

            pstm.setString(1,inter.getNom());
            pstm.setString(2,inter.getPrenom());
            pstm.setString(3,inter.getEmail());
            pstm.setString(4,inter.getTel());
            pstm.setString(5,inter.getAdresse());
            pstm.setString(6,inter.getPassword());


            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteInter(Intervenant it) {

        Connection conn=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("delete  from intervenant where id_intervenant = ?" );
            pstm.setInt(1,it.getId_intervenant() );
            pstm.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateInter(Intervenant inter) {
        Connection conn=SingletonConnexionDB.getConnection();
        try {
            PreparedStatement pstm=conn.prepareStatement("update intervenant set nom = ?, prenom = ?,email = ?, telephone = ?, adresse = ?, password = ? where id_intervenant = ?");
            pstm.setString(1,inter.getNom());
            pstm.setString(2,inter.getPrenom());
            pstm.setString(3,inter.getEmail());
            pstm.setString(4,inter.getTel());
            pstm.setString(5,inter.getAdresse());
            pstm.setString(6,inter.getPassword());
            pstm.setInt(7,inter.getId_intervenant());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Intervenant nameInterToObject(String name){
        Connection conn = SingletonConnexionDB.getConnection();
        Intervenant inter = null;
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from intervenant where nom = ?");
            pstm.setString(1, name);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
                inter = new Intervenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
        } catch (Exception e){
            e.printStackTrace();
        }
        return inter;
    }

    @Override
    public List<Intervenant> getAllInter() {

        Connection conn = SingletonConnexionDB.getConnection();
        List<Intervenant> intervenants = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from intervenant");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Intervenant inter = new Intervenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

                intervenants.add(inter);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return intervenants;
    }

    public int login(String interOrResp, String email, String password) {
        Connection conn = SingletonConnexionDB.getConnection();

        int test = 0;
        try {
            if (interOrResp.equals("Intervenant")) {
                PreparedStatement pstm = conn.prepareStatement("select * from intervenant where email = ?");
                pstm.setString(1, email);
                ResultSet rs = pstm.executeQuery();
                rs.next();

                if (rs != null) {
                    if (rs.getString("password").equals(password)) {
                        StaticIntervenant = new Intervenant(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                        test = 1;
                    }
                    else test = -1;
                } else if (interOrResp.equals("Responsable")) {
                    PreparedStatement pstm1 = conn.prepareStatement("select * from responsable where email = ?");
                    pstm1.setString(1, email);
                    ResultSet res = pstm1.executeQuery();
                    rs.next();
                    if (rs!=null) {
                        if (rs.getString("password").equals(password)){
                            StaticResponsable = new Responsable(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                            test = 1;
                        }
                        else test = -1;
                    }

                    } else test = -1;

            } else if (interOrResp.equals("Responsable")) {
                PreparedStatement pstm1 = conn.prepareStatement("select * from responsable where email = ?");
                pstm1.setString(1, email);
                ResultSet rs = pstm1.executeQuery();
                rs.next();
                if (rs != null) {
                    if (rs.getString("password").equals(password)) {
                        StaticResponsable = new Responsable(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                        test = 1;
                    } else test = -1;
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return  test;
    }


    }


