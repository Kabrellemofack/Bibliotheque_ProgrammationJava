package Book;

import State.Etat;
import State.Disponible;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Livre {
    private String livreID;
    private String titre;
    private String nomAuteur;
    private Date datePublication;
    private String maisonEdit;
    private Date dateAjout;
    private Etat etatLivre;

    public Livre(String livreID, String titre, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout) {
        this.livreID = livreID;
        this.titre = titre;
        this.nomAuteur = nomAuteur;
        this.datePublication = datePublication;
        this.maisonEdit = maisonEdit;
        this.dateAjout = dateAjout;
        this.etatLivre = new Disponible();
    }

    // Getters
    public String getLivreID() { return livreID; }
    public String getTitre() { return titre; }
    public String getNomAuteur() { return nomAuteur; }
    public Date getDatePublication() { return datePublication; }
    public String getMaisonEdit() { return maisonEdit; }
    public Date getDateAjout() { return dateAjout; }
    public Etat getEtatLivre() { return etatLivre; }

    // Setter pour l'état
    public void setEtatLivre(Etat etatLivre) { this.etatLivre = etatLivre; }

    // Méthodes State (à adapter selon vos besoins)
    public void emprunter() { etatLivre.Emprunte(this); }
    public void reserver() { etatLivre.Reservation(this); }
    public void reparer() { etatLivre.Reparation(this); }
    public void rendre() { etatLivre.Disponible(this); }

    /**
     * Affiche les informations du livre dans la console avec un format esthétique.
     * Cette méthode est abstraite et doit être implémentée par les sous-classes.
     */
    public abstract void afficherInfos();

    // Méthode utilitaire pour créer une chaîne de base formatée pour l'affichage console
    protected void printBaseInfo(String type, String specificiteLabel, String specificiteValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║ Type       : " + String.format("%-45s", type) + "║");
        System.out.println("║ ID         : " + String.format("%-45s", getLivreID()) + "║");
        System.out.println("║ Titre      : " + String.format("%-45s", getTitre()) + "║");
        System.out.println("║ Auteur     : " + String.format("%-45s", getNomAuteur()) + "║");
        System.out.println("║ Publication: " + String.format("%-45s", sdf.format(getDatePublication())) + "║");
        System.out.println("║ Éditeur    : " + String.format("%-45s", getMaisonEdit()) + "║");
        System.out.println("║ Ajout      : " + String.format("%-45s", sdf.format(getDateAjout())) + "║");
        System.out.println("║ " + String.format("%-10s", specificiteLabel) + ": " + String.format("%-45s", specificiteValue) + "║");
        System.out.println("║ État       : " + String.format("%-45s", getEtatLivre().getNom()) + "║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
    }
}