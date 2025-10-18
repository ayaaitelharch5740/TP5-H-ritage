package com.exemple.ex2;

public class Animal {

	private static int compteur = 0;
	private final int id;
	protected String nom;
	protected int age;

	public Animal(String nom, int age) {
		this.id = ++compteur;
		this.nom = nom;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public int getAge() {
		return age;
	}

	public void seDeplacer() {
		System.out.println(nom + " se déplace.");
	}

	@Override
	public String toString() {
		return "Animal[id=" + id + ", nom=" + nom + ", age=" + age + "]";
	}

}
