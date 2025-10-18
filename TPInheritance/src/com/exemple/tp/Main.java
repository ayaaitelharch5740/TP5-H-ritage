package com.exemple.tp;

public class Main {
	public static void main(String[] args) {

		Compte compte1 = new Compte(1000.0);
		CompteEpargne ce = new CompteEpargne(500.0, 3.0);
		CompteCourant cc = new CompteCourant(200.0, 300.0);

		compte1.afficherDetails();
		compte1.deposer(200);
		compte1.retirer(1500);
		compte1.afficherDetails();
		System.out.println();

		ce.afficherDetails();
		ce.appliquerInterets();
		ce.afficherDetails();
		ce.retirer(100);
		ce.afficherDetails();
		System.out.println();

		cc.afficherDetails();
		cc.retirer(400);
		cc.afficherDetails();
		cc.retirer(200);
		cc.afficherDetails();
		System.out.println();

		Compte poly = new CompteEpargne(100, 5);
		poly.afficherDetails();
	}

}
