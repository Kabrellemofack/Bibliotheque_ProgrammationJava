package State;

import Book.Livre;

/**
 * État Emprunté : Le livre est actuellement emprunté par un adhérent.
 */
public class Emprunte implements Etat {

    @Override
    public void Emprunte(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà emprunté.");
    }

    @Override
    public void Reservation(Livre livre) {
        // Un livre emprunté peut être réservé pour l'adhérent suivant
        livre.setEtatLivre(new Reservation());
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant réservé (en attente de retour).");
    }

    @Override
    public void Reparation(Livre livre) {
        // Le livre passe en réparation (en supposant qu'il est récupéré pour cela)
        livre.setEtatLivre(new Reparation());
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant en réparation.");
    }

    @Override
    public void Disponible(Livre livre) {
        // Lorsqu'un livre emprunté est rendu, il devient disponible
        livre.setEtatLivre(new Disponible());
        System.out.println("Le livre '" + livre.getTitre() + "' a été retourné et est maintenant disponible.");
        // Si un adhérent l'avait réservé, on peut le notifier via Observer
    }


    @Override
    public String getNom() {
        return "Emprunté";
    }
}
