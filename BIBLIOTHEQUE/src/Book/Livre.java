package Book;

import java.util.Date;
import State.Etat;

public abstract class Livre {
	private String Title;
    private String LivreID;
    private String NomAuteur;
    private Date DatePublication;
    private String MaisonEdit;
    private Date DateAjout;
    private Etat EtatLivre; 

    public Livre(String livreID,  String Title,String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout, Etat etatLivre) {

        this.LivreID = livreID;
        this.NomAuteur = nomAuteur;
        this.DatePublication = datePublication;
        this.MaisonEdit = maisonEdit;
        this.DateAjout = dateAjout;
        this.EtatLivre = etatLivre;
        this.Title= Title;
    }


    public Etat getEtatLivre() {
        return EtatLivre;
    }

    public void setEtatLivre(Etat etatLivre) {
        EtatLivre = etatLivre;
    }

    public abstract void afficherInfos();
}