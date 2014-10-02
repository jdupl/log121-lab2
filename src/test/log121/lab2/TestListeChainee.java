package test.log121.lab2;

import static org.junit.Assert.*;
import main.log121.lab2.utils.ListeChainee;

import org.junit.Test;

public class TestListeChainee {

	@Test
	public void test() {
		ListeChainee<Integer> liste = new ListeChainee<>();
		liste.ajouterFin(1);
		liste.ajouterFin(2);
		liste.ajouterFin(3);
	}
}
