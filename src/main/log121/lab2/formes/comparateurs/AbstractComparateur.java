package main.log121.lab2.formes.comparateurs;

import java.util.Comparator;

import main.log121.lab2.formes.AbstractForme;

public abstract class AbstractComparateur implements Comparator<AbstractForme> {

	private boolean decroissant;

	public AbstractComparateur() {
		this.decroissant = false;
	}

	public AbstractComparateur(boolean decroissant) {
		this.decroissant = decroissant;
	}

	public boolean estDecroissant() {
		return decroissant;
	}

	public boolean estCroissant() {
		return !decroissant;
	}

	protected int inverserSiNecessaire(int diff) {
		return this.estDecroissant() ? -1 * diff : diff;
	}

}
