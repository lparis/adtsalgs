package edu.ser222.m01_03;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * CompletedOrderedList testing area.
 *
 * @author lbparis, Acuna
 * @version 2.0
 */
public class Driver
{
	private static final Random rand = new Random(101);

	public static void main(String [] args)
	{
        OrderedListADT<Integer> list = new CompletedOrderedList<>();

        //RA: These are _extremely_ simple tests! You will need to write more!

        list.add(23);
        list.add(24);
        list.add(16);
        list.add(3);
        list.add(7);
        list.add(17);
        list.add(9);
        list.add(13);
        list.add(14);
        list.add(1);

        System.out.println(list);

        list.remove(7);
        list.removeFirst();
        list.remove(17);
        list.removeLast();
        list.remove(14);
        list.removeLast();

        //display using toString()
        System.out.println(list);

        /* Test Results:
            1 3 7 9 13 14 16 17 23 24
            3 9 13 16
        */

        //display using automatic iterator way
        for(Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        //display using manual iterator way
        Iterator iter = list.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next());
            if (iter.hasNext())
                System.out.print(" ");
        }

        //toString is probably the nicest if we just need to display.

        //You should definitely write a test for ConcurrentModificationException...

        // Clear list using iterator.

        System.out.println(list);
        // Add random sample of data.
        Integer[] sampleData = generateSampleData(100000, 0, Integer.MAX_VALUE - 1);
        //Integer[] sampleData = generateSampleData(10, 0, 500);
        //System.out.println(Arrays.toString(sampleData));
        System.out.println("Adding Sample Data...");
        int j = 0;
        for (int i = 0; i < sampleData.length; i++) {
            list.add(sampleData[i]);
            if((i % (sampleData.length / 10)) == 0) {
                j++;
                System.out.println("Adding Sample Data... " + j*10 + "% ");
            }
        }

        // Remove random data
        System.out.println("Removing Sample Data...");
        j = 0;
        for (int i = 0; i < sampleData.length; i++) {
            list.remove(sampleData[i]);
            if((i % (sampleData.length / 10)) == 0) {
                j++;
                System.out.println("Removing Sample Data... " + j*10 + "% ");
            }
        }
        System.out.println("Printing List...");
        System.out.println(list);

        // Test Remove Not in List
        System.out.println("Testing to remove elements not in list");
        try {
            list.remove(sampleData[rand.nextInt(sampleData.length)]);
            System.out.println("Test Failed.");
        }catch(NoSuchElementException e) {
            System.out.println("Test Passed.");
        }
    }
    public static Integer[] generateSampleData(int size, int min, int max) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(max - min + 1) + min;
        }
        return data;
    }
}
