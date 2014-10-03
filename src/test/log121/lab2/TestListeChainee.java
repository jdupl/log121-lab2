package test.log121.lab2;

import main.log121.lab2.utils.ListeChainee;

import org.junit.Assert;
import org.junit.Test;

public class TestListeChainee {

	@Test
	public void testObtenirElement() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouterFin("0");
		liste.ajouterFin("1");
		liste.ajouterFin("2");
		liste.ajouterFin("3");

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
		liste.ajouterFin("0");
		liste.ajouterFin("1");
		liste.ajouterFin("2");
		liste.ajouterFin("3");

		Assert.assertEquals(0, liste.obtenirIndex("0"));
		Assert.assertEquals(3, liste.obtenirIndex("3"));
		Assert.assertEquals(-1, liste.obtenirIndex("bob"));
	}

	@Test
	public void testRemplacerParIndex() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouterFin("0");
		liste.ajouterFin("1");
		liste.ajouterFin("2");
		liste.ajouterFin("3");

		Assert.assertTrue(liste.remplacer(0, "00"));
		Assert.assertEquals(0, liste.obtenirIndex("00"));

		Assert.assertTrue(liste.remplacer(2, "22"));
		Assert.assertEquals(2, liste.obtenirIndex("22"));

		Assert.assertFalse(liste.remplacer(-1, ""));
	}

	@Test
	public void testEchangerParIndex() {
		ListeChainee<String> liste = new ListeChainee<>();
		liste.ajouterFin("0");
		liste.ajouterFin("1");
		liste.ajouterFin("2");
		liste.ajouterFin("3");

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
		liste.ajouterFin("0");
		liste.ajouterFin("1");
		liste.ajouterFin("2");
		liste.ajouterFin("3");

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
}