package edu.ser222.m01_01;

public class CounterClient {

	public static void main(String[] args)
	{
      Counter count=new Counter("A");
      count.increment();
      System.out.println(count);
   }
}
