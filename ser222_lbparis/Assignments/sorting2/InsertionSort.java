package ser222_module5_sorting;

/*
 * The InsertionSort class implements an insertion sort using the 
 * common Sort class framework.
 * 
 * Insertion sort:
 * - Pick the first two elements and sort them
 * - Move to elements two and three and sort them all the way
 * - Repeat for all elements in the list
 * 
 */

public class InsertionSort 
{
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		
		for (int i = 0; i < N; i++)
		{
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
			{
				exch(a, j, j - 1);
			}	
		}
	}
	
	// Helper method less()
	private static boolean less(Comparable v, Comparable w) 
	{ 
		return v.compareTo(w) < 0;
	}
	
	// Helper method exch() 
	private static void exch(Comparable[] a, int i, int j) 
	{ 
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	// Testing method show()
	public static void show(Comparable[] a) 
	{
		System.out.print("Insertion Sort: ");

		for(int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		
//		System.out.println(); 
	}

	// Testing method isSorted()
	public static boolean isSorted(Comparable[] a) 
	{ 
		for (int i = 1; i < a.length; i++)
		{
			if (less(a[i], a[i-1]))
				return false;
		}
		return true;
	}
	
	// Timer
	public static void time(Comparable[] a) 
	{ 
		Stopwatch timer = new Stopwatch();
		System.out.println("Timer: " + timer.elapsedTime());	
	}
}
