package edu.ser222.m01_01;
public class Cone extends RoundShape
{
	// instance variable
	private double height;

	// Constructor
	public Cone(double r, double h)
	{
		// Call parent constructor first
		super(r);
		height = h;
	}

	public double GetHeight()
	{
		return height;
	}

	public void SetHeight(double r)
	{
		height = r;
	}

	@Override
	public double GetArea()
	{
		return Math.PI * GetRadius() * (GetRadius() + Math.sqrt(Math.pow(GetHeight(), 2) + Math.pow(GetRadius(), 2)));
	}

	@Override
	public double GetVolume()
	{
		return Math.PI * Math.pow(GetRadius(), 2) * (GetHeight()/3);
	}

	String ToString()
	{
		return "A cone of radius " + GetRadius() + ", area " + GetArea() + ", and volume " + GetVolume() + ".";
	}
}
