package main.lab01.formes;

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
import java.awt.Graphics;

/**
 * Classe qui étend Forme afin de dessiner une ligne.
 * 
 * @author Justin Duplessis
 *
 */
public class Ligne extends Forme {

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
	public Ligne(int[] dims, int id) {
		super(SousForme.LIGNE, dims, id);
	}

	@Override
	public void dessinerForme(Graphics g) {
		g.drawLine(dims[0], dims[1], dims[2], dims[3]);
	}

}
