package Strategy;

import Book.Livre;
import EMPRUNT.Emprunt;

public class AmendLivreEndommage implements AmendStrategy{

	@Override
	public double CalculerAmende(Emprunt emprunt) {
		// TODO Auto-generated method stub
		Livre livre =  emprunt.getLivre();
		/**
		 * Bientôt disponible 
		 */
		return 0;
	}



}
