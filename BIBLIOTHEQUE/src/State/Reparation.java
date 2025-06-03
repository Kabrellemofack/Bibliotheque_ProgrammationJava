package State;

import Book.Livre; // Importation de la classe Livre

/**
 * État EnReparation: Le livre est en cours de réparation et n'est pas disponible.
 */
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
        livre.setEtatLivre(new Disponible()); // Le livre est réparé et redevient Disponible
        System.out.println("Le livre '" + livre.getTitre() + "' a été réparé et est maintenant disponible.");
        // Si le livre était réservé avant la réparation, il faudrait notifier l'adhérent.
    }

    @Override
    public String getNom() {
        return "En réparation";
    }
}
