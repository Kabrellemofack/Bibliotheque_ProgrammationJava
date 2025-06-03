package Book;

import java.sql.Date;

public class LivreFactory {

    public static Livre creerLivre(String type, String livreID, String titre, String auteur,
                                    java.util.Date datePublication, String maisonEdit, java.util.Date dateAjout, String specificite) {
        switch (type.toLowerCase()) {
            case "roman":
                return new Roman(livreID, titre, auteur, datePublication, maisonEdit, dateAjout, specificite);
            case "poesie":
                return new Poesie(livreID, titre, auteur, datePublication, maisonEdit, dateAjout, specificite);
            case "bible":
                return new Bible(livreID, titre, auteur, datePublication, maisonEdit, dateAjout, specificite);
            case "fable":
                return new Fable(livreID, titre, auteur, datePublication, maisonEdit, dateAjout, specificite);
            default:
                System.err.println("Type de livre inconnu : " + type);
                return null;
        }
    }

    // Méthode pour déterminer le type de livre à partir de l'ID (si nécessaire)
    public static String getTypeFromId(String livreID) {
        if (livreID != null && !livreID.isEmpty()) {
            char prefix = livreID.charAt(0);
            switch (prefix) {
                case 'R': return "roman";
                case 'P': return "poesie";
                case 'B': return "bible";
                case 'F': return "fable";
                default: return null;
            }
        }
        return null;
    }
}
