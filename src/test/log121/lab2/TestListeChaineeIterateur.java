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
		liste.ajouterFin(1);
		Iterator<Integer> it = liste.iterator();
		assertTrue(it.hasNext());
	}

	@Test
	public void testNext() {
		ListeChainee<Integer> liste = new ListeChainee<>();
		liste.ajouterFin(1);
		liste.ajouterFin(2);
		liste.ajouterFin(3);
		Iterator<Integer> it = liste.iterator();
		assertTrue(it.next() == 1);
		assertTrue(it.next() == 2);
		assertTrue(it.next() == 3);
		assertFalse(it.hasNext());
	}
}
