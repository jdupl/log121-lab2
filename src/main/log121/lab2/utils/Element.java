/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: Element.java
 Date créé: 2014-10-20
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 *@author Alexandre Viau
 *@author Samuel Lague
 2014-10-20 Version initiale
 *******************************************************/

package main.log121.lab2.utils;

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
