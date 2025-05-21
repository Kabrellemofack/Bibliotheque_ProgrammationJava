package State;

import Book.Livre;

public interface Etat{
	void reservation(Livre Livre);
	void reparation(Livre Livre);
	void emprunter(Livre Livre);
	void rendre(Livre Livre);
}
