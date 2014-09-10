package lab01.formes;

import java.awt.Graphics;

public class Rectangle extends Forme {

	public Rectangle(SousForme sousForme, int[] dims, long id) {
		super(sousForme, dims, id);
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(getCouleur());
		g.drawRect(dims[0], dims[1], dims[2], dims[3]);
	}

}
