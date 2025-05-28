package Observer;

import Book.Livre;

public interface Observer {
	void emprunter(Livre livre);
	void reserver(Livre livre);
	void rendre(Livre livre);
}
