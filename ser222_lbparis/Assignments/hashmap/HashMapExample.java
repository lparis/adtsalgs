package hashmap;

import java.util.HashMap;

public class HashMapExample 
{
	public static void main(String[] args) 
	{
		// Create new HashMap named ST
		HashMap<String , Integer> ST = new HashMap<>(); 
		
		ST.put("SER216", 48);
				
		ST.put("SER222", 80);
		
		ST.put("SER232", 78);
		
		ST.put("SER322", 60); 
		
		ST.put("SER332", 24);
		
		
//		System.out.println(ST.get(ST));
		
//		System.out.println(ST.get(" SER232 ")); 
		
//		ST.remove("SER216");
		
		if (ST.containsKey("SER216"))
		{
			System.out.println(ST.get("Warning: SER216 still exists!"));
		}
		
		System.out.println(ST.get("Courses: " )); 

		for(String k : ST.keySet())
		{
			System.out.println(k + " : " + ST.get(k));
		}
	}
}
