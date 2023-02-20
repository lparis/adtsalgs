package ser222_module5_sorting;

/*
 * The Sort class provides a basic framework for implementing sorting.
 * Helper methods less() and exch() provide common functionality.
 * Testing methods isSorted() and show() provide testing facilities.
 * Designed to be generic by using the Comparable[] interface
 * to support more than just Strings.
 * 
 *  Populate the sort() method depending on the type of sort implementing
 */

public class Sort 
{
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
	public static void sort(Comparable[] a)
	{
		// Add code here depending on the type of sort
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
		for(int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		
		System.out.println(); 
	}

	// Testing method isSorted()
	public static boolean isSorted(Comparable[] a) 
	{ 
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) 
				return false;
		
		return true;
	}
}
