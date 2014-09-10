package lab01.formes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		// Regex pour trouver les informations relatives à la forme
		Pattern p = Pattern.compile("^([0-9]+)\\s+<([A-Z]+)>\\s*(([0-9]+\\s*){3,4})</[A-Z]+>$");
		Matcher m = p.matcher(string);
		if (!m.find()) {
			throw new IllegalArgumentException("La ligne n'est pas reconnue comme étant une forme.");
		}
		String idStr = m.group(1);
		String typeStr = m.group(2);
		String dimensionsStr = m.group(3);

		// Convertir les arguements de String en leur bon types
		Long id = Long.parseLong(idStr);
		// retrouver la sous-forme en tant qu'enum1
		SousForme sousForme = SousForme.getFromString(typeStr);
		// Convertir les dimensions de String à un tableau de String
		String[] dimsStr = dimensionsStr.split(" ");
		// Convertirle tableau de dimensions de String en int
		int[] listeDims = new int[4];
		if (dimsStr.length == 4 || (dimsStr.length == 3 && sousForme == SousForme.CERCLE)) {
			for (int i = 0; i < dimsStr.length; i++) {
				listeDims[i] = Integer.parseInt(dimsStr[i]);
			}
			// Les deux rayons sont égaux pour un cercle
			if (sousForme == SousForme.CERCLE) {
				listeDims[3] = listeDims[2];
			}
		} else {
			throw new IllegalArgumentException("Les dimensions de la forme ne font pas de sens.");
		}

		Forme f = null;
		switch (sousForme) {
		case CARRE:
		case RECTANGLE:
		case LIGNE:
			f = new Rectangle(sousForme, listeDims, id);
			break;
		case CERCLE:
		case OVALE:
			f = new Ovale(sousForme, listeDims, id);
			break;
		default:
			break;
		}
		return f;
	}
}
