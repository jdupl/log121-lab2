package main.log121.lab2.utils;

public class Trieur {

	public static final int ORDRE_CROISSANT = 1;
	public static final int ORDRE_DECROISSANT = 2;

	/**
	 * Constructeur
	 */
	public Trieur() {

	}

	public int[] Sort(int[] liste, int ordre) {
		Quicksort(liste, 0, liste.length, ordre);
		return liste;
	}

	private int[] Quicksort(int[] liste, int bas, int haut, int ordre) {
		if (bas < haut) {
			int pivotLocation = Partition(liste, bas, haut, ordre);
			Quicksort(liste, bas, pivotLocation, ordre);
			Quicksort(liste, pivotLocation + 1, haut, ordre);
		}
		return liste.clone();
	}

	private int Partition(int[] liste, int bas, int haut, int ordre) {
		int pivot = liste[bas];
		int murGauche = bas;

		for (int i = bas + 1; i < haut; i++) {
			// TODO Ameliorer les IF
			if (liste[i] < pivot && ordre == ORDRE_CROISSANT) {
				murGauche++;
				swap(liste, i, murGauche);
			}
			if (liste[i] > pivot && ordre == ORDRE_DECROISSANT) {
				murGauche++;
				swap(liste, i, murGauche);
			}
		}

		swap(liste, bas, murGauche);

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
