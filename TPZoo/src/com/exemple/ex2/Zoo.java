package com.exemple.ex2;

public class Zoo {
	private Animal[] animaux;
	private int nbAnimaux;

	public Zoo() {
		this.animaux = new Animal[5];
		this.nbAnimaux = 0;
	}

	public void ajouterAnimal(Animal a) {
		if (nbAnimaux == animaux.length) {
			Animal[] tmp = new Animal[animaux.length * 2];
			System.arraycopy(animaux, 0, tmp, 0, animaux.length);
			animaux = tmp;
		}
		animaux[nbAnimaux++] = a;
	}

	public void afficherTous() {
		System.out.println("Le zoo contient " + nbAnimaux + " animaux :");
		for (int i = 0; i < nbAnimaux; i++) {
			System.out.println("  - " + animaux[i]);
		}
	}

}
