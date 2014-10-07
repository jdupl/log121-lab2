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
			public int compare(Double o1, Double o2) {
				return (int) (o1 - o2);
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
			public int compare(Double o1, Double o2) {
				return (int) (o2 - o1);
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
