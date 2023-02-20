package edu.ser222.m01_01;
// This program provides an implementation of the linear search algorithm
// and demonstrates it
// @author lbparis@asu.edu
// @version 1.0

// Import the Scanner class from the standard Java library
import java.util.Scanner;

// Declare public class; visibility modifier is public
public class LinearSearchExample
{
	//Given an array of values, determine if a value is contained in that array
	public static boolean find(int target, int[] pool)
    {
        for (int element : pool)
			if(element == target)
			    return true;

        return false;
    }

	//Demonstrate the linear search algorithm
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int[] data = {4, 45, 8, 1, 3, 3, 22, 9};
        int target;

        System.out.println("What is the target number? ");
        target = scanner.nextInt();
        if(find(target, data))
          System.out.println("Number Found!");
        else
          System.out.println("Number Missing, try again");

          scanner.close();
    }
}