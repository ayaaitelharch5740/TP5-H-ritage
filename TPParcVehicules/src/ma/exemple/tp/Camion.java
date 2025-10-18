package ma.exemple.tp;

public class Camion extends Motorise {
	private double capaciteCharge; 

	public Camion(String modele, Moteur moteur, double carburant, double capaciteCharge) {
		super(modele, moteur, carburant);
		this.capaciteCharge = capaciteCharge;
	}

	public void charger(double poids) {
		System.out.println(modele + " charge " + poids + " t (max " + capaciteCharge + " t)");
	}

	@Override
	public String toString() {
		return super.toString() + " {Camion, cap=" + capaciteCharge + " t}";
	}

}
