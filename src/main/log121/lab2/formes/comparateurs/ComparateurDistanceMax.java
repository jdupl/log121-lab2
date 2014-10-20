package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurDistanceMax extends AbstractComparateur {

	@Override
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire((int) (forme1.getDistanceMaximale() - forme2.getDistanceMaximale()));
	}

}
