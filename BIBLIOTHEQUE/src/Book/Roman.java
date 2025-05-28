

package Book;

public class Roman extends Livre {
    private String genre;

    public Roman(String livreID, String nomAuteur, String isbn, String categorie, String genre) {
        super(livreID, nomAuteur, isbn, categorie);
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    @Override
    public void afficherInfos() {
        System.out.println("Roman - ID: " + getLivreID() + ", Auteur: " + getNomAuteur() + ", ISBN: " + getIsbn() + ", Catégorie: " + getCategorie() + ", Genre: " + genre);
    }
}
