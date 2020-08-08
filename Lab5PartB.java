import java.util.Arrays;
import java.util.Scanner;

public class Lab5PartB {
	
	public static void main(String[] args) {
		Lab5PartB heap = new Lab5PartB(); // Creates an object called heap
				
		int n = 10; // Instantiate variable for desired length of array
						
		int[] a = new int[n]; // Create array with desired length
		
		for (int i = 0; i < n ; i++) { // Add random generated numbers from the range -100 to 100 into the array
			int randNum = -100 + (int)(Math.random() * (100 - -100) + 1);
			a[i] = randNum;
		}
		
		System.out.println("The random generated array with size of 10 is: " + Arrays.toString(a));
		
		heap.heap_Sort(a);
		
		System.out.println("The sorted random generated array with size of 10 is: " + Arrays.toString(a));
		
	}
	
	public void build_MaxHeap(int[] a) { // Build Max heap function. Only takes in the passed array as a parameter
		Lab5PartB heap = new Lab5PartB(); // Creates an object called heap
		
		int arrLength = 0; // Instantiates the variable for array length
		
		arrLength = a.length; // Gets the length of the array and saves it into a variable
		
		for (int i = arrLength / 2; i >= 0; i--) {
			heap.max_Heapify(a, i , arrLength); // Calls Max Heapify function and passes in the array, index, and length
		}
		
	}
	
	public void max_Heapify(int[] a, int i, int arrLength) {
		Lab5PartB heap = new Lab5PartB(); // Create an object called heap
		
		int leftIdx = 2*i + 1; // Finds the index of the left child and the parent is index i
		
		int rightIdx = 2*i + 2; // Finds the index of the right child and the parent is index i
		
		int midIdx = i; // Index of the parent
		
		if (leftIdx < arrLength && a[leftIdx] > a[midIdx]) { // Compares if the left child is greater than the parent
			midIdx = leftIdx;
		}
		if (rightIdx < arrLength && a[rightIdx] > a[midIdx]) {
			midIdx = rightIdx;
		}
		if (midIdx != i) {
			// Call swap helper method to switch the element at index i and the mid element
			heap.swap(a, i, midIdx);
			heap.max_Heapify(a, midIdx, arrLength);
		}
		
	}
	
	public void heap_Sort(int[] a) {
		Lab5PartB heap = new Lab5PartB(); // Creates an object called heap
		
		heap.build_MaxHeap(a); // Calls the build function
		
		int arrLength = a.length - 1; // Sets current array length - 1
		
		for (int i = arrLength; i > 0; i--) { // Iterates through the array
			// Call swap method to switch first element and the element at the current index
			heap.swap(a, 0, i);
			heap.max_Heapify(a, 0, i); // Calls max heapify
		}
		
	}
	
	// Helper method to swap two elements in the array
	public void swap(int[] a, int x, int y) { 
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		
	}
	
}
