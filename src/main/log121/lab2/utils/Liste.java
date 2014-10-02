package main.log121.lab2.utils;

public interface Liste<T> {

	public boolean estVide();

	public int getTaille();
	
	public boolean ajouter(T element);
	
	public boolean ajouter(int indice, T element);
}
