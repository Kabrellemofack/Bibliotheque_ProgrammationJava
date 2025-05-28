package Book;

public class Bible extends Livre {
	
    private String testament;
    public Bible(String livreID, String nomAuteur, String isbn, String categorie, String testament) {
        super(livreID, nomAuteur, isbn, categorie);
        this.testament = testament;
    }

    public String getTestament() { return testament; }

    @Override
    public void afficherInfos() {
        System.out.println("Bible - ID: " + getLivreID() + ", Auteur: " + getNomAuteur() + ", ISBN: " + getIsbn() + ", Catégorie: " + getCategorie() + ", Testament: " + testament);
    }
}

