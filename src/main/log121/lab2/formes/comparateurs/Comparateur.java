package main.log121.lab2.formes.comparateurs;

import java.util.Comparator;

import main.log121.lab2.formes.Forme;

public abstract class Comparateur implements Comparator<Forme> {

	private boolean decroissant;

	public Comparateur() {
		this.decroissant = false;
	}

	public Comparateur(boolean decroissant) {
		this.decroissant = decroissant;
	}

	public boolean estDecroissant() {
		return decroissant;
	}

	public boolean estCroissant() {
		return !decroissant;
	}

}
