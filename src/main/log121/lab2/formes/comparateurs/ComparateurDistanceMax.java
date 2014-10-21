/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: ComparateurDistanceMax.java
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

public class ComparateurDistanceMax extends AbstractComparateur {

	@Override
	public int compare(AbstractForme forme1, AbstractForme forme2) {
		return inverserSiNecessaire((int) (forme1.getDistanceMaximale() - forme2.getDistanceMaximale()));
	}

}
