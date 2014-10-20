package main.log121.lab2.formes;


/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: Ovale.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/

/**
 * Classe qui étend Forme afin de dessiner un ovale ou un rond
 *
 * @author Justin Duplessis
 *
 */
public class Ovale extends AbstractForme {

	/**
	 * Constructeur
	 *
	 * @param sousForme
	 *            Le type de forme
	 * @param dims
	 *            Les dimensions de la forme centreX centreY rayonH rayonV
	 * @param noSeq
	 *            le numéro de séquence
	 */
	public Ovale(SousForme sousForme, int[] dims, int noSeq, int ordreArrivee) {
		super(sousForme, dims, noSeq, ordreArrivee);
		largeur = dims[2] * 2;
		hauteur = dims[3] * 2;
		coinX = dims[0] - dims[2];
		coinY = dims[1] - dims[3];
	}

	public double getAire() {
		return Math.PI * (largeur / 2) * (largeur / 2);
	}

	@Override
	public double getDistanceMaximale() {
		return Math.max(largeur, hauteur);
	}

}
