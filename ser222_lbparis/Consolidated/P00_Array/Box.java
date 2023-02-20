package edu.ser222.m01_01;

public class Box<Content>
{

	private Content contents;

	public Box(Content contents)
	{
		this.contents = contents;
	}

	public Content getContents()
	{
		return contents;
	}

	public static void main(String[] args)
	{
//		Box<String> boxString = new Box<>(contents "Hello");
//		boxString.getContents();

//		Box<Integer> boxInt = new Box<>(contents 1);
//		boxInt.getContents();

	}

}
