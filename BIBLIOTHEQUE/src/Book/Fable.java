package Book;

public class Fable extends Livre {
    private String morale;

    public Fable(String livreID, String nomAuteur, String isbn, String categorie, String morale) {
        super(livreID, nomAuteur, isbn, categorie);
        this.morale = morale;
    }

    public String getMorale() { return morale; }

    @Override
    public void afficherInfos() {
        System.out.println("Fable - ID: " + getLivreID() + ", Auteur: " + getNomAuteur() + ", ISBN: " + getIsbn() + ", Catégorie: " + getCategorie() + ", Morale: " + morale);
    }
}