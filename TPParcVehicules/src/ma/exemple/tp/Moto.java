package ma.exemple.tp;

public class Moto extends Motorise {
	private double cylindree;

	public Moto(String modele, Moteur moteur, double carburant, double cylindree) {
		super(modele, moteur, carburant);
		this.cylindree = cylindree;
	}

	public void faireWheelie() {
		System.out.println(modele + " fait un wheelie !");
	}

	@Override
	public String toString() {
		return super.toString() + " {Moto, cylindrée=" + cylindree + " cm³}";
	}

}
