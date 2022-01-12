package metier;

import java.util.List;

public interface IMetier {
    void ajouterOrdreTravail(OrdreTravail ot);
    void modifierOrdreTravail(OrdreTravail ot);
    void supprimerOrdreTravail(OrdreTravail ot);
    List<OrdreTravail> getOrdreTravailIntervenant(Intervenant it);
}
