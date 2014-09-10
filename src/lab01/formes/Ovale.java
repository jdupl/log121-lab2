package lab01.formes;

import java.awt.Graphics;

public class Ovale extends Forme {

	public Ovale(SousForme sousForme, int[] dims, long id) {
		super(sousForme, dims, id);
	}

	@Override
	public void dessiner(Graphics g) {
		g.setColor(getCouleur());
		g.drawOval(dims[0], dims[1], dims[2], dims[3]);
	}

}
