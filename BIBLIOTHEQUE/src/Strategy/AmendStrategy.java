package Strategy;

import java.time.LocalDate;

import EMPRUNT.Emprunt;

public interface AmendStrategy {
	
	public  double CalculerAmende (Emprunt emprunt,LocalDate dateRetourEffective);

}
