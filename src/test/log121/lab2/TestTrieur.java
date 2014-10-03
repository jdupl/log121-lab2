package test.log121.lab2;

import static org.junit.Assert.*;
import main.log121.lab2.utils.Trieur;

import org.junit.Test;

public class TestTrieur {

	@Test
	public void test() {
		Trieur trieur = new Trieur();
		
		int[] test = {0,6,2,8,2,0,10,9,0,0};
		int[] expected = {0,0,0,0,2,2,6,8,9,10};
		int[] result = trieur.Quicksort(test, 0, 9);
		
		assertArrayEquals(expected,result);
	}
	
	@Test
	public void test2() {
		Trieur trieur = new Trieur();
		
		int[] test = {0,5,9,7,3,0,0,5,4,1};
		int[] expected = {0,0,0,1,3,4,5,5,7,9};
		int[] result = trieur.Quicksort(test, 0, 9);
		
		assertArrayEquals(expected, result);
	}
}
