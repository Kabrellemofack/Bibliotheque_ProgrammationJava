package Observer;

import Book.Livre;

/**
 * Interface AdherentObserver: Définit la méthode de notification pour les adhérents.
 */
public interface AdherentObserver {
    void update(Livre livre); 
}
  