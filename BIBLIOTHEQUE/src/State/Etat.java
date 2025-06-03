package State;

import Book.Livre;

public interface Etat {
    void Emprunte(Livre livre);     
    void Reservation(Livre livre); 
    void Reparation(Livre livre);   
    void Disponible(Livre livre);  

    String getNom(); 
}
