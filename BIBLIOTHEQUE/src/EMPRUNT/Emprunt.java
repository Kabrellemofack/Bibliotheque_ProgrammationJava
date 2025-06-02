package EMPRUNT;

import java.sql.Date;
import java.util.List;

import Observer.Adherent;
import State.Etat;
import Book.Livre;

public class Emprunt {
	private Adherent  adherent;
	private Livre Livre;
	private Date dateRetourPrevue;
	private Date dateRetourReelle;
	
	public Emprunt(Adherent adherent, Date dateRetourPrevue, Date dateRetiurRelle) {
		super();
		this.adherent = adherent;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetourReelle = dateRetiurRelle;
	}
	
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	
	
	public Livre getLivre() {
		return Livre;
	}

	public void setLivre(Livre livre) {
		Livre = livre;
	}

	public void setDateRetourReelle(Date dateRetourReelle) {
		this.dateRetourReelle = dateRetourReelle;
	}

	public Date getDateRetourPrevue() {
		return dateRetourPrevue;
	}
	public void setDateRetourPrevue(Date dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}
	
	public Date getDateRetourReelle() {
		return dateRetourReelle;
	}
	public void setDateRetourRelle(Date dateRetiurRelle) {
		this.dateRetourReelle = dateRetiurRelle;
	}


}
