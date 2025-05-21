package Book;

import java.util.Date;

import State.Etat;

public class Poesie extends Livre {
	private String Style;

	public Poesie(String livreID, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout,
			Etat etatLivre,String Style) {
		super(livreID, nomAuteur, datePublication, maisonEdit, dateAjout, etatLivre);
		// TODO Auto-generated constructor stub
	}

}
