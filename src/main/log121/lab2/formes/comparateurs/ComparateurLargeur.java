/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: ComparateurLargeur.java
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

import main.log121.lab2.formes.AbstractForme;

public class ComparateurLargeur extends AbstractComparateur {

	public ComparateurLargeur() {
		super(false);
	}

	public ComparateurLargeur(boolean decroissant) {
		super(decroissant);
	}

	@Override
	public int compare(AbstractForme fo1, AbstractForme fo2) {
		return inverserSiNecessaire((int) (fo1.getLargeur() - fo2.getLargeur()));
	}

}