package main.log121.lab2.formes;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: Rectangle.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/
import java.awt.Graphics;

/**
 * Classe qui étend Forme afin de dessiner un rectangle ou un carré.
 * 
 * @author Justin Duplessis
 *
 */
public class Rectangle extends Forme {

	/**
	 * Constructeur
	 * 
	 * @param sousForme
	 *            Le type de forme
	 * @param dims
	 *            Les dimensions de la forme x1 y1 x2 y2
	 * @param id
	 *            le numéro de séquence
	 */
	public Rectangle(SousForme sousForme, int[] dims, int id) {
		super(sousForme, dims, id);
		super.largeur = dims[2] - dims[0];
		super.hauteur = dims[3] - dims[1];
	}

	@Override
	public void dessinerForme(Graphics g) {
		g.fillRect(dims[0], dims[1], super.largeur, super.hauteur);
	}

}
