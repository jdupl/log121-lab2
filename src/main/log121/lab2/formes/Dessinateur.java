/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: Dessinateur.java
 Date créé: 2014-10-20
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 *@author Alexandre Viau
 *@author Samuel Lague
 2014-10-20 Version initiale
 *******************************************************/

package main.log121.lab2.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import main.log121.lab2.utils.ListeChainee;

/**
 * Permet de dessiner une liste de formes dans un Graphics.
 *
 * @author Alexandre Viau
 *
 */
public class Dessinateur {

	public Dessinateur() {}

	/**
	 *
	 * @param formes La liste de formes a dessiner
	 * @param gra Le grapics sur leuqel dessiner
	 * @param decale Ajoute un décalé de 40px entre chaque forme
	 */
	public void dessiner(ListeChainee<AbstractForme> formes, Graphics2D gra, boolean decale) {

		// Le point x,y de départ
		int coinX = 0;
		int coinY = 0;

		for (AbstractForme forme : formes) {

			if (decale == false){
				coinX = forme.coinX;
				coinY = forme.coinY;
			}

			gra.setColor(forme.getCouleur());
			gra.setStroke(new BasicStroke());

			switch(forme.sousForme) {
			case CARRE:
			case RECTANGLE:
				Rectangle rect = (Rectangle) forme;
				gra.fillRect(coinX, coinY, rect.largeur, rect.hauteur);
				break;
			case CERCLE:
			case OVALE:
				Ovale ovale = (Ovale) forme;
				gra.fillOval(coinX, coinY, ovale.getLargeur(), ovale.getHauteur());
				break;
			case LIGNE:
				Ligne ligne = (Ligne) forme;
				gra.drawLine(coinX, coinY, coinX + ligne.getLargeur(), coinY + ligne.getHauteur());
				break;
			default:
				break;
			}

			gra.setColor(Color.GRAY);
			gra.setStroke(new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1f, new float[] { 2f }, 0f));
			gra.drawRect(coinX, coinY, forme.getLargeur(), forme.getHauteur());

			// On incrémente le point de départ
			coinX += 40;
			coinY += 40;
		}
	}
}
