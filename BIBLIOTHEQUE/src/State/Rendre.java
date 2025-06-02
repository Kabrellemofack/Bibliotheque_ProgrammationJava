package State;

import Book.Livre;

public class Rendre implements Etat{

	@Override
	public void rendre(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("le livre est disponible !!!\n");
		
	}

	@Override
	public void reservation(Livre Livre) {
		// TODO Auto-generated method stub
		Livre.setEtatLivre(new Reservation());
		
	}

	@Override
	public void reparation(Livre Livre) {
		// TODO Auto-generated method stub
		Livre.setEtatLivre(new Reparation());
		
	}

	@Override
	public void emprunter(Livre Livre) {
		// TODO Auto-generated method stub
		Livre.setEtatLivre(new Emprunte());
	}

	

}
