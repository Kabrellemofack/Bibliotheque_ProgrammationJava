package State;

import Book.Livre;

/**
 * État Reservation : Le livre est réservé par un adhérent.
 * Il peut être emprunté, en réparation, ou devenir disponible pour le réservataire.
 */
public class Reservation implements Etat {

    @Override
    public void Emprunte(Livre livre) {
        
        livre.setEtatLivre(new Emprunte()); 
        System.out.println("Le livre '" + livre.getTitre() + "' a été emprunté par le réservataire.");
    }

    @Override
    public void Reservation(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà réservé.");
    }

    @Override
    public void Reparation(Livre livre) {
        livre.setEtatLivre(new Reparation());
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant en réparation (la réservation est maintenue).");
    }

    @Override
    public void Disponible(Livre livre) {
       
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant disponible pour le réservataire.");
      
    }

    

    @Override
    public String getNom() {
        return "Réservé";
    }
}
