package lab01.formes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public abstract class Forme {

	protected long id;
	protected SousForme sousForme;
	protected int[] dims;

	public Forme(SousForme sousForme, int[] dims, long id) {
		this.sousForme = sousForme;
		this.dims = dims;
		this.id = id;
	}

	public abstract void dessiner(Graphics g);

	protected Color getCouleur() {
		return sousForme.couleur;
	}

	@Override
	public String toString() {
		return "Forme [id=" + id + ", sousForme=" + sousForme + ", dims=" + Arrays.toString(dims) + "]";
	}
}
