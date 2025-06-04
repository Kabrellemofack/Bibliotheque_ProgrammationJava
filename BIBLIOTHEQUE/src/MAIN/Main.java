package MAIN;

import bibliotheque.Bibliotheque;
import Observer.Adherent;
import Book.Livre;
import State.Disponible;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static Bibliotheque biblio;
    private static String utilisateurConnecte = null; 
    private static boolean estAdminConnecte = false;

    private static final String LIVRES = "livres.txt";
    private static final String ADHERENTS = "adherents.txt";
    private static final String EMPRUNT= "emprunt.txt";
    private static final Map<String, String> UTILISATEURS_ENREGISTRES = new HashMap<>();
    static {
        UTILISATEURS_ENREGISTRES.put("admin", "admin");
        UTILISATEURS_ENREGISTRES.put("user", "user");
        UTILISATEURS_ENREGISTRES.put("utilisateur", "userpass");
    }

    public static void main(String[] args) {
        biblio = Bibliotheque.getInstance("Ma Bibliothèque");
        biblio.chargerLivresDepuisFichier(LIVRES);
        biblio.chargerAdherentsDepuisFichier(ADHERENTS);

        if (authentifierUtilisateur()) {
            afficherMenuPrincipal();
        } else {
            System.out.println("Trop de tentatives de connexion échouées. Fermeture.");
        }

        SCANNER.close();
    }

    private static boolean authentifierUtilisateur() {
        final int MAX_TENTATIVES = 3;
        for (int tentative = 1; tentative <= MAX_TENTATIVES; tentative++) {
            System.out.println("\n \t*** Veuillez vous Authentifier  ***");
            System.out.print("\n\t*** Nom d'utilisateur :  ");
            String nomOuIdentifiant = SCANNER.nextLine();
            System.out.print("\n\t*** Mot de passe ou  ID  : ");
            String motDePasseOuId = SCANNER.nextLine();

            // Vérification pour l'administrateur
            if (UTILISATEURS_ENREGISTRES.containsKey(nomOuIdentifiant) &&
                UTILISATEURS_ENREGISTRES.get(nomOuIdentifiant).equals(motDePasseOuId)) {
                System.out.println("\nBienvenu dans notre systeme  : " );
                utilisateurConnecte = nomOuIdentifiant;
                estAdminConnecte = true;
                return true;
            }

            // Vérification pour l'adhérent (par nom ET ID)
            for (Adherent adherent : biblio.getAdherents().values()) {
                if (adherent.getNom().equalsIgnoreCase(nomOuIdentifiant) && adherent.getAdherentID().equals(motDePasseOuId)) {
                    System.out.println("\nBienvenu dans notre systeme  : \n" + adherent.getNom() + " " + adherent.getPrenom() + " (ID: " + adherent.getAdherentID() + ")");
                    utilisateurConnecte = adherent.getAdherentID();
                    estAdminConnecte = false;
                    return true;
                }
            }

            System.out.println("\nNom ou ID incorrect.");
        }
        return false;
    }

    private static void afficherMenuPrincipal() {
        int choix;
        do {
            System.out.println("\n#*************************************************************#");
            System.out.println("#                       MENU DE LA BIBLIOTHÈQUE               #");
            System.out.println("#*************************************************************#");

            if (estAdminConnecte) {
                System.out.println("#              Admin  Connecte                                #");
                System.out.println("#-------------------------------------------------------------#");
                System.out.println("# 1. Afficher tous les livres                                 #");
                System.out.println("# 2. Ajouter un nouveau livre                                 #");
                System.out.println("# 3. Modifier un livre existant                               #");
                System.out.println("# 4. Supprimer un livre                                       #");
                System.out.println("# 5. Inscrire un adhérent                                     #");
                System.out.println("# 6. Afficher les adhérents                                   #");
                System.out.println("# 0. Quitter                                                  #");
            } else {
                System.out.println("#                Adherent connecte                            #");
                System.out.println("#-------------------------------------------------------------#");
                System.out.println("# 1. Consulter les livres                                     #");
                
                System.out.println("# 8. Emprunter un livre                                       #");
                System.out.println("# 9. Rendre un livre                                          #");
               System.out.println("# 10. Reserver un Livre                                        #");
                System.out.println("# 0. Quitter                                                  #");
            }

            System.out.println("#*************************************************************#");
            System.out.print("Veuillez entrer votre choix : ");

            try {
                choix = SCANNER.nextInt();
                SCANNER.nextLine(); // Consomme la nouvelle ligne

                switch (choix) {
                    case 1:
                        biblio.afficherLivres();
                        break;
                    case 2:
                        if (estAdminConnecte) biblio.ajouterLivreConsole();
                        else System.out.println("Action non autorisée pour un adhérent.");
                        break;
                    case 3:
                        if (estAdminConnecte) biblio.modifierLivreConsole();
                        else System.out.println("Action non autorisée pour un adhérent.");
                        break;
                    case 4:
                        if (estAdminConnecte) biblio.supprimerLivreConsole();
                        else System.out.println("Action non autorisée pour un adhérent.");
                        break;
                    case 5:
                        if (estAdminConnecte) biblio.inscrireAdherentConsole();
                        else System.out.println("Action non autorisée pour un adhérent.");
                        break;
                    case 6:
                        if (estAdminConnecte) biblio.afficherAdherents();
                        else emprunterLivreConsole(); 
                        break;
                    case 7: 
                        if (!estAdminConnecte) {
                            rendreLivreConsole();
                        } else {
                            System.out.println("Action non autorisée pour un administrateur.");
                        }
                        break;
                    case 8:
                    	if(!estAdminConnecte) {
                    		emprunterLivreConsole();
                    	}
                    	
                    	break;
                    case 9:
                    	if(!estAdminConnecte) {
                    		rendreLivreConsole();
                    	}
                    	
                    	break;
                    case 10:
                    	if(!estAdminConnecte) {
                    		rendreLivreConsole();
                    	}
                    	
                    	break;
                    	
                    case 0:
                        System.out.println("Merci d'avoir utilisé la bibliothèque. Au revoir!");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                SCANNER.nextLine(); 
                choix = -1; 
            }
        } while (choix != 0); 
        biblio.sauvegarderLivres(LIVRES);
        biblio.sauvegarderAdherents(ADHERENTS);
        //biblio.sauvegarderAdherents(ADHERENTS);
    }

    private static void emprunterLivreConsole() {
        System.out.println("\n*** Emprunter un livre ***");
        System.out.print (" \nEntrez l'ID du livre   : ");
        String livreID = SCANNER.nextLine();

        if (utilisateurConnecte != null && !estAdminConnecte) {
            Adherent adherentConnecte = biblio.getAdherents().get(utilisateurConnecte);
            Livre livreAEmprunter = biblio.getLivres().get(livreID);

            if (adherentConnecte != null) {
                if (livreAEmprunter != null) {
                    adherentConnecte.emprunter(livreAEmprunter);
                } else {
                    System.out.println("Livre avec l'ID '" + livreID + "' non trouvé.");
                }
            } else {
                System.out.println("Adhérent connecté non trouvé.");
            }
        }
    }
    private static void reserverLivreConsole() {
        System.out.println("\n*** Reservation d'un Livre  ***");
        System.out.print("\nEntrez l'ID du livre à rendre : ");
        String livreID = SCANNER.nextLine();

        if (utilisateurConnecte != null && !estAdminConnecte) {
            Adherent adherentConnecte = biblio.getAdherents().get(utilisateurConnecte);
            Livre livreAReserver = biblio.getLivres().get(livreID);

            if (adherentConnecte != null) {
                if (livreAReserver != null) {
                    adherentConnecte.reserver(livreAReserver);
                } else {
                    System.out.println("Livre avec l'ID '" + livreID + "' non trouvé.");
                }
            } else {
                System.out.println("Adhérent connecté non trouvé.");
            }
        } 
    }


    private static void rendreLivreConsole() {
        System.out.println("\n*** Rendre un livre  ***");
        System.out.print("\nEntrez l'ID du livre à rendre : ");
        String livreID = SCANNER.nextLine();

        if (utilisateurConnecte != null && !estAdminConnecte) {
            Adherent adherentConnecte = biblio.getAdherents().get(utilisateurConnecte);
            Livre livreARendre = biblio.getLivres().get(livreID);

            if (adherentConnecte != null) {
                if (livreARendre != null) {
                    adherentConnecte.rendre(livreARendre);
                } else {
                    System.out.println("Livre avec l'ID '" + livreID + "' non trouvé.");
                }
            } else {
                System.out.println("Adhérent connecté non trouvé.");
            }
        } 
    }

    private static void afficherMenuGestionLivresAdmin() {
        int choix;
        do {
            System.out.println("\n***  Gestion des Livres  ***");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Afficher tous les livres");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option : ");
            choix = SCANNER.nextInt();
            SCANNER.nextLine(); 
            switch (choix) {
                case 1:
                    System.out.println("Fonctionnalité d'ajout de livre.");
                    break;
                case 2:
                    System.out.println("Fonctionnalité de suppression de livre.");
                    break;
                case 3:
                    System.out.println("Fonctionnalité de recherche de livre.");
                    break;
                case 4:
                    biblio.afficherLivres();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } while (choix != 5);
    }

   /* private static void afficherMenuGestionAdherentsAdmin() {
        int choix;
        do {
            System.out.println("\n*** Gestion des Adhérents ***");
            System.out.println("1. Inscrire un adhérent");
            System.out.println("2. Mettre à jour un adhérent");
            System.out.println("3. Supprimer un adhérent");
            System.out.println("4. Afficher tous les adhérents");
            System.out.println("9. Retour au menu principal");
            System.out.print("Choisissez une option : ");
            choix = SCANNER.nextInt();
            SCANNER.nextLine(); 
            switch (choix) {
                case 1:
                    System.out.println("Fonctionnalité d'inscription d'un adhérent.");
                    break;
                case 2:
                    System.out.println("Fonctionnalité de mise à jour d'un adhérent.");
                    break;
                case 3:
                    System.out.println("Fonctionnalité de suppression d'un adhérent.");
                    break;
                case 4:
                    biblio.afficherAdherents();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        } while (choix != 9);
    }*/
}