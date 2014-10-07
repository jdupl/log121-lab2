package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurFormeParAire extends Comparateur {

	@Override
	public int compare(Forme f1, Forme f2) {
		return (int) (f1.getAire() - f2.getAire());
	}

}
