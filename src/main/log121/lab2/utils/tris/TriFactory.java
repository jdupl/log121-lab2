package main.log121.lab2.utils.tris;

import java.util.Comparator;

import main.log121.lab2.formes.Forme;
import main.log121.lab2.formes.comparateurs.ComparateurFormeParAire;
import main.log121.lab2.formes.comparateurs.ComparateurOrdreArrivee;
import main.log121.lab2.formes.comparateurs.ComparateurTypeForme;

public class TriFactory {

	public static Comparator<Forme> creerComparateur(Tris tri, boolean decroissant) {
		Comparator<Forme> comparateur = null;
		switch (tri) {
		case AIRE:
			comparateur = new ComparateurFormeParAire();
			break;
		case DISTANCE_MAX:
			break;
		case HAUTEUR:
			break;
		case LARGEUR:
			break;
		case NO_SEQ:
			break;
		case ORIGINAL:
			comparateur = new ComparateurOrdreArrivee();
			break;
		case TYPE:
			comparateur = new ComparateurTypeForme();
			break;
		default:
			break;
		}
		return comparateur;
	}
}
