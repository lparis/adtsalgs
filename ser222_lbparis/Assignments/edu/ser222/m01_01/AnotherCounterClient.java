package edu.ser222.m01_01;
public class AnotherCounterClient {

	public static void main(String[] args)
	{
		AnotherCounter ac1 = new AnotherCounter("First");
		AnotherCounter ac2 = ac1;
		ac1.increment();
		ac2.increment();
		System.out.println(ac1);
		System.out.println(ac2);
	}
}
