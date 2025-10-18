package com.exemple.ex2;

public class Oiseau extends Animal {
	private double envergure;

	public Oiseau(String nom, int age, double envergure) {
		super(nom, age);
		this.envergure = envergure;
	}

	public void voler() {
		System.out.println(nom + " s'envole avec une envergure de " + envergure + " m.");
	}

	@Override
	public String toString() {
		return super.toString() + " {Oiseau, envergure=" + envergure + "}";
	}

}
