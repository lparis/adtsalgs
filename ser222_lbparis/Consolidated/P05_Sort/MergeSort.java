package ser222_module5_sorting;

/*
 * The MergeSort class implements an insertion sort using the 
 * common Sort class framework.
 * 
 * Merge sort:
 * - Take the input array and split it into halves
 * - Sort each of the halves
 * - Combine the sorted halves for form a whole
 * 
 */

public class MergeSort 
{
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length]; 
		sort(a, aux, 0, a.length-1);
		
		assert isSorted(a);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) 
	{ 
		if (hi <= lo) 
			return;
	
		int mid = lo + (hi - lo) / 2;
	
		sort(a, aux, lo, mid); 
		sort(a, aux, mid + 1, hi); 
		merge(a, aux, lo, mid, hi);
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) 
	{ 
//		assert isSorted(a, lo, mid);
//		assert isSorted(a, mid+1, hi);
	
		int i = lo, j = mid+1; for(int k = lo; k <= hi; k++)
	        aux[k]=a[k];
	    
		// merge back to a[]
		for (int k = lo; k <= hi; k++) 
		{
			if (i > mid)
				a[k] = aux[j++];
			
			else if (j > hi)
				a[k] = aux[i++];
			
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			
			else
				a[k] = aux[i++];
		}
//		assert isSorted(a, lo, hi); 
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
