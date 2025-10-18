package ma.exemple.tp;

public class Flotte {
	private Vehicule[] parc = new Vehicule[5];
	private int nb = 0;

	public void ajouter(Vehicule v) {
		if (nb == parc.length) {
			Vehicule[] tmp = new Vehicule[parc.length * 2];
			System.arraycopy(parc, 0, tmp, 0, parc.length);
			parc = tmp;
		}
		parc[nb++] = v;
	}

	public void afficherTous() {
		System.out.println("Flotte (" + nb + " véhicules) :");
		for (int i = 0; i < nb; i++) {
			System.out.println("  • " + parc[i]);
		}
	}

	public double distanceTotale() {
		double sum = 0;
		for (int i = 0; i < nb; i++) {
			if (parc[i] instanceof Motorise) {
				sum += ((Motorise) parc[i]).kmTotal;
			}
		}
		return sum;
	}

}
