package lab01.formes;

import java.awt.Graphics;

public class Rectangle extends Forme {

	public Rectangle(SousForme sousForme, int[] dims, long id) {
		super(sousForme, dims, id);
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(getCouleur());
		int deltaX = dims[2] - dims[0] ;
		int deltaY = dims[3] - dims[1];
		g.fillRect(dims[0], dims[1], deltaX, deltaY);
	}

}
