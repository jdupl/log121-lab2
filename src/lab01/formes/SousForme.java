package lab01.formes;

import java.awt.Color;

public enum SousForme {

	CARRE(Color.GREEN), RECTANGLE(Color.MAGENTA), CERCLE(Color.PINK), LIGNE(Color.ORANGE), OVALE(Color.BLUE);

	public Color couleur;

	SousForme(Color couleur) {
		this.couleur = couleur;
	}

	public static SousForme getFromString(String s) {
		for (SousForme f : SousForme.values()) {
			if (f.name().equals(s)) {
				return f;
			}
		}
		return null;
	}

}
