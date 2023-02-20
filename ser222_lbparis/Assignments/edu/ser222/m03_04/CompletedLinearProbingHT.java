package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with linear probing.
 * 
 * @author lbparis, Sedgewick and Wayne, Acuna
 * 
 * @version 6.0
 * @date 2023-02-19
 */
import java.util.LinkedList;

/**
 * The type CompletedLinearProbingHT
 * 
 * @param <Key> the type parameter
 * @param <Value> the type parameter
 */
public class CompletedLinearProbingHT<Key, Value> implements ProbingHT<Key, Value> 
{
    //any constructors must be made public
	
	private int N; // Number of key-value pairs in the hashtable
	private int M; // size of linear-probing table
	private final LinearProbe<Key, Value>[] addContents; // adds contents to the hashtable
	
	/**
	 * The type LinearProbe
	 * 
	 * @param <Key> the type parameter
	 * @param <Va> the type parameter
	 * 
	 */
	public static class LinearProbe<Key, Val>
	{
		private Key key;
		private Val value;
		
		/**
		 * Instantiates a new LinearProbe object
		 * 
		 * @param key the key
		 * @param value the value
		 */
		public LinearProbe(Key key, Val value)
		{
			this.key = key;
			this.value = value;
		}
	}

	/**
	 * CONSTRUCTOR #1
	 * 
	 * Instantiates a new CompletedLinearProbingHT object
	 * Defaults to an array size of 997
	 * 
	 */
	public CompletedLinearProbingHT()
	{
		this(997);
	}
	
	/**
	 * 
	 * CONSTRUCTOR #2
	 * 
	 * Instantiates a new CompletedLinearProbingHT object
	 * Hashtable is sized according to the input
	 * 
	 * @param size is the size
	 */
	public CompletedLinearProbingHT(int size)
	{
		this.M = size;
		this.N = 0;
		this.addContents = new LinearProbe[M];
	}
	
	// Use the basic hash function given in the slides: hash(k, i) = ((k.hashCode() & 0x7f) + i) % M, 
	// where k is the key and i is the number of collisions. 
	// Each time there is a collision, this will increase the hash by 1.
	// An example hash sequence might look like: 43587, 43588, 43589, 43590, 43581...
    @Override
    public int hash(Key key, int i) 
    {
        //Done
    	// hash(k, i) = ((k.hashCode() & 0x7f) + i) % M
        return ((key.hashCode() & 0x7fffffff) + i) % M;
    }

    @Override
    public void put(Key key, Value val) 
    {
        //DONE
    	int i = 0;
    	for (i = hash(key, i); addContents[i] != null; i = (i + 1) % M)
    	{
    		if (addContents[i].key.equals(key))
    		{
    			addContents[i].value = val;
    			return;
    		}
    	}
    	addContents[i] = new LinearProbe<Key, Value>(key, val);
    	N++;
    }

    @Override
    public Value get(Key key) 
    {
        //DONE
    	int i = 0;    	
    	for (i = hash(key, i); addContents[i] != null; i = (i + 1) % M)
    	{
    		if (addContents[i].key.equals(key))
    		{
    			return addContents[i].value;
    		}
    	}
        return null;
    }

    @Override
    public void delete(Key key) 
    {
        //DONE
    	int i = 0;    	
    	for (i = hash(key, i); addContents[i] != null; i = (i + 1) % M)
    	{
    		if (addContents[i].key.equals(key))
    		{
    			for (int j = i + 1; addContents[i] != null; j = (j + 1) % M)
    			{
    				addContents[i] = addContents[j];
    				i = (i + 1) % M;
    			}
    			addContents[i] = null;
    			N--;
    		}
    	}
    }

    @Override
    public boolean contains(Key key) 
    {
        //DONE
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() 
    {
        //DONE
        return N == 0;
    }

    @Override
    public int size() 
    {
        //DONE
        return N;
    }

    @Override
    public Iterable<Key> keys() 
    {
        //DONE
    	LinkedList<Key> list = new LinkedList<Key>();
    	
    	for (int i = 0; i < M; i++)
    	{
    		if (addContents[i] != null)
    		{
    			list.add(addContents[i].key);
    		}
    	}
        return list;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // THESE METHODS ARE ONLY FOR GRADING AND COME FROM THE PROBINGHT INTERFACE.

    @Override
    public int getM() {
        //TODO. We suggest something like:
        //return M;

        return M;
    }

    @Override
    public Object getTableEntry(int i) {
        //TODO. We suggest something like:
        //return entries[i];

        return addContents[i];
    }
}