package main.log121.lab2.formes.comparateurs;

import main.log121.lab2.formes.AbstractForme;

public class ComparateurOrdreArrivee extends AbstractComparateur {

	public ComparateurOrdreArrivee() {
		super(false);
	}

	public ComparateurOrdreArrivee(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire(forme1.getOrdreArrivee() - forme2.getOrdreArrivee());
	}

}
