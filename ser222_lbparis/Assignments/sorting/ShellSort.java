package sorting;

//Shell sort in Java programming

import java.util.Arrays;

//Shell sort
class ShellSort {

// Rearrange elements at each n/2, n/4, n/8, ... intervals
void shellSort(int array[], int n) 
{
	System.out.println("Numbers: " + Arrays.toString(array));
	
for (int interval = n / 2; interval > 0; interval /= 2) {
 for (int i = interval; i < n; i += 1) {
 int temp = array[i];
 int j;
 for (j = i; j >= interval && array[j - interval] > temp; j -= interval) {
   array[j] = array[j - interval];
 }
 array[j] = temp;
	System.out.println("Sort " + i + ":  " + Arrays.toString(array));

 }
}
}

// Driver code
public static void main(String args[]) 
{
	int[] data = { 7, 23, 25, 13, 2, 12, 3 };		

//int[] data = { 9, 8, 3, 7, 5, 6, 4, 1 };
int size = data.length;
ShellSort ss = new ShellSort();
ss.shellSort(data, size);
System.out.println("Sorted Array in Ascending Order: ");
System.out.println(Arrays.toString(data));
}
}