package main.lab01.utils;

public class Element<T> {

	private T courant;
	private Element<T> suivant;

	public Element(T courant, Element<T> suivant) {
		this.courant = courant;
		this.suivant = suivant;
	}

	public Element(T courant) {
		this.courant = courant;
	}

	public T getCourant() {
		return courant;
	}

	public void setCourant(T courant) {
		this.courant = courant;
	}

	public Element<T> getSuivant() {
		return suivant;
	}

	public void setSuivant(Element<T> suivant) {
		this.suivant = suivant;
	}

}
