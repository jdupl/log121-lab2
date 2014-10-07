package main.log121.lab2.utils;

import java.util.Comparator;

public interface Liste<T> extends Iterable<T> {

	public boolean ajouter(T element);

	public boolean echanger(int indexElement1, int indexElement2);

	public boolean echanger(T element1, T element2);

	public boolean estVide();

	public int getTaille();

	public T obtenirElement(int index);

	public int obtenirIndex(T element);

	public boolean remplacer(int index, T nouvelElement);

	public void trier(Comparator<T> comparateur);

	public void enleverPremier();

}
