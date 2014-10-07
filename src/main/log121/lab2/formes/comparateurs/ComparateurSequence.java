package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.Forme;

public class ComparateurSequence extends Comparateur {

	public ComparateurSequence() {
		super(false);
	}
	
	public ComparateurSequence(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(Forme forme1, Forme forme2) {
		return forme1.getId() - forme2.getId();
	}

}
