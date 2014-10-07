package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurParDistanceMax extends Comparateur {

	@Override
	public int compare(Forme o1, Forme o2) {
		return inverserSiNecessaire(o1.getDistanceMaximale() - o2.getDistanceMaximale());
		
	}

}
