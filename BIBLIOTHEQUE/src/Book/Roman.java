package Book;

import java.util.Date;

import State.Etat;

public class Roman extends Livre {
	
	private String Genre ;
	
	public Roman(String livreID, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout,
			Etat etatLivre,String Genre) {
		super(livreID, nomAuteur, datePublication, maisonEdit, dateAjout, etatLivre);
		// TODO Auto-generated constructor stub
		this.Genre= Genre;
	}

}
