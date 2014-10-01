package test;

import static org.junit.Assert.*;
import main.lab01.utils.ListeChainee;

import org.junit.Test;

public class TestListeChainee {

	@Test
	public void test() {
		ListeChainee<Integer> liste = new ListeChainee<>();
		liste.ajouter(1);
		liste.ajouter(2);
		liste.ajouter(3);
	}
}
