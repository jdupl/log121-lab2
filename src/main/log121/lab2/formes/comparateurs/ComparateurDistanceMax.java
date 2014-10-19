package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurDistanceMax extends Comparateur {

	@Override
	public int compare(Forme forme1, Forme forme2) {
		return inverserSiNecessaire((int) (forme1.getDistanceMaximale() - forme2.getDistanceMaximale()));
	}

}
