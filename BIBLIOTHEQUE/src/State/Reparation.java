package State;

import Book.Livre;

 //en reparation le livre n'est pas dispo
public class Reparation implements Etat {
    @Override
    public void Emprunte(Livre livre) {
        System.out.println("Impossible d'emprunter le livre '" + livre.getTitre() + "', il est en réparation.");
    }

    @Override
    public void Reservation(Livre livre) {
        System.out.println("Impossible de réserver le livre '" + livre.getTitre() + "', il est en réparation.");
    }


    @Override
    public void Reparation(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà en réparation.");
    }




    @Override
    public void Disponible(Livre livre) {
        livre.setEtatLivre(new Disponible()); 
        System.out.println("Le livre '" + livre.getTitre() + "' a été réparé et est maintenant disponible.");
        
    }

    @Override
    public String getNom() {
        return "En réparation";
    }
}
