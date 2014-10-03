package main.log121.lab2.utils;

import java.util.Iterator;

public class ListeChainee<T> implements Liste<T> {

	private Element<T> debut;
	private Element<T> fin;
	private int taille;

	private boolean indexValide(int index) {
		return index < this.getTaille() && index > -1;
	}

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
		boolean success = false;
		if (indexValide(indexElement1) && indexValide(indexElement2)) { // Validation pour la performance si invalide
			success = echanger(this.obtenirElement(indexElement1), indexElement1, this.obtenirElement(indexElement2),
					indexElement2);
		}
		return success;
	}

	@Override
	public boolean echanger(T element1, T element2) {
		// TODO
		return false;
	}

	private boolean echanger(T element1, int indexElement1, T element2, int indexElement2) {
		return remplacer(indexElement1, element2) && remplacer(indexElement2, element1);
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
		T obj = null;
		if (this.debut != null && indexValide(index)) {
			boolean trouve = false;
			int i = 0;
			Iterator<T> it = this.iterator();
			while (!trouve && it.hasNext()) {
				obj = it.next();
				trouve = index == i++;
			}
		}
		return obj;
	}

	@Override
	public int obtenirIndex(T element) {
		int index = -1;
		boolean trouve = false;
		if (!this.estVide()) {
			Iterator<T> it = this.iterator();
			while (!trouve && it.hasNext()) {
				T e = it.next();
				trouve = e.equals(element);
				index++;
			}
		}
		return trouve ? index : -1;
	}

	@Override
	public boolean remplacer(int index, T nouvelElement) {
		boolean trouve = false;
		if (this.debut != null && indexValide(index)) {
			int i = 0;
			Element<T> elementCourant = debut;
			while (!trouve && elementCourant != null) {
				trouve = index == i++;
				if (trouve) {
					elementCourant.setCourant(nouvelElement);
				} else {
					elementCourant = elementCourant.getSuivant();
				}
			}
		}
		return trouve;
	}

}
