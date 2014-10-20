package main.log121.lab2.formes;

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

	CARRE(Color.GREEN, 0), RECTANGLE(Color.MAGENTA, 1), CERCLE(Color.PINK, 2), LIGNE(Color.ORANGE, 3), OVALE(
			Color.BLUE, 4);

	/**
	 * Couleur de la sous forme au dessin.
	 */
	public Color couleur;
	/**
	 * Ordre de tri de la sous forme.
	 */
	public int importance;

	/**
	 * Constructeur privé qui permet d'instancier des Enum.
	 * 
	 * @param couleur
	 *            La couleur associée à la sous forme.
	 * @param importance
	 *            Ordre de tri de la sous forme.
	 */
	private SousForme(Color couleur, int importance) {
		this.couleur = couleur;
		this.importance = importance;
	}

	/***
	 * Retrouver la "sous-forme" qui détermine la couleur. Recherche par constante Enum.
	 * 
	 * @param str
	 *            Le nom de la sous-couleur
	 * @return La constante Enum SousForme associée ou null si invalide
	 */
	public static SousForme getFromString(String str) {
		for (SousForme f : SousForme.values()) {
			if (f.name().equals(str)) {
				return f;
			}
		}
		return null;
	}

}
