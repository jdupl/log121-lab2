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
	 *            Les dimensions de la forme entreX centreY rayonH rayonV
	 * @param id
	 *            le numéro de séquence
	 */
	public Ovale(SousForme sousForme, int[] dims, int id) {
		super(sousForme, dims, id);
	}

	@Override
	public void dessinerForme(Graphics g) {
		g.fillOval(dims[0], dims[1], dims[2], dims[3]);
	}

}
