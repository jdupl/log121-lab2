package lab01.formes;

import lab01.Decortiqueur;

public class FormeFactory {

	/**
	 * Instancie une forme selon une chaîne de caractères.
	 * 
	 * @param string
	 *            La chaîne de caractères
	 * @return La forme instanciée
	 * @throws IllegalArgumentException
	 *             Exception lancée si la ligne reçue n'est pas conforme avec les formes disponibles.
	 */
	public static Forme lireString(String string) throws IllegalArgumentException {
		Decortiqueur decortiqueur = new Decortiqueur(string);
		Forme f = null;
		switch (decortiqueur.getForme()) {
		case LIGNE:
			f = new Ligne(decortiqueur.getDimensions(), decortiqueur.getNoSeq());
			break;
		case CARRE:
		case RECTANGLE:
			f = new Rectangle(decortiqueur.getForme(), decortiqueur.getDimensions(), decortiqueur.getNoSeq());
			break;
		case CERCLE:
			// Logique qui permet d'attribuer le rayon d'un cercle aux rayons d'un ovale
			int[] fix = new int[4];
			for (int i = 0; i < decortiqueur.getDimensions().length; i++) {
				fix[i] = decortiqueur.getDimensions()[i];
			}
			fix[3] = fix[2];
			f = new Ovale(decortiqueur.getForme(), fix, decortiqueur.getNoSeq());
			break;
		case OVALE:
			f = new Ovale(decortiqueur.getForme(), decortiqueur.getDimensions(), decortiqueur.getNoSeq());
			break;
		default:
			break;
		}
		return f;
	}
}
