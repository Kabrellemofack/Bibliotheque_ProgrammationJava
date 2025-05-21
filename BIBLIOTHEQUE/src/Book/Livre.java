package Book;

import java.util.Date;

import State.Etat;

public abstract class Livre  implements Etat {
	
	private String LivreID;
	private String NomAuteur;
	private Date DatePublication;
	public String MaisonEdit;
	private Date DateAjout;
	private Etat EtatLivre;
	
	public Livre(String livreID, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout,Etat etatLivre) {
		
		this.LivreID = livreID;
		this.NomAuteur = nomAuteur;
		this.DatePublication = datePublication;
		this.MaisonEdit = maisonEdit;
		this.DateAjout = dateAjout;
		this.EtatLivre = etatLivre;
	}

	
	public String getLivreID() {
		return LivreID;
	}


	public void setLivreID(String livreID) {
		LivreID = livreID;
	}


	public String getNomAuteur() {
		return NomAuteur;
	}


	public void setNomAuteur(String nomAuteur) {
		NomAuteur = nomAuteur;
	}


	public Date getDatePublication() {
		return DatePublication;
	}


	public void setDatePublication(Date datePublication) {
		DatePublication = datePublication;
	}


	public String getMaisonEdit() {
		return MaisonEdit;
	}


	public void setMaisonEdit(String maisonEdit) {
		MaisonEdit = maisonEdit;
	}


	public Date getDateAjout() {
		return DateAjout;
	}


	public void setDateAjout(Date dateAjout) {
		DateAjout = dateAjout;
	}


	public Etat getEtatLivre() {
		return EtatLivre;
	}


	public void setEtatLivre(Etat etatLivre) {
		EtatLivre = etatLivre;
	}


	public void afficherInfos() {};
}
