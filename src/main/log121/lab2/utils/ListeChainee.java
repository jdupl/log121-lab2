package main.log121.lab2.utils;

import java.util.Comparator;
import java.util.Iterator;

public class ListeChainee<T> implements Liste<T> {

	private Element<T> debut;
	private Element<T> fin;
	private int taille;
	private int tailleMaximum;

	public ListeChainee() {
		this.tailleMaximum = 10;
	}

	public ListeChainee(int tailleMaximum) {
		this.tailleMaximum = tailleMaximum;
	}

	@Override
	public boolean ajouter(T element) {
		Element<T> ajout = new Element<T>(element);
		if (debut != null) {
			fin.setSuivant(ajout);
		} else {
			debut = ajout;
		}
		fin = ajout;
		this.taille++;
		if (taille > tailleMaximum) {
			enleverPremier();
		}
		return false;
	}

	@Override
	public boolean echanger(int indexElement1, int indexElement2) {
		boolean success = false;
		// Validation des index pour la performance si invalide
		if (indexValide(indexElement1) && indexValide(indexElement2)) {
			T element1 = this.obtenirElement(indexElement1);
			T element2 = this.obtenirElement(indexElement2);
			success = echanger(element1, indexElement1, element2, indexElement2);
		}
		return success;
	}

	@Override
	public boolean echanger(T element1, T element2) {
		int indexElement1 = this.obtenirIndex(element1);
		int indexElement2 = this.obtenirIndex(element2);
		return echanger(element1, indexElement1, element2, indexElement2);
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
	public T obtenirElement(int index) {
		T obj = null;
		if (this.debut != null && indexValide(index)) {
			boolean trouve = false;
			int courant = 0;
			Iterator<T> ite = this.iterator();
			while (!trouve && ite.hasNext()) {
				obj = ite.next();
				trouve = index == courant++;
			}
		}
		return obj;
	}

	@Override
	public int obtenirIndex(T element) {
		int index = -1;
		boolean trouve = false;
		if (!this.estVide()) {
			Iterator<T> ite = this.iterator();
			while (!trouve && ite.hasNext()) {
				T ele = ite.next();
				trouve = ele.equals(element);
				index++;
			}
		}
		return trouve ? index : -1;
	}

	@Override
	public boolean remplacer(int index, T nouvelElement) {
		boolean trouve = false;
		if (this.debut != null && indexValide(index)) {
			int courant = 0;
			Element<T> elementCourant = debut;
			while (!trouve && elementCourant != null) {
				trouve = index == courant++;
				if (trouve) {
					elementCourant.setCourant(nouvelElement);
				} else {
					elementCourant = elementCourant.getSuivant();
				}
			}
		}
		return trouve;
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> ite = new Iterator<T>() {
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
		return ite;
	}

	private boolean indexValide(int index) {
		return index < this.getTaille() && index > -1;
	}

	public void trier(Comparator<T> comparateur) {
		quicksort(0, getTaille(), comparateur);
	}

	// https://www.cs.duke.edu/~reif/courses/alglectures/skiena.lectures/lecture5.pdf page:5
	private void quicksort(int bas, int haut, Comparator<T> comparateur) {
		if (bas < haut) {
			int pivotLocation = partition(bas, haut, comparateur);
			quicksort(bas, pivotLocation, comparateur);
			quicksort(pivotLocation + 1, haut, comparateur);
		}
	}

	private int partition(int bas, int haut, Comparator<T> comparateur) {
		// int pivot = liste[bas];
		T pivot = obtenirElement(bas);
		int murGauche = bas;

		for (int i = bas + 1; i < haut; i++) {
			// TODO Ameliorer les IF
			// if (liste[i] < pivot) {
			if (comparateur.compare(obtenirElement(i), pivot) < 0) {
				murGauche++;
				echanger(i, murGauche);
			}
		}

		echanger(bas, murGauche);

		return murGauche;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ListeChainee) {
			ListeChainee<T> autreListe = (ListeChainee<T>) obj;
			for (T element : this) {
				int index = this.obtenirIndex(element);
				int autreIndex = autreListe.obtenirIndex(element);
				if (index != autreIndex) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public void enleverPremier() {
		if (this.debut != null) {
			this.debut = debut.getSuivant();
			taille--;
		}
	}
}
