package edu.ser222.m01_01;

/**
 * Represents a counter which starts at zero and may be increased by one.
 *
 * @author lbparis@asu.edu
 * @version 1.0
 */

public class AnotherCounter implements IncrementCounter
{
    private final String name;
    private int count = 0;

    public AnotherCounter(String id)
    {
        name = id;
    }

	@Override
	public void increment()
	{
		count++;
	}

	@Override
	public int tally()
	{
		return count;
	}

	@Override
	public String toString()
	{
		return count + " " + name;
	}

}
