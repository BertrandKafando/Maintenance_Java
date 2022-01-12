package metier;

import java.util.List;

public interface IMetier {
    void ajouterOrdreTravail(OrdreTravail ot);
    void modifierOrdreTravail(OrdreTravail ot);
    void supprimerOrdreTravail(OrdreTravail ot);
    List<OrdreTravail> getOrdreTravailIntervenant(Intervenant it);

    void ajouterResponsable(Responsable responsable);
    void supprimerResponsable(Responsable responsable);
    void modifierlesinformations(Responsable responsable);

    void ajouterMateriel(Materiel materiel);
    void supprimerMateriel(Materiel materiel);
    void modifierMateriel(Materiel materiel);


    void ajouterEntreprise(Entreprise entreprise);
    void supprimerEntreprise(Entreprise entreprise);
    void modifierEntreprise(Entreprise entreprise);

}
