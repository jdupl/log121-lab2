import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormeFactory {

	/**
	 * Instancie une forme selon une chaîne de caractères.
	 * 
	 * @param string
	 *            La chaîne de caractères
	 * @return La forme ou null si la chaîne n'est pas valide.
	 */
	public static Forme lireString(String string) {
		System.out.println(string);
		Pattern p = Pattern.compile("^([0-9]+)\\s+<([A-Z]+)>\\s*(([0-9]+\\s*){3,4})</[A-Z]+>$");
		Matcher m = p.matcher(string);
		if (!m.find()) {
			return null;
		}

		Long id = Long.parseLong(m.group(1));
		String type = m.group(2);
		String dimensions = m.group(3);
		System.out.println(id);
		System.out.println(type);
		System.out.println(dimensions);

		return null;
	}
}
