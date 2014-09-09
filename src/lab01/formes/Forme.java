package lab01.formes;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Forme {

	protected int id;
	protected SousForme sousForme;
	protected int[] dims;

	public Forme(SousForme sousForme, int[] dims, long id) {
		this.sousForme = sousForme;
		this.dims = dims;
	}

	public abstract void dessiner(Graphics g);

	protected Color getCouleur() {
		return sousForme.couleur;
	}
}
