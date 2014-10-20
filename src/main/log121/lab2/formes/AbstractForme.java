package main.log121.lab2.formes;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: Forme.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/
import java.awt.Color;

/**
 * Représentation abstraite d'une forme. La forme peut être dessinée.
 *
 * @author Justin Duplessis
 *
 */
public abstract class AbstractForme {

	/**
	 * Numéro de séquence
	 */
	protected int noSeq;
	/**
	 * La sous forme
	 */
	protected SousForme sousForme;
	/**
	 * La dimensions et/ou coordonées de la forme
	 */
	protected int[] dims;
	/**
	 * Le coin superieur gauche X
	 */
	protected int coinX;
	/**
	 * Le coin superieur gauche Y
	 */
	protected int coinY;
	/**
	 * La largeur de la forme
	 */
	protected int largeur;
	/**
	 * La hauteur de la forme
	 */
	protected int hauteur;

	/**
	 * L'ordre d'Arrivée de la forme
	 */
	private int ordreArrivee;

	/**
	 * Constructeur
	 *
	 * @param sousForme
	 *            Le type de forme
	 * @param dims
	 *            Les dimensions de la forme
	 * @param noSeq
	 *            le numéro de séquence
	 */
	public AbstractForme(SousForme sousForme, int[] dims, int noSeq, int ordreArrivee) {
		this.sousForme = sousForme;
		this.dims = dims;
		this.noSeq = noSeq;
		this.ordreArrivee = ordreArrivee;
	}

	/**
	 * Accesseur qui permet d'obtenir la couleur de la sous forme associée à la forme.
	 *
	 * @return La couleur
	 */
	protected Color getCouleur() {
		return sousForme.couleur;
	}

	/**
	 * Accesseur qui permet d'obtenir l'importance de la sous forme pour le tri.
	 *
	 * @return La couleur
	 */
	public int getImportance() {
		return sousForme.importance;
	}

	/**
	 * Accesseur qui permet d'obtenir le numéro de séquence de la forme.
	 *
	 * @return Le numéro de séquence
	 */
	public int getId() {
		return noSeq;
	}

	/**
	 * Accesseur qui permet d'obtenir la largeur de la forme.
	 *
	 * @return La largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * Accesseur qui permet d'obtenir la hauteur de la forme.
	 *
	 * @return La hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * Accesseur qui permet d'obtenir la position d'arrivée de la forme.
	 *
	 * @return Le position (à partir de 0)
	 */
	public int getOrdreArrivee() {
		return ordreArrivee;
	}

	/**
	 * Accesseur qui permet d'obtenir l'aire de la forme.
	 *
	 * @return L'aire
	 */
	public abstract double getAire();
	
	/**
	 * Accesseur qui permet d'obtenir la distance maximal de la forme.
	 *
	 * @return La distance maximale
	 */
	public abstract double getDistanceMaximale();

}
