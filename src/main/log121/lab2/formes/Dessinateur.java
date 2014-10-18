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

		// Le point x,y de départ
		int point = 0;

		for (Forme forme : formes) {
			g.setColor(forme.getCouleur());
			g.setStroke(new BasicStroke());

			switch(forme.sousForme) {
			case CARRE:
			case RECTANGLE:
				Rectangle rect = (Rectangle) forme;
				g.fillRect(point, point, rect.largeur, rect.hauteur);
				break;
			case CERCLE:
			case OVALE:
				Ovale ovale = (Ovale) forme;
				g.fillOval(point, point, ovale.getLargeur(), ovale.getHauteur());
				break;
			case LIGNE:
				Ligne ligne = (Ligne) forme;
				g.drawLine(point, point, (point+ ligne.getLargeur()), (point + ligne.getHauteur()));
				break;
			default:
				break;
			}

			g.setColor(Color.GRAY);
			g.setStroke(new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1f, new float[] { 2f }, 0f));
			g.drawRect(point, point, forme.getLargeur(), forme.getHauteur());
			point += 40;
		}
	}
}
