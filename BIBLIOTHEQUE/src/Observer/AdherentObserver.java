package Observer;

import Book.Livre; // Importation de la classe Livre

/**
 * Interface AdherentObserver: Définit la méthode de notification pour les adhérents.
 */
public interface AdherentObserver {
    void update(Livre livre); // Méthode appelée pour notifier l'adhérent d'un changement sur un livre
}
