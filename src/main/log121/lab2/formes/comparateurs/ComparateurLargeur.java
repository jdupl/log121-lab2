package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurLargeur extends Comparateur {

	public ComparateurLargeur() {
		super(false);
	}

	public ComparateurLargeur(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(Forme f1, Forme f2) {
		return inverserSiNecessaire((int) (f1.getLargeur() - f2.getLargeur()));
	}
	
}