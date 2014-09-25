package lab01.formes;

import java.awt.Graphics;

public class Ovale extends Forme {

	public Ovale(SousForme sousForme, int[] dims, int id) {
		super(sousForme, dims, id);
	}

	@Override
	public void dessinerForme(Graphics g) {
		g.fillOval(dims[0], dims[1], dims[2], dims[3]);
	}

}
