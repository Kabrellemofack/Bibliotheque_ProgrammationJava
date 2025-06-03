package State;

import Book.Livre; // Importation de la classe Livre

/**
 * État Reserve: Le livre est réservé par un adhérent.
 * Il peut être emprunté (si disponible) ou en attente de retour.
 */
public class Reservation implements Etat {
    @Override
    public void Emprunte(Livre livre) {
        // Un livre réservé peut être emprunté si c'est l'adhérent qui a réservé
        livre.setEtatLivre(new Emprunte()); // Le livre passe à l'état Emprunté
        System.out.println("Le livre '" + livre.getTitre() + "' a été emprunté par le réservataire.");
    }

    @Override
    public void Reservation(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà réservé.");
    }

    @Override
    public void Reparation(Livre livre) {
        livre.setEtatLivre(new Reparation()); // Le livre passe à l'état En réparation
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant en réparation (la réservation est maintenue).");
    }

    @Override
    public void Disponible(Livre livre) {
        // Si un livre réservé devient disponible (par exemple, après réparation),
        // il reste réservé mais est prêt à être emprunté par le réservataire.
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant disponible pour le réservataire.");
        // C'est ici que la notification de l'observateur (adhérent) aura lieu.
    }

    @Override
    public String getNom() {
        return "Réservé";
    }
}
