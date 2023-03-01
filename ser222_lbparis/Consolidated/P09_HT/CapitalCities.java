package hashmap;

import java.util.HashMap;

public class CapitalCities 
{
	public static void main(String[] args) 
	{
		// Create a HashMap object called capitalCities
		HashMap<String, String> capitalCities = new HashMap<String, String>();

		// Add keys and values (Country, City)
		// Key = Country
		// Value = Capital City		
		capitalCities.put("England", "London");
		capitalCities.put("Germany", "Berlin");
		capitalCities.put("Norway", "Oslo");
		capitalCities.put("USA", "Washington DC");
		capitalCities.put("Nigeria", "Nairobi");
		capitalCities.put("Canada", "Ottawa");
		capitalCities.put("Mexico", "Mexico City");
		capitalCities.put("Lithuania", "Vilnius");
		capitalCities.put("Australia", "Canberra");
		capitalCities.put("China", "Beijing");
		capitalCities.put("Indonesia", "Jakarta");
		capitalCities.put("Chile", "Santiago");

		System.out.println(capitalCities);
	}
}
