package ma.exemple.tp;

public class VoitureElectrique extends Motorise {
	public VoitureElectrique(String modele, Moteur moteur, double batterieInitial) {
		super(modele, moteur, batterieInitial);
	}

	@Override
	public void refuel(double kWh) {
		niveauCarburant += kWh;
		System.out.println(modele + " recharge " + kWh + " kWh (niveau=" + niveauCarburant + ")");
	}

	@Override
	public String toString() {
		return super.toString().replace("carburant", "batterie") + " {Electrique}";
	}

}
