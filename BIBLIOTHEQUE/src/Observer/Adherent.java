package Observer;

import Book.Livre;
import State.Etat;

public class Adherent implements Observer{
	
	private String AdherentID;
	private String Nomadh;
	
	public Adherent(String adherentID, String nomadh) {
		super();
		AdherentID = adherentID;
		Nomadh = nomadh;
	}
	
	public String getAdherentID() {
		return AdherentID;
	}
	
	public void setAdherentID(String adherentID) {
		AdherentID = adherentID;
	}
	
	public String getNomadh() {
		return Nomadh;
	}
	
	public void setNomadh(String nomadh) {
		Nomadh = nomadh;
	}

		
	@Override
	public void emprunter(Livre livre) {
		// TODO Auto-generated method stub
		livre.getEtatLivre().emprunter(livre);
	}

	@Override
	public void reserver(Livre livre) {
		// TODO Auto-generated method stub
		livre.getEtatLivre().reservation(livre);;
	}

	@Override
	public void rendre(Livre livre) {
		// TODO Auto-generated method stub
		livre.getEtatLivre().rendre(livre);
	}

}
