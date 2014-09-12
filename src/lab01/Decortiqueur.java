package lab01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lab01.formes.FormeFactory;
import lab01.formes.SousForme;

public class Decortiqueur {

	private long noSeq;
	private SousForme forme;
	private int[] dimensions;

	public Decortiqueur(String string) throws IllegalArgumentException {
		// Regex pour trouver les informations relatives à la forme
		Pattern p = Pattern.compile("^([0-9]+)\\s+<([A-Z]+)>\\s*(([0-9]+\\s*){3,4})</[A-Z]+>$");
		Matcher m = p.matcher(string);
		if (!m.find()) {
			throw new IllegalArgumentException(FormeFactory.ERREUR_FORME);
		}
		String noStr = m.group(1);
		String typeStr = m.group(2);
		String dimensionsStr = m.group(3);

		// Convertir les arguements de String en leur bon types
		noSeq = Long.parseLong(noStr);
		// Retrouver la sous-forme en tant qu'enum
		forme = SousForme.getFromString(typeStr);
		// Convertir les dimensions de String à un tableau de String
		String[] dimsStr = dimensionsStr.split(" ");
		// Convertir le tableau de dimensions de String en int
		this.dimensions = new int[dimsStr.length];
		for (int i = 0; i < dimsStr.length; i++) {
			this.dimensions[i] = Integer.parseInt(dimsStr[i]);
		}
	}

	public long getNoSeq() {
		return noSeq;
	}

	public SousForme getForme() {
		return forme;
	}

	public int[] getDimensions() {
		return dimensions;
	}
}
