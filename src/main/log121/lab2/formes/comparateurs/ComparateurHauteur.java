package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurHauteur extends Comparateur {

	public ComparateurHauteur() {
		super(false);
	}

	public ComparateurHauteur(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(Forme forme1, Forme forme2) {
		return inverserSiNecessaire(forme1.getHauteur() - forme2.getHauteur());
	}

}
