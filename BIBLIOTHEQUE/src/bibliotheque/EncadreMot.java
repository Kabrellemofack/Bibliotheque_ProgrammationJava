package bibliotheque;
public class EncadreMot {

    public static void encadrer(String mot) {

        int longueurMot = mot.length()+1;
        int bordureLongueur = longueurMot + 4; 

      
        for (int i = 0; i < bordureLongueur; i++) {
            System.out.print("-");
        }
        System.out.println();

       
        System.out.println("| " + mot + " |");
        for (int i = 0; i < bordureLongueur; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}