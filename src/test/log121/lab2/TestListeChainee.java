/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: TesTListeChainee.java
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

import main.log121.lab2.utils.ListeChainee;

import org.junit.Assert;
import org.junit.Test;

public class TestListeChainee {

	@Test
	public void testObtenirElement() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		Assert.assertEquals("0", liste.obtenirElement(0));
		Assert.assertEquals("1", liste.obtenirElement(1));
		Assert.assertEquals("3", liste.obtenirElement(3));
		Assert.assertNull(liste.obtenirElement(4));
		Assert.assertNull(liste.obtenirElement(10));
		Assert.assertNull(liste.obtenirElement(-1));
	}

	@Test
	public void testObtenirIndex() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		Assert.assertEquals(0, liste.obtenirIndex("0"));
		Assert.assertEquals(3, liste.obtenirIndex("3"));
		Assert.assertEquals(-1, liste.obtenirIndex("bob"));
	}

	@Test
	public void testRemplacerParIndex() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		Assert.assertTrue(liste.remplacer(0, "00"));
		Assert.assertEquals(0, liste.obtenirIndex("00"));

		Assert.assertTrue(liste.remplacer(2, "22"));
		Assert.assertEquals(2, liste.obtenirIndex("22"));

		Assert.assertFalse(liste.remplacer(-1, ""));
	}

	@Test
	public void testEchangerParIndex() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		Assert.assertTrue(liste.echanger(0, 1));
		Assert.assertEquals(1, liste.obtenirIndex("0"));
		Assert.assertEquals(0, liste.obtenirIndex("1"));

		Assert.assertTrue(liste.echanger(0, 1));
		Assert.assertEquals(0, liste.obtenirIndex("0"));
		Assert.assertEquals(1, liste.obtenirIndex("1"));

		Assert.assertTrue(liste.echanger(1, 3));
		Assert.assertEquals(1, liste.obtenirIndex("3"));
		Assert.assertEquals(3, liste.obtenirIndex("1"));

		Assert.assertFalse(liste.echanger(-1, 3));
	}

	@Test
	public void testEchangerParObjet() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		Assert.assertTrue(liste.echanger("0", "1"));
		Assert.assertEquals(1, liste.obtenirIndex("0"));
		Assert.assertEquals(0, liste.obtenirIndex("1"));

		Assert.assertTrue(liste.echanger("0", "1"));
		Assert.assertEquals(0, liste.obtenirIndex("0"));
		Assert.assertEquals(1, liste.obtenirIndex("1"));

		Assert.assertTrue(liste.echanger("1", "3"));
		Assert.assertEquals(1, liste.obtenirIndex("3"));
		Assert.assertEquals(3, liste.obtenirIndex("1"));

		Assert.assertFalse(liste.echanger("-1", "3"));
	}

	@Test
	public void testEnleverPremier() {
		ListeChainee<String> expected = new ListeChainee<>();
		expected.ajouter("1");
		expected.ajouter("2");
		expected.ajouter("3");

		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouter("0");
		liste.ajouter("1");
		liste.ajouter("2");
		liste.ajouter("3");

		liste.enleverPremier();
	}
}