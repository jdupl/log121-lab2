package main.log121.lab2.utils;

public interface Liste<T> extends Iterable<T> {

	public boolean ajouterDebut(T element);

	public boolean ajouterFin(T element);

	public boolean echanger(int indexElement1, int indexElement2);

	public boolean echanger(T element1, T element2);

	public boolean estVide();

	public int getTaille();

	public T obtenirElement(int index);

	public int obtenirIndex(T element);

	public boolean remplacer(int index, T nouvelElement);

}
