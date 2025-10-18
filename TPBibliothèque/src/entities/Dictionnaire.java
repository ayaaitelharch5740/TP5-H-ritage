package entities;

public class Dictionnaire extends Document {
	private String langue;

	public Dictionnaire(String titre, String langue) {
		super(titre);
		this.langue = langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	@Override
	public String toString() {
		return "Dictionnaire{" + "numEnreg=" + getNumEnreg() + ", titre='" + getTitre() + '\'' + ", langue='" + langue
				+ '\'' + '}';
	}

}
