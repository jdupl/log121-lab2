package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurFormeParAire extends Comparateur {

	public ComparateurFormeParAire() {
		super(false);
	}

	public ComparateurFormeParAire(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(Forme f1, Forme f2) {
		return inverserSiNecessaire((int) (f1.getAire() - f2.getAire()));
	}

}
