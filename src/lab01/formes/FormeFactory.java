package lab01.formes;

import lab01.Decortiqueur;

public class FormeFactory {

	public final static String ERREUR_FORME = "La ligne n'est pas reconnue comme étant une forme.";

	/**
	 * Instancie une forme selon une chaîne de caractères en appelant la classe Decortiqueur.
	 * 
	 * @param formeStr
	 *            La chaîne de caractères du serveur
	 * @return La forme instanciée
	 * @throws IllegalArgumentException
	 *             Exception lancée si la ligne reçue n'est pas conforme avec les formes disponibles.
	 */
	public static Forme lireString(String formeStr) throws IllegalArgumentException {
		Forme f = null;
		// Créer un décortiqueur afin de retrouver les champs de la forme
		Decortiqueur decortiqueur = new Decortiqueur(formeStr);

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
			// En temps normal, l'usage d'une classe de type List ne nécessiterait pas autant de code additionnel.
			// Dans le cas présent, il faut copier le tableau plus petit dans un nouveau tableau avec la dimension
			// souhaitée.
			int[] fix = new int[4];
			for (int i = 0; i < decortiqueur.getDimensions().length; i++) {
				fix[i] = decortiqueur.getDimensions()[i];
			}
			fix[3] = fix[2]; // rayonV = rayonH
			f = new Ovale(decortiqueur.getForme(), fix, decortiqueur.getNoSeq());
			break;
		case OVALE:
			f = new Ovale(decortiqueur.getForme(), decortiqueur.getDimensions(), decortiqueur.getNoSeq());
			break;
		default:
			// Cas où la sousforme n'est pas dans les cas plus hauts
			throw new IllegalArgumentException(ERREUR_FORME);
		}
		return f;
	}
}
