package main.log121.lab2.utils;

public class Trieur {
	
	public static final int ORDRE_CROISSANT = 1;
	public static final int ORDRE_DECROISSANT = 2;

	/**
	 * Constructeur
	 */
	public Trieur(){
		
	}
	
	public int[] Sort(int[] liste, int ordre) {
		if(ordre == ORDRE_CROISSANT)
			QuicksortC(liste, 0, liste.length);
		else if(ordre == ORDRE_DECROISSANT)
			QuicksortD(liste, 0, liste.length);
		return liste;
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
	private int[] QuicksortC(int[] liste, int bas, int haut) {
		if(bas < haut) {
			int pivotLocation = PartitionC(liste, bas, haut);
			QuicksortC(liste, bas, pivotLocation);
			QuicksortC(liste, pivotLocation + 1, haut);
		}
		return liste.clone();
	}
	
	private int PartitionC(int[] liste, int bas, int haut) {
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
	}
	
	private int[] QuicksortD(int[] liste, int bas, int haut) {
		if(bas < haut) {
			int pivotLocation = PartitionD(liste, bas, haut);
			QuicksortD(liste, bas, pivotLocation);
			QuicksortD(liste, pivotLocation + 1, haut);
		}
		return liste.clone();
	}
	
	private int PartitionD(int[] liste, int bas, int haut) {
		int pivot = liste[bas];
		int murGauche = bas;
		
		for(int i = bas + 1; i < haut; i++) {
			if(liste[i] > pivot) {
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
	
	/*public void print(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println();
	}*/

}
