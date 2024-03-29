package main.log121.lab2.formes;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: Ligne.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/

/**
 * Classe qui étend Forme afin de dessiner une ligne.
 *
 * @author Justin Duplessis
 *
 */
public class Ligne extends AbstractForme {

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
	public Ligne(int[] dims, int noSeq, int ordreArrivee) {
		super(SousForme.LIGNE, dims, noSeq, ordreArrivee);
		super.largeur = Math.abs(dims[2] - dims[0]);
		super.hauteur = Math.abs(dims[3] - dims[1]);
		super.coinX = Math.min(dims[0], dims[2]);
		super.coinY = Math.min(dims[1], dims[3]);
	}

	public double getAire(){
		return 0;
	}

	@Override
	public double getDistanceMaximale() {
		return Math.sqrt(Math.pow(largeur, 2)+Math.pow(hauteur, 2));
	}

}
