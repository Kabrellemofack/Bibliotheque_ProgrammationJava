package bibliotheque;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Book.Livre;
import ADHERENT.Adherent;
import EMPRUNT.Emprunt;
import Strategy.AmendStrategy;
import reservation.Reservation;
public class Bibliotheque {
	
	private String nom;
    private Map<String, Livre> livres;
    private Map<Integer, Adherent> adherents;
    private List<Emprunt> emprunts;
    private List<Reservation> reservations;
	public Bibliotheque(String nom, Map<String, Livre> livres, Map<Integer, Adherent> adherents, List<Emprunt> emprunts,
			List<Reservation> reservations) {
		super();
		this.nom = nom;
		this.livres = livres;
		this.adherents = adherents;
		this.emprunts = emprunts;
		this.reservations = reservations;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Map<String, Livre> getLivres() {
		return livres;
	}
	public void setLivres(Map<String, Livre> livres) {
		this.livres = livres;
	}
	public Map<Integer, Adherent> getAdherents() {
		return adherents;
	}
	public void setAdherents(Map<Integer, Adherent> adherents) {
		this.adherents = adherents;
	}
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
  public void AfficherTousLesLivres() {
	
}
}
