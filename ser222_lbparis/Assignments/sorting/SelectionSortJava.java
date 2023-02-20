package sorting;

/*Selection sort in Java
 * 
 * 1. Find the smallest element in the data, starting at position i
 * 2. Swap it with position i
 * 3. Repeat for all elements in the list
 */

import java.util.Arrays;

class SelectionSortJava 
{
	void selectionSort(int array[]) 
	{
		System.out.println("Numbers: " + Arrays.toString(array));
		int size = array.length;
		
		for (int step = 0; step < size - 1; step++) 
		{
			int min_idx = step;
			for (int i = step + 1; i < size; i++) 
			{
				// To sort in descending order, change > to < in this line.
				// Select the minimum element in each loop.
				if (array[i] < array[min_idx]) 
				{
					min_idx = i;
				}
			}

			// put min at the correct position
			int temp = array[step];
			array[step] = array[min_idx];
			array[min_idx] = temp;
			System.out.println("Sort " + step + ":  " + Arrays.toString(array));
		}
	}

	// driver code
	public static void main(String args[]) 
	{
		//int[] data = { 20, 12, 10, 15, 2 };
		int[] data = { 7, 23, 25, 13, 2, 12, 3, 16, 43 };		
		SelectionSortJava ss = new SelectionSortJava();
		ss.selectionSort(data);
		System.out.println("Sorted Array in Ascending Order: ");
		System.out.println(Arrays.toString(data));
	}
}