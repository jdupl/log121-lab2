package main.log121.lab2;

/******************************************************
 Cours:  LOG121
 Projet: Lab01
 Nom du fichier: FormeListe.java
 Date créé: 2014-09-09
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 2014-09-09 Version initiale
 *******************************************************/

import main.log121.lab2.formes.Forme;

/**
 * Classe qui contient les formes à conserver en mémoire. Imite le comportement d'une CircularFifoQueue de manière très
 * simple.
 * 
 * @author Justin Duplessis
 *
 */
public class FormeListe {

	private int nbFormes;
	private Forme[] listeDeFormes = null;

	/**
	 * Constructeur qui instancie un tableau afin de contenir un certain nombre d'éléments.
	 * 
	 * @param nbFormes
	 *            Le nombre de formes à contenir au maximum.
	 */
	public FormeListe(int nbFormes) {
		this.nbFormes = nbFormes;
		listeDeFormes = new Forme[nbFormes];
	}

	/**
	 * Ajoute un élément au début de la fille. "Déplace" les autres instances de Formes vers la fin et supprime le
	 * dernier élément si le tableau est plein.
	 * 
	 * @param forme
	 *            La nouvelle forme.
	 * @return L'instance du nouveau tableau
	 */
	public Forme[] ajouter(Forme forme) {
		Forme[] nouvelleListe = new Forme[nbFormes];
		for (int i = 0; i < listeDeFormes.length - 1; i++) {
			nouvelleListe[i + 1] = listeDeFormes[i];
		}
		nouvelleListe[0] = forme;
		this.setListeDeFormes(nouvelleListe);
		return nouvelleListe;
	}

	public Forme[] getListeDeFormes() {
		return listeDeFormes;
	}

	private void setListeDeFormes(Forme[] listeDeFormes) {
		this.listeDeFormes = listeDeFormes;
	}

}
