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

/**
 * Classe qui étend Forme afin de dessiner un rectangle ou un carré.
 *
 * @author Justin Duplessis
 *
 */
public class Rectangle extends AbstractForme {

	/**
	 * Constructeur
	 *
	 * @param sousForme
	 *            Le type de forme
	 * @param dims
	 *            Les dimensions de la forme x1 y1 x2 y2
	 * @param noSeq
	 *            le numéro de séquence
	 */
	public Rectangle(SousForme sousForme, int[] dims, int noSeq, int ordreArrivee) {
		super(sousForme, dims, noSeq, ordreArrivee);
		largeur = dims[2] - dims[0];
		hauteur = dims[3] - dims[1];
		coinX = dims[0];
		coinY = dims[1];
	}

	public double getAire(){
		return this.getLargeur() * this.getHauteur();
	}

	@Override
	public double getDistanceMaximale() {
		return Math.sqrt(Math.pow(largeur, 2)+Math.pow(hauteur, 2));
	}

}
