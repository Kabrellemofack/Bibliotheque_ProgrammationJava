package EMPRUNT;

import java.sql.Date;
import java.util.List;

import Observer.Adherent;

public class Emprunt {
	private List<Adherent>  adherent;
	private Date dateEmprunt;
	private Date dateRetourPrevue;
	private Date dateRetiurRelle;
	public Emprunt(Adherent adherent, Date dateEmprunt, Date dateRetourPrevue, Date dateRetiurRelle) {
		super();
		this.adherent = adherent;
		this.dateEmprunt = dateEmprunt;
		this.dateRetourPrevue = dateRetourPrevue;
		this.dateRetiurRelle = dateRetiurRelle;
	}
	public Adherent getAdherent() {
		return adherent;
	}
	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}
	public Date getDateEmprunt() {
		return dateEmprunt;
	}
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}
	public Date getDateRetourPrevue() {
		return dateRetourPrevue;
	}
	public void setDateRetourPrevue(Date dateRetourPrevue) {
		this.dateRetourPrevue = dateRetourPrevue;
	}
	public Date getDateRetiurRelle() {
		return dateRetiurRelle;
	}
	public void setDateRetiurRelle(Date dateRetiurRelle) {
		this.dateRetiurRelle = dateRetiurRelle;
	}


}
