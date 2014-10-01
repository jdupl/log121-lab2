package main.lab01.formes;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: SousForme.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/
import java.awt.Color;

/**
 * Enum qui permet de représenter les sous-formes. Contient la couleur de la sous forme lors de l'affichage.
 * 
 * @author justin
 *
 */
public enum SousForme {

	CARRE(Color.GREEN), RECTANGLE(Color.MAGENTA), CERCLE(Color.PINK), LIGNE(Color.ORANGE), OVALE(Color.BLUE);

	public Color couleur;

	/**
	 * Constructeur privé qui permet d'instancier des Enum.
	 * 
	 * @param couleur
	 *            La couleur associée à la sous forme.
	 */
	private SousForme(Color couleur) {
		this.couleur = couleur;
	}

	/***
	 * Retrouver la "sous-forme" qui détermine la couleur. Recherche par constante Enum.
	 * 
	 * @param s
	 *            Le nom de la sous-couleur
	 * @return La constante Enum SousForme associée ou null si invalide
	 */
	public static SousForme getFromString(String s) {
		for (SousForme f : SousForme.values()) {
			if (f.name().equals(s)) {
				return f;
			}
		}
		return null;
	}

}
