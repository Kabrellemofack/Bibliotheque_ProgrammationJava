package Observer;

/**
 *  methodes pour gérer les observateurs d'un livre.
 */
public interface LivreObservable {
    void addObserver(AdherentObserver observer);    
    void removeObserver(AdherentObserver observer); 
    void notifyObservers();                         
}
