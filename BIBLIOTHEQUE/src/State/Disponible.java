package State;

import Book.Livre;
public class Disponible implements Etat {
    @Override
    public void Emprunte(Livre livre) {
        livre.setEtatLivre(new Emprunte()); // Le livre passe à l'état Emprunté
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant emprunté.");
    }

    @Override
    public void Reservation(Livre livre) {
        livre.setEtatLivre(new Reservation()); // Le livre passe à l'état Réservé
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant réservé.");
    }

    @Override
    public void Reparation(Livre livre) {
        livre.setEtatLivre(new Reparation()); // Le livre passe à l'état En réparation
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant en réparation.");
    }

    @Override
    public void Disponible(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà disponible.");
    }

    @Override
    public String getNom() {
        return "Disponible";
    }
}