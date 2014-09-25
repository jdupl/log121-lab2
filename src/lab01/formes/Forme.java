package lab01.formes;

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
import java.awt.Graphics;

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
	 * Le dimensions et/ou coordonées de la forme
	 */
	protected int[] dims;

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
	public Forme(SousForme sousForme, int[] dims, int id) {
		this.sousForme = sousForme;
		this.dims = dims;
		this.id = id;
	}

	/**
	 * Méthode qui permet à une classe externe de dessiner la forme.
	 * 
	 * @param g
	 *            Le composant sur lequel dessiner
	 */
	public void dessiner(Graphics g) {
		g.setColor(getCouleur());
		dessinerForme(g);
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
}
