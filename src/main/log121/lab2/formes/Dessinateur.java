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

	public void dessiner(ListeChainee<Forme> formes, Graphics2D g) {

		for (Forme forme : formes) {
			g.setColor(forme.getCouleur());
			g.setStroke(new BasicStroke());

			switch(forme.sousForme) {
			case CARRE:
			case RECTANGLE:
				Rectangle rect = (Rectangle) forme;
				g.fillRect(rect.coinX, rect.coinY, rect.largeur, rect.hauteur);
				break;
			case CERCLE:
			case OVALE:
				Ovale ovale = (Ovale) forme;
				g.fillOval(ovale.coinX, ovale.coinY, ovale.getLargeur(), ovale.getHauteur());
				break;
			case LIGNE:
				Ligne ligne = (Ligne) forme;
				g.drawLine(ligne.dims[0], ligne.dims[1], ligne.dims[2], ligne.dims[3]);
				break;
			default:
				break;
			}

			g.setColor(Color.GRAY);
			g.setStroke(new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1f, new float[] { 2f }, 0f));
			g.drawRect(forme.coinX, forme.coinY, forme.getLargeur(), forme.getHauteur());

		}
	}
}
