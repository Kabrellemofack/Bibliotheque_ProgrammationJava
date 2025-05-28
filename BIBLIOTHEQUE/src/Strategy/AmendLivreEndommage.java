package Strategy;

import java.time.LocalDate;

import EMPRUNT.Emprunt;

public class AmendLivreEndommage implements AmendStrategy{

	@Override
	public double CalculerAmende(Emprunt emprunt, LocalDate dateRetourEffective) {
		return 0;
	}

}
