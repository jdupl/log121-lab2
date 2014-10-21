/******************************************************
 Cours:  LOG121
 Projet: Lab02
 Nom du fichier: TestListeChaineeIterateur.java
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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import main.log121.lab2.utils.ListeChainee;

import org.junit.Test;

public class TestListeChaineeIterateur {

	@Test
	public void testHasNext() {
		ListeChainee<Integer> liste = new ListeChainee<>();
		assertFalse(liste.iterator().hasNext());
		liste.ajouter(1);
		Iterator<Integer> ite = liste.iterator();
		assertTrue(ite.hasNext());
	}

	@Test
	public void testNext() {
		ListeChainee<Integer> liste = new ListeChainee<>();
		liste.ajouter(1);
		liste.ajouter(2);
		liste.ajouter(3);
		Iterator<Integer> ite = liste.iterator();
		assertTrue(ite.next() == 1);
		assertTrue(ite.next() == 2);
		assertTrue(ite.next() == 3);
		assertFalse(ite.hasNext());
	}
}
