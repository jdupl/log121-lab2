package main.log121.lab2.utils.tris;

import main.log121.lab2.formes.comparateurs.Comparateur;
import main.log121.lab2.formes.comparateurs.ComparateurAire;
import main.log121.lab2.formes.comparateurs.ComparateurHauteur;
import main.log121.lab2.formes.comparateurs.ComparateurLargeur;
import main.log121.lab2.formes.comparateurs.ComparateurOrdreArrivee;
import main.log121.lab2.formes.comparateurs.ComparateurDistanceMax;
import main.log121.lab2.formes.comparateurs.ComparateurSequence;
import main.log121.lab2.formes.comparateurs.ComparateurTypeForme;

public class TriFactory {

	public static Comparateur creerComparateur(Tris tri, boolean decroissant) {
		Comparateur comparateur = null;
		switch (tri) {
		case AIRE:
			comparateur = new ComparateurAire(decroissant);
			break;
		case DISTANCE_MAX:
			comparateur = new ComparateurDistanceMax();
			break;
		case HAUTEUR:
			comparateur = new ComparateurHauteur(decroissant);
			break;
		case LARGEUR:
			comparateur = new ComparateurLargeur(decroissant);
			break;
		case NO_SEQ:
			comparateur = new ComparateurSequence(decroissant);
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
