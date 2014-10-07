package main.log121.lab2.utils;

import main.log121.lab2.formes.Forme;
import main.log121.lab2.formes.comparateurs.Comparateur;

public class Trieur {

	private Comparateur comparateur;

	/**
	 * Constructeur
	 */
	public Trieur(Comparateur comparateur) {
		this.comparateur = comparateur;
	}

	public ListeChainee<Forme> Sort(ListeChainee<Forme> liste) {
		Quicksort(liste, 0, liste.getTaille());
		return liste;
	}

	private void Quicksort(ListeChainee<Forme> liste, int bas, int haut) {
		if (bas < haut) {
			int pivotLocation = Partition(liste, bas, haut);
			Quicksort(liste, bas, pivotLocation);
			Quicksort(liste, pivotLocation + 1, haut);
		}
	}

	private int Partition(ListeChainee<Forme> liste, int bas, int haut) {
		//int pivot = liste[bas];
		Forme pivot = liste.obtenirElement(bas);
		int murGauche = bas;

		for (int i = bas + 1; i < haut; i++) {
			// TODO Ameliorer les IF
			//if (liste[i] < pivot) {
			if (comparateur.compare(liste.obtenirElement(i), pivot) < 0) {
				murGauche++;
				liste.echanger(i, murGauche);
			}
		}

		liste.echanger(bas, murGauche);

		return murGauche;
	}

	private void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	//https://www.cs.duke.edu/~reif/courses/alglectures/skiena.lectures/lecture5.pdf page:5
	//Quicksort(A as array, low as int, high as int)
	// 	if (low < high)
	//      pivot_location = Partition(A,low,high)
	//    	Quicksort(A,low, pivot_location - 1)
	//    	Quicksort(A, pivot_location + 1, high)
	//
	//Partition(A as array, low as int, high as int)
	//    pivot = A[low]
	//    leftwall = low
	//
	//    for i = low + 1 to high
	//        if (A[i] < pivot) then
	//            leftwall = leftwall + 1
	//            swap(A[i], A[leftwall])
	//
	//    swap(A[low],A[leftwall])
	//
	//    return (leftwall)
	/*private int[] Quicksort(int[] liste, int bas, int haut) {
		if(bas < haut) {
			int pivotLocation = PartitionC(liste, bas, haut);
			Quicksort(liste, bas, pivotLocation);
			Quicksort(liste, pivotLocation + 1, haut);
		}
		return liste.clone();
	}
	
	private int Partition(int[] liste, int bas, int haut) {
		int pivot = liste[bas];
		int murGauche = bas;
		
		for(int i = bas + 1; i < haut; i++) {
			if(liste[i] < pivot) {
				murGauche++;
				swap(liste, i, murGauche);
			}
		}
		
		swap(liste, bas, murGauche);
		
		return murGauche;
	}*/

}
