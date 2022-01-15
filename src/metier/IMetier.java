package metier;

import java.util.List;

public interface IMetier {
    void ajouterOrdreTravail(OrdreTravail ot);
    void modifierOrdreTravail(OrdreTravail ot);
    void supprimerOrdreTravail(OrdreTravail ot);
    List<OrdreTravail> getOrdreTravailIntervenant(Intervenant it);
    List<OrdreTravail> getAllOrdreTravail();

    void ajouterResponsable(Responsable responsable);
    void supprimerResponsable(Responsable responsable);
    void modifierlesinformations(Responsable responsable);
    Responsable getResponsable();
    List<Responsable>getResponsables();

    void ajouterMateriel(Materiel materiel);
    void supprimerMateriel(Materiel materiel);
    void modifierMateriel(Materiel materiel);
    List<Materiel>getMateriels();
    List<Materiel>getMaterielsbyordres(OrdreTravail odt);


    void ajouterEntreprise(Entreprise entreprise);
    void supprimerEntreprise(Entreprise entreprise);
    void modifierEntreprise(Entreprise entreprise);
    List<Entreprise>getEntreprises();


    Intervenant searchInterById(int id);
    Intervenant searchInterByName(String name);
    void AddInter(Intervenant inter);
    void deleteInter(int id);
    void updateInter(Intervenant inter);
    List<Intervenant> getAllInter();

}
