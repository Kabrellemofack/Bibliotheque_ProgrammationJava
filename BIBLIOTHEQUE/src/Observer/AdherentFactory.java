package Observer;

	public class AdherentFactory {

	    public static Adherent creerAdherent(String adherentID, String nom,String prenom) {
	        return new Adherent(adherentID, nom, prenom);
	    }
	}