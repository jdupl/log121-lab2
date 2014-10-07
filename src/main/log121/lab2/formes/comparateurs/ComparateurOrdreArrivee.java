package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurOrdreArrivee extends Comparateur {

	public ComparateurOrdreArrivee() {
		super(false);
	}
	
	public ComparateurOrdreArrivee(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(Forme forme1, Forme forme2) {
		return forme1.getOrdreArrivee() - forme2.getOrdreArrivee();
	}

}
