package Observer;

import Book.Livre;
import EMPRUNT.Emprunt;
import State.Etat;
import State.Disponible;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Adherent implements Observer {
    private String adherentID;
    private String nom;
    private String prenom;
    private List<Emprunt> empruntsEnCours;
   

    public Adherent(String adherentID, String nom, String prenom) {
        this.adherentID = adherentID;
        this.nom = nom;
        this.prenom = prenom;
        
        this.empruntsEnCours = new ArrayList<>();
    }

    public String getAdherentID() {
        return adherentID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

   

    public List<Emprunt> getEmpruntsEnCours() {
        return empruntsEnCours;
    }

    public void afficherInfos() {
        System.out.println(" **Adhérent** ");
        System.out.println("ID: " + adherentID);
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
    }

    private Date calculerDateRetourPrevu(Livre livre, Date dateEmprunt) {
        long dureePretMillis;
        Etat etatLivre = livre.getEtatLivre(); // Récupérer l'objet Etat

        if (etatLivre != null) {
            String nomEtat = etatLivre.getNom();
            switch (nomEtat) {
                case "Neuf":
                    dureePretMillis = 21 * 24 * 60 * 60 * 1000; // 21 jours
                    break;
                case "Bon état":
                    dureePretMillis = 14 * 24 * 60 * 60 * 1000; // 14 jours
                    break;
                case "Usé":
                    dureePretMillis = 7 * 24 * 60 * 60 * 1000;   // 7 jours
                    break;
                default:
                    dureePretMillis = 14 * 24 * 60 * 60 * 1000; // Par défaut
                    break;
            }
        } else {
            dureePretMillis = 14 * 24 * 60 * 60 * 1000; // Par défaut si l'état est null
        }
        return new Date(dateEmprunt.getTime() + dureePretMillis);
    }

    @Override
    public void emprunter(Livre livre) {
        System.out.println("L'adhérent " + nom + " souhaite emprunter le livre : " + livre.getTitre());
        if (livre.getEtatLivre() instanceof Disponible) {
            Date dateEmprunt = new Date();
            Date dateRetourPrevu = calculerDateRetourPrevu(livre, dateEmprunt);
            Emprunt nouvelEmprunt = new Emprunt(this, livre, dateEmprunt, dateRetourPrevu);
            this.empruntsEnCours.add(nouvelEmprunt);
            livre.getEtatLivre().Emprunte(livre); // Déléguer le changement d'état
            System.out.println("Emprunté. Retour prévu le : " + nouvelEmprunt.getDateRetourPrevu());
        } else {
            System.out.println("Le livre '" + livre.getTitre() + "' n'est pas disponible pour l'emprunt. Etat : " + livre.getEtatLivre().getNom());
        }
    }

    @Override
    public void reserver(Livre livre) {
        System.out.println("L'adhérent " + nom + " souhaite réserver le livre : " + livre.getTitre());
        livre.getEtatLivre().Reservation(livre);
    }

    @Override
    public void rendre(Livre livre) {
        System.out.println("L'adhérent " + nom + " rend le livre : " + livre.getTitre());
        Emprunt empruntARetourner = null;
        for (Emprunt emprunt : this.empruntsEnCours) {
            if (emprunt.getLivre().equals(livre) && emprunt.getDateRetourReel() == null) {
                empruntARetourner = emprunt;
                break;
            }
        }
        if (empruntARetourner != null) {
            empruntARetourner.setDateRetourReel(new Date());
            livre.getEtatLivre().Disponible(livre);
            // Déléguer le changement d'état
            this.empruntsEnCours.remove(empruntARetourner);
            System.out.println("Retour effectué le : " + empruntARetourner.getDateRetourReel());
        } else {
            System.out.println("Cet emprunt n'a pas été trouvé pour ce livre.");
        }
    }
}