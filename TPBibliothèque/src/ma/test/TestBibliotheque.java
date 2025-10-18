package ma.test;

import entities.*;

import java.util.Scanner;

public class TestBibliotheque {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Entrez la capacité de la bibliothèque (n) : ");
		int n;
		try {
			n = Integer.parseInt(sc.nextLine().trim());
		} catch (NumberFormatException e) {
			System.out.println("Entrée invalide. Utilisation de la capacité par défaut 10.");
			n = 10;
		}

		Bibliotheque biblio = new Bibliotheque(n);

		// Initialisation avec deux documents au choix
		Livre l1 = new Livre("Les Fleurs du mal", "Charles Baudelaire", 200);
		Revue r1 = new Revue("Science Mensuelle", "Mars", 2022);

		biblio.ajouter(l1);
		biblio.ajouter(r1);

		boolean quitter = false;
		while (!quitter) {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Afficher tous les documents");
			System.out.println("2. Ajouter un document");
			System.out.println("3. Supprimer un document (par numéro d'enreg.)");
			System.out.println("4. Rechercher un document (par numéro d'enreg.)");
			System.out.println("5. Afficher auteurs");
			System.out.println("6. Quitter");
			System.out.print("Choix : ");

			String choix = sc.nextLine().trim();
			switch (choix) {
			case "1":
				biblio.afficherDocuments();
				break;

			case "2":
				ajouterDocumentInteractive(sc, biblio);
				break;

			case "3":
				System.out.print("Entrez le numéro d'enregistrement du document à supprimer : ");
				try {
					int numSup = Integer.parseInt(sc.nextLine().trim());
					Document dSup = biblio.document(numSup);
					if (dSup == null) {
						System.out.println("Document introuvable.");
					} else {
						boolean ok = biblio.supprimer(dSup);
						System.out.println(ok ? "Document supprimé." : "Échec de la suppression.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Numéro invalide.");
				}
				break;

			case "4":
				System.out.print("Entrez le numéro d'enregistrement à rechercher : ");
				try {
					int num = Integer.parseInt(sc.nextLine().trim());
					Document d = biblio.document(num);
					if (d == null)
						System.out.println("Document introuvable.");
					else
						System.out.println(d);
				} catch (NumberFormatException e) {
					System.out.println("Numéro invalide.");
				}
				break;

			case "5":
				biblio.afficherAuteurs();
				break;

			case "6":
				quitter = true;
				System.out.println("Au revoir !");
				break;

			default:
				System.out.println("Choix invalide.");
			}
		}

		sc.close();
	}

	private static void ajouterDocumentInteractive(Scanner sc, Bibliotheque biblio) {
		System.out.println("Types disponibles : 1=Livre, 2=Roman, 3=Manuel, 4=Revue, 5=Dictionnaire");
		System.out.print("Choix du type : ");
		String t = sc.nextLine().trim();

		try {
			Document d = null;
			switch (t) {
			case "1": // Livre
				System.out.print("Titre : ");
				String t1 = sc.nextLine();
				System.out.print("Auteur : ");
				String a1 = sc.nextLine();
				System.out.print("Nombre de pages : ");
				int p1 = Integer.parseInt(sc.nextLine().trim());
				d = new Livre(t1, a1, p1);
				break;

			case "2": // Roman
				System.out.print("Titre : ");
				String tr = sc.nextLine();
				System.out.print("Auteur : ");
				String ar = sc.nextLine();
				System.out.print("Nombre de pages : ");
				int pr = Integer.parseInt(sc.nextLine().trim());
				System.out.print("Prix : ");
				double prix = Double.parseDouble(sc.nextLine().trim());
				d = new Roman(tr, ar, pr, prix);
				break;

			case "3": // Manuel
				System.out.print("Titre : ");
				String tm = sc.nextLine();
				System.out.print("Auteur : ");
				String am = sc.nextLine();
				System.out.print("Nombre de pages : ");
				int pm = Integer.parseInt(sc.nextLine().trim());
				System.out.print("Niveau : ");
				String niveau = sc.nextLine();
				d = new Manuel(tm, am, pm, niveau);
				break;

			case "4": // Revue
				System.out.print("Titre : ");
				String tv = sc.nextLine();
				System.out.print("Mois : ");
				String mois = sc.nextLine();
				System.out.print("Année : ");
				int annee = Integer.parseInt(sc.nextLine().trim());
				d = new Revue(tv, mois, annee);
				break;

			case "5": // Dictionnaire
				System.out.print("Titre : ");
				String td = sc.nextLine();
				System.out.print("Langue : ");
				String langue = sc.nextLine();
				d = new Dictionnaire(td, langue);
				break;

			default:
				System.out.println("Type invalide.");
				return;
			}

			boolean ok = biblio.ajouter(d);
			System.out.println(ok ? "Document ajouté : " + d : "Échec de l'ajout (bibliothèque pleine ou doublon).");
		} catch (NumberFormatException nfe) {
			System.out.println("Entrée numérique invalide. Annulation de l'ajout.");
		} catch (Exception e) {
			System.out.println("Erreur lors de l'ajout : " + e.getMessage());
		}
	}
}
