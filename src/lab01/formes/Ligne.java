package lab01.formes;

import java.awt.Graphics;

public class Ligne extends Forme {

	public Ligne(int[] dims, int id) {
		super(SousForme.LIGNE, dims, id);
	}

	@Override
	public void dessinerForme(Graphics g) {
		g.drawLine(dims[0], dims[1], dims[2], dims[3]);
	}

}
