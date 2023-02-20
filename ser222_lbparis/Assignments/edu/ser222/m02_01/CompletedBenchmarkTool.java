package edu.ser222.m02_01;

//import java.util.Arrays;

/**
 * (basic description of the program or class)
 *
 * Completion time: (estimation of hours spent on this program)
 *
 * @author lbparis, Acuna, Sedgewick
 * @version (2023-01-23)
 */

import java.util.Random;
//import java.text.DecimalFormat;

public class CompletedBenchmarkTool implements BenchmarkTool {

    /***************************************************************************
     * START - SORTING UTILITIES, DO NOT MODIFY (FROM SEDGEWICK)               *
     **************************************************************************/

    public static void insertionSort(Comparable[] a)
    {
        int N = a.length;

        for (int i = 1; i < N; i++)
        {
            // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    public static void shellsort(Comparable[] a)
    {
        int N = a.length;
        int h = 1;

        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                exch(a, j, j-h);
            }
            h = h/3;
        }
    }


    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }


    private static void exch(Comparable[] a, int i, int j)
    {
        Comparable t = a[i]; a[i] = a[j]; a[j] = t;
    }

    /***************************************************************************
     * END - SORTING UTILITIES, DO NOT MODIFY                                  *
     **************************************************************************/

    // Instance variables
    private double smallTime;
    private double largeTime;
    static Random random = new Random(25L);

    public static void main(String args[])
    {
        BenchmarkTool me = new CompletedBenchmarkTool();
        int size = 4096;
//        int size = 4096 * 2;
//        int size = 4096 * 8;

        //NOTE: feel free to change size here. all other code must go in the methods.

        me.runBenchmarks(size);
    }

    /*
     * Implement the method public Integer[] generateTestDataBinary(int size).
     * Half the data is 0s, half 1s.
     * For example, an input of length 8 might look like [0, 0, 0, 0, 1, 1, 1, 1].
     * See the interface.
     */
	@Override
	public Integer[] generateTestDataBinary(int size)
	{
		Integer[] dataArray = new Integer[size];

		for (int i = 0; i < dataArray.length; i++)
		{
			if (i <= dataArray.length/2)
			{
				dataArray[i] = 0;
			}
			else
			{
				dataArray[i] = 1;
			}
		}
//		System.out.println("Binary test data: " + Arrays.toString(dataArray));
		return dataArray;
	}

	/*
	 * Implement the method public Integer[] generateTestDataHalfs(int size).
	 * Half the data is 0s, half the remainder is 1s, half the reminder is 2s,
	 * half the reminder is 3s, and so forth.
	 * For example, an input of length 8 might look like
	 * [0, 0, 0, 0, 1, 1, 2, 3]. See the interface.
	 */
	@Override
	public Integer[] generateTestDataHalves(int size)
	{
		Integer[] dataArray = new Integer[size];

		int middle = (size/2);
		int index = middle;
		int count = 0;

		for (int i = 0; i < size; i++)
		{
			if (i == index)
			{
				middle = (middle/2) + (middle % 2);
				index += middle;
				count++;
			}

			dataArray[i] = count;
		}

//		System.out.println("Halves test data: " + Arrays.toString(dataArray));
		return dataArray;
	}

	/*
	 * Implement the method public Integer[] generateTestDataHalfRandom(int size).
	 * Half the data is 0s, half random int values (use nextInt() from Java's Random package,
	 * and use Integer.MAX_VALUE as its argument to ensure the values are positive).
	 * For example, an input of length 8 might look like [0, 0, 0, 0, 54119567, 4968, 650736346, 138617093].
	 * See the interface.
	 */
	@Override
	public Integer[] generateTestDataHalfRandom(int size)
	{
		Integer[] dataArray = new Integer[size];

		for (int i = 0; i < dataArray.length; i++)
		{
			if (i <= dataArray.length/2)
			{
				dataArray[i] = 0;
			}

			else
			{
				dataArray[i] = random.nextInt(Integer.MAX_VALUE);
			}
		}

//		System.out.println("Random test data: " + Arrays.toString(dataArray));
		return dataArray;
	}

	/*
	 * Implement the method public double computeDoublingFormula(double t1, double t2).
	 *
     * The method computeDoublingFormula() computes the double formula value for two run times.
     *
     * @paramt1 first time
     * @paramt2 second time
     * @return b value
	 *
	 */
	@Override
	public double computeDoublingFormula(double t1, double t2)
	{
		return (Math.log(t2/t1));
	}

	/*
	 *  Implement the method public double benchmarkInsertionSort(Integer[] small, Integer[] large).
	 *
	 *  Creates two instances of Stopwatch: timeSmall and timeLarge.
	 *  Stopwatch is a utility class to measure the running time (wall clock) of a program.
	 *
	 *  @param Integer[] small
	 *  @param Integer[] large
	 *  @return elapsed CPU time (in seconds) since the stopwatch was created
	 */
	@Override
	public double benchmarkInsertionSort(Integer[] small, Integer[] large)
	{
		Stopwatch timeSmall = new Stopwatch();
		insertionSort(small);
		this.smallTime = timeSmall.elapsedTime();

		Stopwatch timeLarge = new Stopwatch();
		insertionSort(large);
		this.largeTime = timeLarge.elapsedTime();

		return computeDoublingFormula(this.smallTime, this.largeTime);
	}


	/*
	 * Implement the method public double benchmarkShellsort(Integer[] small, Integer[] large).
	 *
	 * Creates two instances of Stopwatch: timeSmall and timeLarge.
	 * Stopwatch is a utility class to measure the running time (wall clock) of a program.
	 *
	 *  @param Integer[] small
	 *  @param Integer[] large
	 *  @return elapsed CPU time (in seconds) since the stopwatch was created
	 */
	@Override
	public double benchmarkShellsort(Integer[] small, Integer[] large)
	{
		Stopwatch timeSmall = new Stopwatch();
		shellsort(small);
		this.smallTime = timeSmall.elapsedTime();

		Stopwatch timeLarge = new Stopwatch();
		shellsort(large);
		this.largeTime = timeLarge.elapsedTime();

		return computeDoublingFormula(this.smallTime, this.largeTime);
	}

	/*
	 * Implement the method public void runBenchmarks(int size).
	 * Whitespace is flexible (any number of tabs or spaces) but you must show three decimal places.
	 * See the interface for more information. Hint: should call the two benchmark methods above.
	 * The output should look like below.
	 *
	 * 			  	Insertion 	| 	Shellsort
	 * BIN				#.###	|	#.###
	 * HALF				#.###	|	#.###
	 * RanInt			#.###	|	#.###
	 */
	@Override
	public void runBenchmarks(int size)
	{
		Integer[] smallBinary, largeBinary, smallHalf, largeHalf, smallRandom, largeRandom;
		int dblSize = size * 2;

		smallBinary = generateTestDataBinary(size);
		largeBinary = generateTestDataBinary(dblSize);

		smallHalf = generateTestDataHalves(size);
		largeHalf = generateTestDataHalves(dblSize);

		smallRandom = generateTestDataHalfRandom(size);
		largeRandom = generateTestDataHalfRandom(dblSize);

//		System.out.println();
		System.out.printf("%-15.15s %-15.15s %-15.15s%n", " ", "Insertion", "Shellsort");
		System.out.printf("%-18.10s %-15.3f %-15.3f%n", "Bin" , benchmarkInsertionSort(smallBinary, largeBinary) , benchmarkShellsort(smallBinary, largeBinary));
		System.out.printf("%-18.10s %-15.3f %-15.3f%n", "Half" , benchmarkInsertionSort(smallHalf, largeHalf) , benchmarkShellsort(smallHalf, largeHalf));
		System.out.printf("%-18.10s %-15.3f %-15.3f%n", "RanInt" , benchmarkInsertionSort(smallRandom, largeRandom) , benchmarkShellsort(smallRandom, largeRandom));

	}
}