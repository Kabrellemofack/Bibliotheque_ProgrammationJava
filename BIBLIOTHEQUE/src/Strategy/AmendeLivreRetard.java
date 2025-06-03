package Strategy;

import EMPRUNT.Emprunt;

public class AmendeLivreRetard implements AmendStrategy {

	@Override
	public double CalculerAmende(Emprunt emprunt) {
		// TODO Auto-generated method stub
		int amende = 150;
		if (emprunt.getDateRetourReel().after(emprunt.getDateRetourPrevu())) {
			System.out.println("Vous avez un retard donc vous devez payer une amende de" + amende + "€\n");
			return amende;
		} else {
			System.out.println("Vous êtes dans les temps\n");
			return 0;
		}
		
	}


}
