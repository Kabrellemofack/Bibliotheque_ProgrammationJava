package Strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RechercherAuteur implements RechercheStrategy {
	
	@Override
	public void rechercher(String file, String recherche) {
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
