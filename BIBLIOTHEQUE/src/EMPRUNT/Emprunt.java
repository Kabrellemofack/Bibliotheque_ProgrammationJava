package EMPRUNT;

import Observer.Adherent;
import Book.Livre;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emprunt {
    private Adherent adherent;
    private Livre livre;
    private Date dateEmprunt;
    private Date dateRetourPrevu;
    private Date dateRetourReel;

    public Emprunt(Adherent adherent, Livre livre, Date dateEmprunt, Date dateRetourPrevu) {
        this.adherent = adherent;
        this.livre = livre;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevu = dateRetourPrevu;
        this.dateRetourReel = null;
    }

  
    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public void setDateRetourPrevu(Date dateRetourPrevu) {
        this.dateRetourPrevu = dateRetourPrevu;
    }

    public Date getDateRetourReel() {
        return dateRetourReel;
    }

    public void setDateRetourReel(Date dateRetourReel) {
        this.dateRetourReel = dateRetourReel;
    }

    @Override
    public String toString() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        String retourReel = (dateRetourReel != null) ? date.format(dateRetourReel) : "Non retourné";
        return "Emprunt [Adhérent: " + adherent.getNom() + " " + adherent.getPrenom() +
                ", Livre: " + livre.getTitre() + " (ID: " + livre.getLivreID() + ")" +
                ", Emprunté le: " + date.format(dateEmprunt) +
                ", Retour prévu: " + date.format(dateRetourPrevu) +
                ", Retour réel: " + retourReel + "]";
    }
    
    
}
