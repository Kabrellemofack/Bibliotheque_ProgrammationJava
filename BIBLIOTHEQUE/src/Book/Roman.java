package Book;

import java.util.Date;

public class Roman extends Livre {
    private String genre;

    public Roman(String livreID, String titre, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout, String genre) {
        super(livreID, titre, nomAuteur, datePublication, maisonEdit, dateAjout);
        this.genre = genre;
    }

    public String getGenre() { return genre; }

    @Override
    public void afficherInfos() {
        // Appelle la méthode utilitaire de la classe parente pour imprimer les informations du roman
        printBaseInfo("Roman", "Genre", genre);
    }
}