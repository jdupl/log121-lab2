package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: FormeFactory.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/

import main.log121.lab2.formes.Forme;
import main.log121.lab2.formes.Ligne;
import main.log121.lab2.formes.Ovale;
import main.log121.lab2.formes.Rectangle;

/**
 * Instancie une forme selon une chaîne de caractères en appelant la classe Decortiqueur.
 *
 * @author Justin Duplessis
 *
 */
public class FormeFactory {

	public final static String ERREUR_FORME = "La ligne n'est pas reconnue comme étant une forme.";
	public static int compte = 0;

	/**
	 * Crée une nouvelle forme. Cette méthode reçoit la chaîne de caractères provenant du serveur de formes, elle
	 * détermine de quelle forme il s'agit et applique l'opérateur new sur le constructeur de la forme désirée.
	 *
	 * @param chaineForme
	 *            un objet String contenant la chaîne de caractères qui décrit une forme et provenant du serveur de
	 *            formes.
	 *
	 * @return une instance d'une des sous-classes de la classe abstraite Forme avec les paramètres passés par la chaîne
	 *         d'entrée.
	 * @throws IllegalArgumentException
	 *             Exception lancée si la ligne reçue n'est pas conforme avec les formes disponibles.
	 */
	public static Forme lireString(String formeStr) throws IllegalArgumentException {
		Forme f = null;
		// Créer un décortiqueur afin de retrouver les champs de la forme
		Decortiqueur decortiqueur = new Decortiqueur(formeStr);

		switch (decortiqueur.getForme()) {
		case LIGNE:
			f = new Ligne(decortiqueur.getDimensions(), decortiqueur.getNoSeq(), compte);
			break;
		case CARRE:
		case RECTANGLE:
			f = new Rectangle(decortiqueur.getForme(), decortiqueur.getDimensions(), decortiqueur.getNoSeq(), compte);
			break;
		case CERCLE:
			// Logique qui permet d'attribuer le rayon d'un cercle aux rayons d'un ovale
			// En temps normal, l'usage d'une classe de type List ne nécessiterait pas autant de code additionnel.
			// Dans le cas présent, il faut copier le tableau plus petit dans un nouveau tableau avec la dimension
			// souhaitée.
			int[] fix = new int[4];
			for (int i = 0; i < decortiqueur.getDimensions().length; i++) {
				fix[i] = decortiqueur.getDimensions()[i];
			}
			fix[3] = fix[2]; // rayonV = rayonH
			f = new Ovale(decortiqueur.getForme(), fix, decortiqueur.getNoSeq(), compte);
			break;
		case OVALE:
			f = new Ovale(decortiqueur.getForme(), decortiqueur.getDimensions(), decortiqueur.getNoSeq(), compte);
			break;
		default:
			// Cas où la sousforme n'est pas dans les cas plus hauts
			throw new IllegalArgumentException(ERREUR_FORME);
		}
		compte++;
		return f;
	}
}
