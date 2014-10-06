package test.log121.lab2;

import static org.junit.Assert.*;
import main.log121.lab2.utils.Trieur;

import org.junit.Test;

public class TestTrieur {

	@Test
	public void testCroissant() {
		Trieur trieur = new Trieur();

		int[] test = { 0, 6, 2, 8, 2, 0, 10, 9, 0, 0 };
		int[] expected = { 0, 0, 0, 0, 2, 2, 6, 8, 9, 10 };
		int[] result = trieur.Sort(test, Trieur.ORDRE_CROISSANT);

		assertArrayEquals(expected, result);
	}

	@Test
	public void testDecroissant() {
		Trieur trieur = new Trieur();

		int[] test = { 0, 5, 9, 7, 3, 0, 0, 5, 4, 1 };
		int[] expected = { 9, 7, 5, 5, 4, 3, 1, 0, 0, 0 };
		int[] result = trieur.Sort(test, Trieur.ORDRE_DECROISSANT);

		assertArrayEquals(expected, result);
	}
}
