package State;

import Book.Livre;

public class Reparation implements Etat{

	@Override
	public void reservation(Livre Livre) {
		// TODO Auto-generated method stub
		Livre.setEtatLivre(new Reservation());
		
	}

	@Override
	public void reparation(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Le livre est en reparation !!!\n");
	}

	@Override
	public void emprunter(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, le livre ne peut pas être emprunté !!!\n");
	}

	@Override
	public void rendre (Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, Le livre n'est pas disponible  !!!\n");
	}


}
