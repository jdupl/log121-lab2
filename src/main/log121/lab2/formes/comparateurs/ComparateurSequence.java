package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurSequence extends AbstractComparateur {

	public ComparateurSequence() {
		super(false);
	}

	public ComparateurSequence(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire(forme1.getId() - forme2.getId());
	}

}
