package main.log121.lab2.utils.tris;

import main.log121.lab2.formes.comparateurs.Comparateur;
import main.log121.lab2.formes.comparateurs.ComparateurFormeParAire;
import main.log121.lab2.formes.comparateurs.ComparateurOrdreArrivee;
import main.log121.lab2.formes.comparateurs.ComparateurTypeForme;

public class TriFactory {

	public static Comparateur creerComparateur(Tris tri, boolean decroissant) {
		Comparateur comparateur = null;
		switch (tri) {
		case AIRE:
			comparateur = new ComparateurFormeParAire(decroissant);
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
			comparateur = new ComparateurOrdreArrivee(decroissant);
			break;
		case TYPE:
			comparateur = new ComparateurTypeForme(decroissant);
			break;
		default:
			break;
		}
		return comparateur;
	}
}
