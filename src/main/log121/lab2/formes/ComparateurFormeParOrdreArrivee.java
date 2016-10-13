package main.log121.lab2.formes;

import java.util.Comparator;

public class ComparateurFormeParOrdreArrivee implements Comparator<Forme>{

	@Override
	public int compare(Forme f1, Forme f2) {
		return f1.getOrdreArrivee() - f2.getOrdreArrivee();
	}

}
