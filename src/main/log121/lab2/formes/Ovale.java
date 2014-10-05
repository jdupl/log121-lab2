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
import java.awt.Graphics;

/**
 * Classe qui étend Forme afin de dessiner un ovale ou un rond
 * 
 * @author Justin Duplessis
 *
 */
public class Ovale extends Forme {

	/**
	 * Constructeur
	 * 
	 * @param sousForme
	 *            Le type de forme
	 * @param dims
	 *            Les dimensions de la forme centreX centreY rayonH rayonV
	 * @param id
	 *            le numéro de séquence
	 */
	public Ovale(SousForme sousForme, int[] dims, int id) {
		super(sousForme, dims, id);
		super.largeur = dims[2] * 2;
		super.hauteur = dims[3] * 2;
	}

	@Override
	public void dessinerForme(Graphics g) {
		//Coin X gauche superieur
		int coinX = dims[0] - dims[2];
		//Coin Y gauche superieur
		int coinY = dims[1] - dims[3];
		g.fillOval(coinX, coinY, super.largeur, super.hauteur);
	}
	
}
