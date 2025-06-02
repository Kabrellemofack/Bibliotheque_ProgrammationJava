package State;

import Book.Livre;

public class Reservation implements Etat{
	
	@Override
	public void reservation(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Le livre est déjà reservé !!!\n");
		
	}

	@Override
	public void reparation(Livre Livre) {
		// TODO Auto-generated method stub
		Livre.setEtatLivre(new Reparation());
	}

	@Override
	public void emprunter(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, le livre ne peut plus être emprunté !!!\n");
	}

	@Override
	public void rendre(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, Le livre n'est pas disponible  !!!\n");
	}

}
