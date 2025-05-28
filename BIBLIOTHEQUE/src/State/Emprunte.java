package State;

import Book.Livre;

public class Emprunte implements Etat{

	@Override
	public void emprunter(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Le livre a ete emprunte !!!");
	}

	@Override
	public void reservation(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, le livre ne peut être reservé !!!");
	}

	@Override
	public void reparation(Livre Livre) {
		// TODO Auto-generated method stub
		System.out.println("Impossible, le livre ne peut être reparé !!!");
	}

	
	


}
