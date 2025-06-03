package Book;

import java.util.Date;

public class Poesie extends Livre {
    private String theme;

    public Poesie(String livreID, String titre, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout, String testament) {
        super(livreID, titre, nomAuteur, datePublication, maisonEdit, dateAjout);
        this.theme = theme;
    }

    public String getTestament() { return theme; }

    @Override
    public void afficherInfos() {
        // Appelle la méthode utilitaire de la classe parente pour imprimer les informations de la Bible
        printBaseInfo("Poesie", "Theme", theme);
    }
}