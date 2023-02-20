package sorting;

/*
 * Insertion sort in Java
 * 
 * 1. Assume first element is sorted correctly
 * 2. Compare second element with first, if smaller swap them
 * 3. Compare third element with second, if smaller swap them, compare with first, if smaller swap them
 * 4. Repeat until the end
 */

import java.util.Arrays;

class InsertionSort 
{
	void insertionSort(int array[]) 
	{
		System.out.println("Numbers to sort: " + Arrays.toString(array));
		int size = array.length;
		
		for (int step = 1; step < size; step++) 
		{
			int key = array[step];
			int j = step - 1;

		// Compare key with each element on the left of it until an element smaller than
		// it is found.
		// For descending order, change key<array[j] to key>array[j].
   
		while (j >= 0 && key < array[j]) 
		{
			array[j + 1] = array[j];
			--j;
		}

   // Place key at after the element just smaller than it.
   array[j + 1] = key;
   System.out.println("Step " + step + " sort:     " + Arrays.toString(array));
   
	}
}

// Driver code
	public static void main(String args[]) 
	{
//		int[] data = { 9, 5, 1, 4, 3 };
		int[] data = { 7, 23, 25, 13, 2, 12, 3 };		
		InsertionSort is = new InsertionSort();
		is.insertionSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));	
	}
}