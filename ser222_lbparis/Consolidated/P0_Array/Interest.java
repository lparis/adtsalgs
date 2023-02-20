package edu.ser222.m01_01;
//import java.util.Scanner;

public class Interest 
{			
    public Interest(int[] data)
    {
        {
            data = new int[5];
            for(int i = 0; i < data.length; i++)
            {
            	data[i] = data[i];
            }
        }
    }
        
//    public static void getInterestArray(Interest interest)
//	{
//    	interest.
//		for (int i = 0; i < interest.length; i++)
//		{
//			System.out.print(interest[i] + " ");
//		}
//    }
    

	public static void main(String[] args) 
	{
        int[] data1 = new int[0];
        int[] data2 = {0,25,50,75,100};
        int[] data3 = {48,49,50,51,52};        

        Interest interest1 = new Interest(data1);
        Interest interest2 = new Interest(data2);
        Interest interest3 = new Interest(data3);
        
        int ARRAY_SIZE = 5;
		String firstToLast = "The integers in this " + ARRAY_SIZE + " element array are, from first to last: ";
		
		System.out.print(firstToLast);
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			System.out.print(data1[i] + " ");
		}
        
	}
}
