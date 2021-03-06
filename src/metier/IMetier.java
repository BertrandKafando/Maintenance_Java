package metier;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface IMetier {

    static List<OrdreTravail> ordresTravail = new ArrayList<>();
    void ajouterOrdreTravail(OrdreTravail ot);
    void modifierOrdreTravail(OrdreTravail ot);
    void supprimerOrdreTravail(OrdreTravail ot);
    void setPriorityOrdre(Date date);
    List<OrdreTravail> getAllOrdreTravailSort();
    List<OrdreTravail> getAllOrdreTravailParMC(String mot);
    List<OrdreTravail> getOrdreTravailIntervenant(Intervenant it);
    List<OrdreTravail> getAllOrdreTravail();

    void ajouterResponsable(Responsable responsable);
    void supprimerResponsable(Responsable responsable);
    void modifierlesinformations(Responsable responsable);
    //Responsable IdRespToNod(int id);
    Responsable getResponsable();
    List<Responsable>getResponsables();

    void ajouterMateriel(Materiel materiel);
    void supprimerMateriel(Materiel materiel);
    void modifierMateriel(Materiel materiel);
    List<Materiel>getAllMateriel();
    List<MaterielQte>getMaterielsbyordres(OrdreTravail odt);

    void ajouterMaterielAOrdreTravail(OrdreTravail ot, Materiel materiel,int quantite);



    void ajouterEntreprise(Entreprise entreprise);
    void supprimerEntreprise(Entreprise entreprise);
    void modifierEntreprise(Entreprise entreprise);
    Entreprise nameEntrepriseToObject(String name);
    List<Entreprise> getAllEntreprise();


    Intervenant searchInterById(int id);
    Intervenant searchInterByName(String name);
    void AddInter(Intervenant inter);
    void deleteInter(Intervenant it);
    void updateInter(Intervenant inter);
    Intervenant nameInterToObject(String name);
    List<Intervenant> getAllInter();

    int login(String interOrResp, String email, String password);

}
