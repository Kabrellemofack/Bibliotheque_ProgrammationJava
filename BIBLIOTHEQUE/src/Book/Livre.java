package Book;

public abstract class Livre {
    private String livreID; // Vous aviez LivreID dans votre version
    private String nomAuteur;
    private String isbn; // Ajout de l'ISBN, utile pour identifier les livres
    private String categorie; // Ajout de la catégorie

    public Livre(String livreID, String nomAuteur, String isbn, String categorie) {
        this.livreID = livreID;
        this.nomAuteur = nomAuteur;
        this.isbn = isbn;
        this.categorie = categorie;
    }

    public String getLivreID() { return livreID; }
    public String getNomAuteur() { return nomAuteur; }
    public String getIsbn() { return isbn; }
    public String getCategorie() { return categorie; }

    public abstract void afficherInfos();
}