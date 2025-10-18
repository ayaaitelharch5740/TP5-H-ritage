package entities;

import java.util.HashSet;
import java.util.Set;

public class Bibliotheque {
	private Document[] documents;
	private int capacite;
	private int nb; // nombre actuel de documents

	public Bibliotheque(int capacite) {
		if (capacite <= 0)
			throw new IllegalArgumentException("Capacité doit être > 0");
		this.capacite = capacite;
		this.documents = new Document[capacite];
		this.nb = 0;
	}

	public void afficherDocuments() {
		if (nb == 0) {
			System.out.println("Bibliothèque vide.");
			return;
		}
		for (int i = 0; i < nb; i++) {
			System.out.println(documents[i]);
		}
	}

	public boolean ajouter(Document doc) {
		if (doc == null)
			return false;
		if (nb >= capacite)
			return false;
		// évite doublon par numEnreg
		for (int i = 0; i < nb; i++) {
			if (documents[i].equals(doc)) {
				return false; // déjà présent
			}
		}
		documents[nb++] = doc;
		return true;
	}

	public boolean supprimer(Document doc) {
		if (doc == null)
			return false;
		for (int i = 0; i < nb; i++) {
			if (documents[i].equals(doc)) {
				// décale
				for (int j = i; j < nb - 1; j++) {
					documents[j] = documents[j + 1];
				}
				documents[nb - 1] = null;
				nb--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Renvoie le document avec le numéro d'enregistrement fourni, ou null si
	 * introuvable.
	 */
	public Document document(int numEnrg) {
		for (int i = 0; i < nb; i++) {
			if (documents[i].getNumEnreg() == numEnrg)
				return documents[i];
		}
		return null;
	}

	/**
	 * Affiche la liste des auteurs de tous les ouvrages qui ont un auteur. Un
	 * auteur est affiché une seule fois.
	 */
	public void afficherAuteurs() {
		Set<String> auteurs = new HashSet<>();
		for (int i = 0; i < nb; i++) {
			Document d = documents[i];
			if (d instanceof Livre) {
				String a = ((Livre) d).getAuteur();
				if (a != null && !a.trim().isEmpty())
					auteurs.add(a);
			}
		}
		if (auteurs.isEmpty()) {
			System.out.println("Aucun auteur répertorié.");
			return;
		}
		System.out.println("Auteurs :");
		for (String a : auteurs) {
			System.out.println("- " + a);
		}
	}

	// getters utiles
	public int getCapacite() {
		return capacite;
	}

	public int getNb() {
		return nb;
	}
}
