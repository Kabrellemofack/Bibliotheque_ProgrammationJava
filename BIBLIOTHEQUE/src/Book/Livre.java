package Book;

import java.util.Date;

import State.Etat;

public abstract class Livre {
	
	private String LivreID;
	private String NomAuteur;
	private Date DatePublication;
	public String MaisonEdit;
	private Date DateAjout;
	private Etat EtatLivre;
	
	public void afficherInfos() {};
}
