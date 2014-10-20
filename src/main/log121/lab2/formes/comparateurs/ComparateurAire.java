package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurAire extends AbstractComparateur {

	public ComparateurAire() {
		super(false);
	}

	public ComparateurAire(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme fo1, AbstractForme fo2) {
		return inverserSiNecessaire((int) (fo1.getAire() - fo2.getAire()));
	}

}
