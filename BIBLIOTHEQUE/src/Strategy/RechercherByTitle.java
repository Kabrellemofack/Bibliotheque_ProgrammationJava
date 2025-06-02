package Strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RechercherByTitle implements RechercheStrategy{

	@Override
	public void rechercher(String file, String recherche) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		    String ligne;
		    
		    while((ligne = reader.readLine()) != null) {
		    	if (ligne.contains(recherche)) {
		    		System.out.println(ligne);
		    	}
		    }
			
		} catch (IOException e) {
		    System.out.println("Erreur de lecture du fichier");
		}
	}

}
