/*
 * This program takes in a 5-element integer array containing
 * intensity data for a 5 second video clip with each element 
 * representing 1 second of video. The program scans the array
 * input, determines if each element exceeds the interest 
 * threshold, and returns the result to standard out.
 * 
 * @author lbparis
 * @version 1.0
 */

package arrays;

public class IntensityInterest 
{
	public static void processArray(int[] data)
	{
		int intArray[] = data;
		int SIZE = intArray.length;
		int threshold = 50;

		System.out.println("The video clip is " + SIZE + " seconds long.");
		
		for(int i = 0; i < data.length; i++)
		{
			if (data[i] > threshold)
				System.out.println("Interest level " + data[i] + " found at the " + (i + 1) + " second mark.");
		}
	}

	public static void main(String[] args) 
	{
		int[] data = {0, 25, 50, 75, 100};
		processArray(data);
	}
}
