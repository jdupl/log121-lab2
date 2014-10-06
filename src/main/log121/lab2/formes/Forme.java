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
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Représentation abstraite d'une forme. La forme peut être dessinée.
 *
 * @author Justin Duplessis
 *
 */
public abstract class Forme {

	/**
	 * Numéro de séquence
	 */
	protected int id;
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
	 * @param id
	 *            le numéro de séquence
	 */
	public Forme(SousForme sousForme, int[] dims, int id, int ordreArrivee) {
		this.sousForme = sousForme;
		this.dims = dims;
		this.id = id;
		this.ordreArrivee = ordreArrivee;
	}

	/**
	 * Méthode qui permet à une classe externe de dessiner la forme.
	 *
	 * @param g
	 *            Le composant sur lequel dessiner
	 */
	public void dessiner(Graphics2D g) {
		g.setColor(getCouleur());
		g.setStroke(new BasicStroke());
		dessinerForme((Graphics) g);

		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1f, new float[] { 2f }, 0f));
		g.drawRect(coinX, coinY, largeur, hauteur);
	}

	/**
	 * Méthode abstraite qui devra être implémentée par la forme afin d'appeler la bonne méthode de l'API standard.
	 *
	 * @param g
	 *            Le composant sur lequel dessiner
	 */
	protected abstract void dessinerForme(Graphics g);

	/**
	 * Accesseur qui permet d'obtenir la couleur de la sous forme associée à la forme.
	 *
	 * @return La couleur
	 */
	protected Color getCouleur() {
		return sousForme.couleur;
	}

	/**
	 * Accesseur qui permet d'obtenir le numéro de séquence de la forme.
	 *
	 * @return Le numéro de séquence
	 */
	public int getId() {
		return id;
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

}
