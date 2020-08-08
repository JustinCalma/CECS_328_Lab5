import java.util.*;

public class Lab5PartA {
	
	public static void main(String[] args) {
		Lab5PartA heap = new Lab5PartA(); // Creates an object called heap
		Lab5PartA select = new Lab5PartA(); // Creates an object called select
		
		Scanner scnr = new Scanner(System.in); // Create Scanner object
		
		int n = 0; // Instantiate variable for desired length of array
		
		System.out.println("Enter a positive integer for the desired length of the array: "); // Ask user for input
		
		n = scnr.nextInt(); // Get input from user
		
		int[] a = new int[n]; // Create array with desired length
		
		int[] b = a.clone(); // Creates a clone of array a for selection sort

		long avgRunTimeHeap = 0; // Variable to save the average runtime per iteration for Heap Sort
		long avgRunTimeSelection = 0; // Variable to save the average runtime per iteration for Selection Sort
		
		for (int i = 0; i < 100; i++) { // Runs Heap Sort and Selection Sort 100 times to calculate average runtime 
			a = heap.createArrays(n); // Creates a new random generated array
			b = a.clone(); // Creates a clone of array a
						
			long startTimeHeap = System.nanoTime(); // Start timer for Heap Sort
			heap.heap_Sort(a); // Calls Heap Sort and sorts array a
			long endTimeHeap = System.nanoTime(); // End timer for Heap Sort
			
			long startTimeSelection = System.nanoTime(); // Start timer for Selection Sort
			select.selectionSort(b); // Calls Selection Sort and sorts array b
			long endTimeSelection = System.nanoTime(); // End timer for Selection Sort
			
			long durationHeap = endTimeHeap - startTimeHeap; // Calculate how long it takes for Heap Sort to complete
			long durationSelection = endTimeSelection - startTimeSelection; // Calculate how long it takes for Selection Sort to complete
			
			avgRunTimeHeap += durationHeap; // Keeps track of total runtime for Heap Sort
			avgRunTimeSelection += durationSelection; // Keeps track to total runtime for Selection Sort
			
		}
				
		// Calc avg run time for Heap Sort
		System.out.println("Average - running time for Heap Sort in ns: " + avgRunTimeHeap / 100); 

		// Calc avg run time for Heap Sort
		System.out.println("Average - running time for Selection Sort in ns: " + avgRunTimeSelection / 100); 
		
	}
	
	public void build_MaxHeap(int[] a) { // Build Max heap function. Only takes in the passed array as a parameter
		Lab5PartA heap = new Lab5PartA(); // Creates an object called heap
		
		int arrLength = 0; // Instantiates the variable for array length
		
		arrLength = a.length; // Gets the length of the array and saves it into a variable
		
		for (int i = arrLength / 2; i >= 0; i--) {
			heap.max_Heapify(a, i , arrLength); // Calls Max Heapify function and passes in the array, index, and length
		}
		
	}
	
	public void max_Heapify(int[] a, int i, int arrLength) {
		Lab5PartA heap = new Lab5PartA(); // Create an object called heap
		
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
		Lab5PartA heap = new Lab5PartA(); // Creates an object called heap
		
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
	
	public void selectionSort(int[] b) { // Iterates through array comparing smallest element 
		int arrLength = b.length; // Gets the size of the array
		
		for (int i = 0; i < arrLength - 1; i++) { // Iterates through array and stops before the last element
			int idxSmallest = i; // Sets the smallest element as the current element in array
			for (int j = i + 1; j < arrLength; j++) {
				if (b[j] < b[idxSmallest]) { // If the current element is smaller than the smallest element then switch
					idxSmallest = j; // Sets the smallest element to the current element 
				}
			}
			
			swap(b, idxSmallest, i); // Swaps the current smallest element with the first element
			
		}
		
	}
	
	// Helper method to create random generated arrays of the desired length
	public int[] createArrays(int n) {
		int[] newArr = new int[n];
		
		for (int i = 0; i < n ; i++) { // Add random generated numbers from the range -100 to 100 into the array
			int randNum = -100 + (int)(Math.random() * (101 - -100));
			newArr[i] = randNum;
		}
		
		return newArr;
		
	}
	
}
