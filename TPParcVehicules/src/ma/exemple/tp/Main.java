package ma.exemple.tp;

public class Main {
	public static void main(String[] args) {
		Flotte flotte = new Flotte();

		Voiture v1 = new Voiture("Clio", new Moteur("Essence", 75), 50, 5);
		Camion c1 = new Camion("Volvo", new Moteur("Diesel", 400), 200, 20);
		Moto m1 = new Moto("Harley", new Moteur("Essence", 90), 20, 1200);
		VoitureElectrique e1 = new VoitureElectrique("Tesla", new Moteur("Élec", 300), 85);

		flotte.ajouter(v1);
		flotte.ajouter(c1);
		flotte.ajouter(m1);
		flotte.ajouter(e1);

		flotte.afficherTous();
		System.out.println();

		v1.demarrer();
		v1.rouler(100);
		v1.refuel(20);
		v1.rouler(300);

		System.out.println();
		e1.demarrer();
		e1.rouler(200);
		e1.refuel(50);
		e1.rouler(300);

		System.out.println();
		System.out.println("Distance totale parcourue : " + flotte.distanceTotale() + " km");
	}

}
