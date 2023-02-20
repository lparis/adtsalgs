package edu.ser222.m01_01;
public abstract class RoundShape
{
	private double radius;

	// Constructor
	public RoundShape(double r)
	{
		radius = r;
	}

	public double GetRadius()
	{
		return radius;
	}

	public void SetRadius(double r)
	{
		radius = r;
	}

	public abstract double GetArea();
	public abstract double GetVolume();

}