package ser222_module5_sorting;

/*
 * The ShellSort class implements a shell sort using the 
 * common Sort class framework.
 * 
 * Shell Sort:
 * - Implement an insertion sort starting at both ends of the array
 * - Converges to the middle
 * - Moves far away things first
 * 
 */

public class ShellSort 
{
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
	public static void sort(Comparable[] a)
	{		
		int N = a.length;
		int h = 1;
		
		// 1, 4, 13, 40, 121, 364, 1093, ...
		while (h < N/3) h = 3*h + 1; 
		while (h >= 1) {
		
		// h-sort the array.
		for (int i = h; i < N; i++) 
		{
			// Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
			for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) exch(a, j, j-h);
		}
		h = h/3; }
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
		System.out.print("Shell Sort:     ");

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
		System.out.println("| Time: " + timer.elapsedTime());	
	}
}
