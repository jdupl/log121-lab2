package main.log121.lab2.utils;

public class Trieur {

	public Trieur(){
		int[] test = {0,6,2,8,2,0,10,9,0,0};
		print(test);
		Quicksort(test, 0, 9);
		print(test);
	}
	
	//https://www.cs.duke.edu/~reif/courses/alglectures/skiena.lectures/lecture5.pdf page:5
	//Quicksort(A as array, low as int, high as int)
	// 	if (low < high)
	//        pivot_location = Partition(A,low,high)
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
	public void Quicksort(int[] array, int low, int high) {
		if(low < high){
			int pivotLocation = Partition(array, low, high);
			Quicksort(array, low, pivotLocation - 1);
			Quicksort(array, pivotLocation + 1, high);
		}
	}
	
	public int Partition(int[] array, int low, int high) {
		int pivot = array[low];
		int leftWall = low;
		
		for(int i = low + 1; i <= high; i++) {
			if(array[i] < pivot){
				leftWall++;
				swap(array, i, leftWall);
			}
		}
		
		swap(array, low, leftWall);
		
		return leftWall;
	}
	
	public void swap(int[] array, int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
	
	public void print(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+",");
		}
		System.out.println();
	}

}
