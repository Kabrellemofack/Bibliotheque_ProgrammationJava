package State;

import Book.Livre;

public class Emprunte implements Etat {
    @Override
    public void Emprunte(Livre livre) {
        System.out.println("Le livre '" + livre.getTitre() + "' est déjà emprunté.");
    }

    @Override
    public void Reservation(Livre livre) {
        // Un livre emprunté peut être réservé (par un autre adhérent)
        livre.setEtatLivre(new Reservation()); // Le livre passe à l'état Réservé
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant réservé (en attente de retour).");
    }

    @Override
    public void Reparation(Livre livre) {
        livre.setEtatLivre(new Reparation()); // Le livre passe à l'état En réparation
        System.out.println("Le livre '" + livre.getTitre() + "' est maintenant en réparation (doit être retourné d'abord).");
    }

    @Override
    public void Disponible(Livre livre) {
        livre.setEtatLivre(new Disponible()); // Le livre est retourné et devient Disponible
        System.out.println("Le livre '" + livre.getTitre() + "' a été retourné et est maintenant disponible.");
        // Ici, si le livre était réservé, il faudrait notifier l'adhérent suivant.
        // Cette logique sera gérée dans Bibliotheque avec le patron Observer.
    }

    @Override
    public String getNom() {
        return "Emprunté";
    }
}
