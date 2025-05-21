package Book;

import java.util.Date;

import State.Etat;

public class  Bible extends Livre{
	private String Religion;

	public Bible(String livreID, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout,
			Etat etatLivre,String Religion) {
		super(livreID, nomAuteur, datePublication, maisonEdit, dateAjout, etatLivre);
		// TODO Auto-generated constructor stub
	}	
	
}
