package edu.ser222.m01_01;

public class ArrayBasic {

	public static void main(String[] args) 
	{
		int matches = 0;		
		int ARRAY_SIZE = 5;
		int videoIntensity[] = {0, 25, 50, 75, 100};
				
		String firstToLast = "The integers in this " + ARRAY_SIZE + " element array are, from first to last: ";
		
		System.out.print(firstToLast);
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			System.out.print(videoIntensity[i] + " ");
			
			if (videoIntensity[i] > 50)
				System.out.print(videoIntensity[i] + " ");
		}
		
//		for (int i = 0; i < ARRAY_SIZE; i++)
//		{
//			if (videoIntensity[i] > 50)
//				matches++;
//		}
 
		

	}

}
