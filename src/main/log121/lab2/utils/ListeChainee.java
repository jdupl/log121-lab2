package main.log121.lab2.utils;

public class ListeChainee<T> implements Liste<T> {

	private Element<T> debut;
	private Element<T> fin;
	private int taille;

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTaille() {
		return this.taille;
	}

	@Override
	public boolean ajouter(T element) {
		Element<T> e = new Element<T>(element);
		if (debut != null) {
			fin.setSuivant(e);
		} else {
			debut = e;
		}
		fin = e;
		this.taille++;
		return false;
	}

	@Override
	public boolean ajouter(int indice, T element) {
		// TODO Auto-generated method stub
		return false;
	}

}
