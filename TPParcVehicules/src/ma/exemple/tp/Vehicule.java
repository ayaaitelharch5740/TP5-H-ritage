package ma.exemple.tp;

public class Vehicule {
	private static int compteur = 0;
	private final int id;
	protected String modele;

	public Vehicule(String modele) {
		this.id = ++compteur;
		this.modele = modele;
	}

	@Override
	public String toString() {
		return "Vehicule#" + id + " [" + modele + "]";
	}

}
