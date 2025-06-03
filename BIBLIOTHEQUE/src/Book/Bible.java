package Book;

import java.util.Date;

public class Bible extends Livre {
    private String testament;

    public Bible(String livreID, String titre, String nomAuteur, Date datePublication, String maisonEdit, Date dateAjout, String testament) {
        super(livreID, titre, nomAuteur, datePublication, maisonEdit, dateAjout);
        this.testament = testament;
    }

    public String getTestament() { return testament; }

    @Override
    public void afficherInfos() {
       
        printBaseInfo("Bible", "Testament", testament);
    }
}