package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurHauteur extends AbstractComparateur {

	public ComparateurHauteur() {
		super(false);
	}

	public ComparateurHauteur(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire(forme1.getHauteur() - forme2.getHauteur());
	}

}
