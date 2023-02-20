package sorting;

public class Date implements Comparable<Date> 
{
	// Class member variables
	private final int month, day, year;
	
	// Constructor
	public Date(int m, int d, int y) 
	{ 
		month = m;
		day = d;
		year = y;
	}
	
	@Override
	public int compareTo(Date that) 
	{
		if (that.getClass() != this.getClass())
			throw new ClassCastException();
	
		if (this.year < that.year ) 
			return -1; 
		
		if (this.year > that.year ) 
			return +1; 
		
		if (this.month < that.month) 
			return -1; 
		
		if (this.month > that.month) 
			return +1; 
		
		if (this.day < that.day ) 
			return -1; 
		
		if (this.day > that.day ) 
			return +1; 
		
		return 0;
	}
	
	public String toString()
    { 
		return month + "/" + day + "/" + year; 
	}
	
	public static void main(String[] args) 
	{
		int day = 15;
		int month = 02;
		int year = 2023;
		
		Date today = new Date(day, month, year);
		Date yesterday = new Date(day -1, month -1, year - 1);
	}
}
