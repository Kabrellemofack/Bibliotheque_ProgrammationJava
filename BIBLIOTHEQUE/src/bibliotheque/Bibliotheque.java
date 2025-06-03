package bibliotheque;

import Book.Livre;
import Book.Roman;
import Observer.Adherent;
import Observer.AdherentFactory;
import Book.Poesie;
import Book.Bible;
import Book.Fable;
import Book.LivreFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bibliotheque {
    private Map<String, Adherent> adherents = new HashMap<>(); // Collection pour gérer les adhérents
    private static Bibliotheque instance = null;
    private String nom;
    private Map<String, Livre> livres;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
    private static final Scanner scanner = new Scanner(System.in);
    EncadreMot a = new EncadreMot();
    private Bibliotheque(String nom) {
        this.nom = nom;
        this.livres = new HashMap<>();
    }

    public static Bibliotheque getInstance(String nom) {
        if (instance == null) {
            instance = new Bibliotheque(nom);
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<String, Livre> getLivres() {
        return livres;
    }

    public void setLivres(Map<String, Livre> livres) {
        this.livres = livres;
    }

    public Map<String, Adherent> getAdherents() {
        return adherents;
    }

    public void ajouterLivre(Livre livre) {
        if (livre != null) {
            livres.put(livre.getLivreID(), livre);
        }
    }

    public void ajouterAdherent(Adherent adherent) {
        if (adherent != null && !adherents.containsKey(adherent.getAdherentID())) {
            adherents.put(adherent.getAdherentID(), adherent);
            // Suppression de l'affichage direct lors de l'ajout depuis le fichier
            // System.out.println("Adhérent " + adherent.getNom() + " " + adherent.getPrenom() + " (ID: " + adherent.getAdherentID() + ") ajouté.");
        } else if (adherent != null) {
            System.out.println("Un adhérent avec l'ID " + adherent.getAdherentID() + " existe déjà.");
        }
    }

    public void supprimerLivre(String livreID) {
        if (livres.containsKey(livreID)) {
            livres.remove(livreID);
            System.out.println("Livre supprimé avec succès : " + livreID);
        } else {
            System.out.println("Livre non trouvé pour l'ID : " + livreID);
        }
    }

    public void modifierLivre(String livreID, Livre nouveauLivre) {
        if (livres.containsKey(livreID)) {
            if (nouveauLivre != null && nouveauLivre.getLivreID().equals(livreID)) {
                livres.put(livreID, nouveauLivre);
                System.out.println("Livre modifié avec succès : " + livreID);
            } else {
                System.out.println("Erreur: Le nouvel objet Livre n'est pas valide ou son ID ne correspond pas à l'ID à modifier.");
            }
        } else {
            System.out.println("Livre non trouvé pour la modification : " + livreID);
        }
    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            System.out.println("\n*** Liste des livres de " + nom + " ***");
            for (Livre livre : livres.values()) {
                livre.afficherInfos();
            }
        }
    }

    public void afficherAdherents() {
        if (adherents.isEmpty()) {
            System.out.println("Aucun adhérent inscrit.");
        } else {
            a.encadrer("Liste des adhérents de  "+nom);
            System.out.println(String.format("%-10s | %-20s | %-20s", "ID", "Nom", "Prénom"));
            System.out.println("-----------|----------------------|--------------");

            for (Adherent adherent : adherents.values()) {
                System.out.println(String.format("%-10s | %-20s | %-20s",
                                                 adherent.getAdherentID(),
                                                 adherent.getNom(),
                                                 adherent.getPrenom()));
            }
        }
    }
    public void sauvegarderAdherents(String nomFichier) {
        try (FileWriter fw = new FileWriter(nomFichier)) {
            for (Adherent adherent : adherents.values()) {
                String line = String.join(";",
                                         adherent.getAdherentID(),
                                         adherent.getNom(),
                                         adherent.getPrenom()
                );
                fw.write(line + "\n");
            }

        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des adhérents : " + e.getMessage());
        }
    }


    public void chargerAdherentsDepuisFichier(String nomFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 3) {
                    String id = parts[0];
                    String nom = parts[1];
                    String prenom = parts[2];
                    Adherent adherent = AdherentFactory.creerAdherent(id, nom, prenom);
                    ajouterAdherent(adherent);
                } else {
                    System.err.println("Ligne adhérent ignorée (format incorrect) : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des adhérents : " + e.getMessage());
        }
    }

    public void inscrireAdherentConsole() {
        System.out.println("\n*** Inscription d'un adherent ***");
        System.out.print("Entrez l'ID de l'adhérent : ");
        String idAdherent = scanner.nextLine();
        System.out.print("Entrez le nom de l'adhérent : ");
        String nomAdherent = scanner.nextLine();
        System.out.print("Entrez le prénom de l'adhérent : ");
        String prenomAdherent = scanner.nextLine();
        Adherent nouvelAdherent = AdherentFactory.creerAdherent(idAdherent, nomAdherent, prenomAdherent);
        ajouterAdherent(nouvelAdherent);
        nouvelAdherent.afficherInfos();

    }

    public void sauvegarderLivres(String nomFichier) {
        try (FileWriter fw = new FileWriter(nomFichier)) {
            for (Map.Entry<String, Livre> entry : livres.entrySet()) {
                Livre livre = entry.getValue();
                String typePrefix = "";
                String specificite = "";
                if (livre instanceof Roman) {
                    typePrefix = "R";
                } else if (livre instanceof Poesie) {
                    typePrefix = "P";
                    specificite = ((Poesie) livre).getTitre();
                } else if (livre instanceof Bible) {
                    typePrefix = "B";
                    specificite = ((Bible) livre).getTestament();
                } else if (livre instanceof Fable) {
                    typePrefix = "F";
                    specificite = ((Fable) livre).getMorale();
                }

                String line = String.join(";",
                                         typePrefix + livre.getLivreID().substring(1),
                                         livre.getTitre(),
                                         livre.getNomAuteur(),
                                         SDF.format(livre.getDatePublication()),
                                         livre.getMaisonEdit(),
                                         SDF.format(livre.getDateAjout()),
                                         specificite
                );
                fw.write(line + "\n");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des livres : " + e.getMessage());
        }
    }

    public void ajouterLivreConsole() {
        System.out.println("\n***  Ajouter un nouveau livre  ***");
        try {
            System.out.print("Entrez l'ID du livre");
            String livreID = scanner.nextLine();

            System.out.print("Entrez le titre : ");
            String titre = scanner.nextLine();

            System.out.print("Entrez l'auteur : ");
            String auteur = scanner.nextLine();

            System.out.print("Entrez la date de publication (AAAA-MM-JJ) : ");
            Date datePublication = SDF.parse(scanner.nextLine());

            System.out.print("Entrez la maison d'édition : ");
            String maisonEdit = scanner.nextLine();

            System.out.print("Entrez la date d'ajout (AAAA-MM-JJ) : ");
            Date dateAjout = SDF.parse(scanner.nextLine());

            System.out.print("Entrez la spécificité (Genre/Thème/Testament/Morale) : ");
            String spec = scanner.nextLine();

            String typeStr = getTypeFromLivreID(livreID);
            Livre nouveauLivre = LivreFactory.creerLivre(typeStr, livreID, titre, auteur, datePublication, maisonEdit, dateAjout, spec);

            if (nouveauLivre != null) {
                ajouterLivre(nouveauLivre);
            } else {
                System.out.println(" Échec de l'ajout du livre. Type d'ID non reconnu.");
            }
        } catch (ParseException e) {
            System.out.println("\nErreur de format de date. Veuillez utiliser AAAA-MM-JJ.");
        } catch (Exception e) {
            System.out.println("\nUne erreur est survenue lors de l'ajout du livre : " + e.getMessage());
        }
    }

    public void modifierLivreConsole() {
        System.out.println("\n--- Modifier un livre existant ---");
        System.out.print("Entrez l'ID du livre à modifier : ");
        String idLivreAModifier = scanner.nextLine();

        if (livres.containsKey(idLivreAModifier)) {
            System.out.println("Livre trouvé. Veuillez entrer les nouvelles informations.");
            try {
                String typeStr = getTypeFromLivreID(idLivreAModifier);

                System.out.print("Entrez le nouveau titre : ");
                String titre = scanner.nextLine();

                System.out.print("Entrez le nouvel auteur : ");
                String auteur = scanner.nextLine();

                System.out.print("Entrez la nouvelle date de publication (AAAA-MM-JJ) : ");
                Date datePublication = SDF.parse(scanner.nextLine());

                System.out.print("Entrez la nouvelle maison d'édition : ");
                String maisonEdit = scanner.nextLine();

                System.out.print("Entrez la nouvelle date d'ajout (AAAA-MM-JJ) : ");
                Date dateAjout = SDF.parse(scanner.nextLine());

                System.out.print("Entrez la nouvelle spécificité (Genre/Thème/Testament/Morale) : ");
                String spec = scanner.nextLine();

                Livre livreModifie = LivreFactory.creerLivre(typeStr, idLivreAModifier, titre, auteur, datePublication, maisonEdit, dateAjout, spec);

                if (livreModifie != null) {
                    modifierLivre(idLivreAModifier, livreModifie);
                } else {
                    System.out.println("Échec de la modification. Type d'ID original non reconnu.");
                }

            } catch (ParseException e) {
                System.out.println("\nErreur de format de date. Veuillez utiliser AAAA-MM-JJ.");
            } catch (Exception e) {
                System.out.println("\nUne erreur est survenue lors de la modification du livre : " + e.getMessage());
            }
        } else {
            System.out.println("Le livre avec l'ID " + idLivreAModifier + " n'existe pas.");
        }
    }

    public void supprimerLivreConsole() {
        System.out.println("\n--- Supprimer un livre ---");
        System.out.print("Entrez l'ID du livre à supprimer : ");
        String idLivreASupprimer = scanner.nextLine();
        supprimerLivre(idLivreASupprimer);
    }

    public String getTypeFromLivreID(String livreID) {
        if (livreID == null || livreID.isEmpty()) {
            return "";
        }
        char prefix = livreID.charAt(0);
        switch (prefix) {
            case 'R':
                return "Roman";
            case 'P':
                return "Poesie";
            case 'B':
                return "Bible";
            case 'F':
                return "Fable";
            default:
                return "";
        }
    }

    public void chargerLivresDepuisFichier(String nomFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String line;
            // Suppression de l'affichage direct du succès du chargement des livres
            // System.out.println("Livres chargés depuis " + nomFichier + " avec succès.");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 7) {
                    String typePrefix = parts[0].substring(0, 1);
                    String livreIDWithoutPrefix = parts[0].substring(1);
                    String livreID = typePrefix + livreIDWithoutPrefix;
                    String titre = parts[1];
                    String auteur = parts[2];
                    Date datePublication = SDF.parse(parts[3]);
                    String maisonEdit = parts[4];
                    Date dateAjout = SDF.parse(parts[5]);
                    String spec = parts[6];

                    String typeStr = "";
                    switch (typePrefix) {
                        case "R":
                            typeStr = "Roman";
                            break;
                        case "P":
                            typeStr = "Poesie";
                            break;
                        case "B":
                            typeStr = "Bible";
                            break;
                        case "F":
                            typeStr = "Fable";
                            break;
                        default:
                            System.err.println("Type de livre inconnu pour l'ID : " + livreID);
                            continue;
                    }

                    Livre livre = LivreFactory.creerLivre(typeStr, livreID, titre, auteur, datePublication, maisonEdit, dateAjout, spec);
                    if (livre != null) {
                        ajouterLivre(livre);
                    }
                } else {
                    System.err.println("Ligne ignorée (nombre incorrect de parties attendues au moins 7) : " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (ParseException e) {
            System.err.println("Erreur lors de la conversion de la date : " + e.getMessage());
        }
    }
}