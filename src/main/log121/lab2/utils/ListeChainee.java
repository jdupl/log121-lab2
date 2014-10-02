package main.log121.lab2.utils;

import java.util.Iterator;

public class ListeChainee<T> implements Liste<T> {

	private Element<T> debut;
	private Element<T> fin;
	private int taille;

	@Override
	public boolean ajouterDebut(T element) {
		// TODO
		return false;
	}

	@Override
	public boolean ajouterFin(T element) {
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
	public boolean echanger(int indexElement1, int indexElement2) {
		// TODO
		return false;
	}

	@Override
	public boolean echanger(T element1, T element2) {
		// TODO
		return false;
	}

	@Override
	public boolean estVide() {
		return debut == null;
	}

	@Override
	public int getTaille() {
		return this.taille;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {
			/**
			 * Le dernier élément visité
			 */
			private Element<T> position;

			@Override
			public boolean hasNext() {
				boolean prochain = false;
				if (this.position == null) {
					prochain = ListeChainee.this.debut != null;
				} else {
					prochain = this.position.getSuivant() != null;
				}
				return prochain;
			}

			@Override
			public T next() {
				if (this.position == null) {
					this.position = ListeChainee.this.debut;
				} else {
					this.position = this.position.getSuivant();
				}
				return this.position.getCourant();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Cette fonctionnalité n'est pas implémentée.");
			}
		};
		return it;
	}

	@Override
	public T obtenirElement(int index) {
		// TODO
		return null;
	}

	@Override
	public int obtenirIndex(T element) {
		// TODO
		return 0;
	}

	@Override
	public boolean remplacer(int index, T nouvelElement) {
		// TODO
		return false;
	}

}
