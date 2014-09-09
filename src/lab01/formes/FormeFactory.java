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
		System.out.println(string);
		// Regex pour trouver les informations relatives à la forme
		Pattern p = Pattern.compile("^([0-9]+)\\s+<([A-Z]+)>\\s*(([0-9]+\\s*){3,4})</[A-Z]+>$");
		Matcher m = p.matcher(string);
		if (!m.find()) {
			throw new IllegalArgumentException("La ligne n'est pas reconnue comme étant une forme.");
		}
		Long id = Long.parseLong(m.group(1));
		String typeStr = m.group(2);
		String dimensionsStr = m.group(3);

		int[] dims = new int[4];
		// retrouver la sous-forme en tant qu'enum
		SousForme sousForme = SousForme.getFromString(typeStr);
		String[] dimsStr = dimensionsStr.split(" ");

		if (dimsStr.length == 4 || (dimsStr.length == 3 && sousForme == SousForme.CERCLE)) {
			for (int i = 0; i < dimsStr.length; i++) {
				dims[i] = Integer.parseInt(dimsStr[i]);
			}
			if (sousForme == SousForme.CERCLE) {
				dims[3] = dims[2];
			}
		} else {
			throw new IllegalArgumentException("Les dimensions de la forme ne font pas de sens.");
		}

		Forme f = null;
		switch (sousForme) {
		case CARRE:
		case RECTANGLE:
		case LIGNE:
			f = new Rectangle(sousForme, dims, id);
			break;
		case CERCLE:
		case OVALE:
			f = new Ovale(sousForme, dims, id);
			break;
		default:
			break;
		}
		return f;
	}
}
