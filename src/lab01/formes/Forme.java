package lab01.formes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public abstract class Forme {

	protected int id;
	protected SousForme sousForme;
	protected int[] dims;

	public Forme(SousForme sousForme, int[] dims, int id) {
		this.sousForme = sousForme;
		this.dims = dims;
		this.id = id;
	}

	public void dessiner(Graphics g) {
		g.setColor(getCouleur());
		dessinerForme(g);
	}

	protected abstract void dessinerForme(Graphics g);

	protected Color getCouleur() {
		return sousForme.couleur;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Forme [id=" + id + ", sousForme=" + sousForme + ", dims=" + Arrays.toString(dims) + "]";
	}
}
