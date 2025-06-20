package reservation;

import Observer.Adherent;
import Book.Livre;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
	
    private Adherent adherent;
    private Livre livre;
    private Date dateReservation;
    private boolean active;

    public Reservation(Adherent adherent, Livre livre, Date dateReservation) {
        this.adherent = adherent;
        this.livre = livre;
        this.dateReservation = dateReservation;
        this.active = true; 
    }

  
    public Adherent getAdherent() {
    	
    	return adherent; 
    	}
    public Livre getLivre() { 
    	return livre;
    	}
    public Date getDateReservation() { 
    	return dateReservation; 
    	}
    public boolean isActive() { 
    	return active; 
    	}


    public void setActive(boolean active) { 
    	
    	this.active = active; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Réservation [Adhérent: " + adherent.getNomAdh() + " " + adherent.getPrenom() +
               ", Livre: " + livre.getTitre() + " (ID: " + livre.getLivreID() + ")" +
               ", Réservé le: " + sdf.format(dateReservation) +
               ", Active: " + (active ? "Oui" : "Non") + "]";
    }
}
