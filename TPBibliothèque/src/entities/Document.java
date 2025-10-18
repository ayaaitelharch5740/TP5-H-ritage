package entities;

public class Document {
	private static int compteur = 1; // auto-incrément
	private final int numEnreg;
	private String titre;

	public Document(String titre) {
		this.numEnreg = compteur++;
		this.titre = titre;
	}

	public int getNumEnreg() {
		return numEnreg;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Document{" + "numEnreg=" + numEnreg + ", titre='" + titre + '\'' + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Document document = (Document) o;
		return numEnreg == document.numEnreg;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(numEnreg);
	}

}
