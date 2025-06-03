package Observer;

/**
 * Interface LivreObservable: Définit les méthodes pour gérer les observateurs d'un livre.
 */
public interface LivreObservable {
    void addObserver(AdherentObserver observer);    // Ajoute un observateur
    void removeObserver(AdherentObserver observer); // Supprime un observateur
    void notifyObservers();                         // Notifie tous les observateurs
}
