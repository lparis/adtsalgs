package hashmap;

public class Transaction 
{
	// Class Variables
	// Objects instead of primitive types
	private String who = ""; 
	private Integer when = 0;
	private Double amount = 0.0;
	
	// Class Constructor
    public Transaction(String who, Integer when, Double amount) 
    {
        this.who = who;
        this.when = when;
        this.amount = amount; 
    }
	
    // Method to create a hash from the input
	public int hashCode() 
	{
		int hash = 17;
		
		hash = 31 * hash + who.hashCode();
		hash = 31 * hash + when.hashCode();
		hash = 31 * hash + ((Double) amount).hashCode(); 
		
		return hash;
	}
	
	public static void main(String[] args) 
	{
		Transaction tx = new Transaction("paris", 20230226, 56.3);
		System.out.println(tx);
		System.out.println(tx.hashCode());
		System.out.println(tx.who.hashCode());
		System.out.println(tx.when.hashCode());
		System.out.println(tx.amount.hashCode());
		System.out.println(tx.hashCode());		
	}
}
