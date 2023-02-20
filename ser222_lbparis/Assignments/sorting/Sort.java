package sorting;

public class Sort 
{
	// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		
		for (int i = 0; i < N; i++)
		{
			int min = i;
			for (int j = i + 1; j < N; j++)
			{
				if (less(a[j], a[min])) min = j;
			}
			exch(a, i, min);	
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
	private static void show(Comparable[] a) 
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

	public static void main(String[] args) 
	{
		String[] a = {"O", "S", "X", "E", "R", "T"};
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
