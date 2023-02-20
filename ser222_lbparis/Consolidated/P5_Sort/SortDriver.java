package ser222_module5_sorting;

public class SortDriver {

	public static void main(String[] args) 
	{
		String[] a = {"O", "S", "X", "E", "R", "T"};
		
		System.out.print("Input Array:    ");
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
				
		SelectionSort.sort(a);
		assert SelectionSort.isSorted(a);
		SelectionSort.show(a);
		SelectionSort.time(a);
		
		InsertionSort.sort(a);
		assert InsertionSort.isSorted(a);
		InsertionSort.show(a);
		SelectionSort.time(a);
		
		ShellSort.sort(a);
		assert ShellSort.isSorted(a);
		ShellSort.show(a);
		ShellSort.time(a);
		
	}
}
