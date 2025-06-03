package Book;

import java.util.Date;

public class Fable extends Livre {
    private String morale;

    public Fable(String livreID, String titre, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout, String morale) {
        super(livreID, titre, nomAuteur, datePublication, maisonEdit, dateAjout);
        this.morale = morale;
    }

    public String getMorale() { return morale; }

    @Override
    public void afficherInfos() {
        // Appelle la méthode utilitaire de la classe parente pour imprimer les informations de la fable
        printBaseInfo("Fable", "Morale", morale);
    }
}
