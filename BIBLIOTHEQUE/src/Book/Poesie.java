package Book;
public class Poesie extends Livre {
    private String theme;

    public Poesie(String livreID, String nomAuteur, String isbn, String categorie, String theme) {
        super(livreID, nomAuteur, isbn, categorie);
        this.theme = theme;
    }

    public String getTheme() { return theme; }

    @Override
    public void afficherInfos() {
        System.out.println("Poésie - ID: " + getLivreID() + ", Auteur: " + getNomAuteur() + ", ISBN: " + getIsbn() + ", Catégorie: " + getCategorie() + ", Thème: " + theme);
    }
}
