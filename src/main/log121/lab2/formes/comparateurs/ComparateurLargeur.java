package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurLargeur extends AbstractComparateur {

	public ComparateurLargeur() {
		super(false);
	}

	public ComparateurLargeur(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme fo1, AbstractForme fo2) {
		return inverserSiNecessaire((int) (fo1.getLargeur() - fo2.getLargeur()));
	}
	
}