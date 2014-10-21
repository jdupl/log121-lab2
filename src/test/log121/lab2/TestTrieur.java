/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: TestTrieur.java
 Date créé: 2014-10-20
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Justin Duplessis
 *@author Alexandre Viau
 *@author Samuel Lague
 2014-10-20 Version initiale
 *******************************************************/

package test.log121.lab2;

import java.util.Comparator;

import main.log121.lab2.utils.ListeChainee;

import org.junit.Assert;
import org.junit.Test;

public class TestTrieur {

	@Test
	public void testCroissant() {
		ListeChainee<Double> actual = new ListeChainee<>();
		actual.ajouter(new Double(0));
		actual.ajouter(new Double(1));
		actual.ajouter(new Double(2));
		actual.ajouter(new Double(3));
		actual.ajouter(new Double(4));
		actual.ajouter(new Double(5));
		actual.ajouter(new Double(6));
		actual.ajouter(new Double(7));
		actual.ajouter(new Double(8));
		actual.ajouter(new Double(0));

		actual.trier(new Comparator<Double>() {

			@Override
			public int compare(Double oe1, Double oe2) {
				return (int) (oe1 - oe2);
			}
		});

		ListeChainee<Double> expected = new ListeChainee<>();
		expected.ajouter(new Double(0));
		expected.ajouter(new Double(0));
		expected.ajouter(new Double(1));
		expected.ajouter(new Double(2));
		expected.ajouter(new Double(3));
		expected.ajouter(new Double(4));
		expected.ajouter(new Double(5));
		expected.ajouter(new Double(6));
		expected.ajouter(new Double(7));
		expected.ajouter(new Double(8));

		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testDecroissant() {
		ListeChainee<Double> actual = new ListeChainee<>();
		actual.ajouter(new Double(0));
		actual.ajouter(new Double(1));
		actual.ajouter(new Double(2));
		actual.ajouter(new Double(3));
		actual.ajouter(new Double(4));
		actual.ajouter(new Double(5));
		actual.ajouter(new Double(6));
		actual.ajouter(new Double(7));
		actual.ajouter(new Double(8));
		actual.ajouter(new Double(0));

		actual.trier(new Comparator<Double>() {

			@Override
			public int compare(Double oe1, Double oe2) {
				return (int) (oe2 - oe1);
			}
		});

		ListeChainee<Double> expected = new ListeChainee<>();
		expected.ajouter(new Double(8));
		expected.ajouter(new Double(7));
		expected.ajouter(new Double(6));
		expected.ajouter(new Double(5));
		expected.ajouter(new Double(4));
		expected.ajouter(new Double(3));
		expected.ajouter(new Double(2));
		expected.ajouter(new Double(1));
		expected.ajouter(new Double(0));
		expected.ajouter(new Double(0));

		Assert.assertEquals(expected, actual);
	}

}
