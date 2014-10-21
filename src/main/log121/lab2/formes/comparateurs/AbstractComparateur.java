/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: AbstractComparateur.java
 Date créé: 2014-10-20
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 *@author Alexandre Viau
 *@author Samuel Lague
 2014-10-20 Version initiale
 *******************************************************/

package main.log121.lab2.formes.comparateurs;

import java.util.Comparator;

import main.log121.lab2.formes.AbstractForme;

public abstract class AbstractComparateur implements Comparator<AbstractForme> {

	private boolean decroissant;

	public AbstractComparateur() {
		this.decroissant = false;
	}

	public AbstractComparateur(boolean decroissant) {
		this.decroissant = decroissant;
	}

	public boolean estDecroissant() {
		return decroissant;
	}

	public boolean estCroissant() {
		return !decroissant;
	}

	protected int inverserSiNecessaire(int diff) {
		return this.estDecroissant() ? -1 * diff : diff;
	}

}
