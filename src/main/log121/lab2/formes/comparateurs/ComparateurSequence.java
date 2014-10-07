package main.log121.lab2.formes.comparateurs;

import java.util.Comparator;

import main.log121.lab2.formes.Forme;

public class ComparateurSequence implements Comparator<Forme>{

	@Override
	public int compare(Forme forme1, Forme forme2) {
		return forme1.getId() - forme2.getId();
	}

}
