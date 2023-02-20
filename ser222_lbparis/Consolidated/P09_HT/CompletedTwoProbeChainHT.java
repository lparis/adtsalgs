package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with chaining.
 * Does not support load balancing or resizing.
 * 
 * @author lbparis, Sedgewick and Wayne, Acuna
 * 
 * @version 6.0
 * @date 2023-02-19
 */
import java.util.LinkedList;

/**
 * The type CompletedTwoProbeChainHT
 * 
 *  @param <Key> the key parameter
 *  @param <Value> the type parameter
 */
public class CompletedTwoProbeChainHT<Key, Value> implements TwoProbeChainHT<Key, Value> 
{
    //any constructors must be made public
	private int N; // number of key-value pairs
	private int M; // hash table size
	private LinkedList<Entry>[] st;

	/**
	 *  The type Entry
	 *  
	 *  @param <Key> the key parameter
	 *  @param <Val> the type parameter
	 */
	public static class Entry<Key, Val>
	{
		private final Key key;
		private Val value;
		
		/**
		 *  Instantiates a new Entry.
		 *  
		 *  @param key is the key
		 *  @param value is the value
		 */
		public Entry(Key key, Val value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	/**
	 * Instantiate a new CompletedTwoProbeChainHT.
	 * 
	 * @param size is the size
	 * @return 
	 */
	public CompletedTwoProbeChainHT(int size)
	{
		this.M = size;
		this.N = 0;
		
		// LinkedList is used to store each chain
		st = (LinkedList<Entry>[]) new LinkedList[M];
		
		for (int i = 0; i < M; i++)
		{
			st[i] = new LinkedList<>();
		}
	}
	
	public CompletedTwoProbeChainHT() 
	{
		this(997);
	}

	//  First hash function uses: hash(k)=(k.hashCode() & 0x7fffffff) %M
    @Override
    public int hash(Key key) 
    {
        //DONE
        return (key.hashCode() & 0x7fffffff) % M;
    }

	//  Second hash function uses: hash2(k)= (((k.hashCode() & 0x7fffffff) % M) * 31) % M
    @Override
    public int hash2(Key key) 
    {
        //DONE
        return (((key.hashCode() & 0x7fffffff) % M) * 31) % M;
    }

    @Override
    public void put(Key key, Value val) 
    {
        //DONE
    	for (int i = 0; i < st[hash(key)].size(); i++)
    	{
    		if (st[hash(key)].get(i).key.equals(key))
    		{
    			st[hash(key)].get(i).value = val;
    			return;
    		}
    	}
    	
    	for (int i = 0; i < st[hash2(key)].size(); i++)
    	{
    		if (st[hash2(key)].get(i).key.equals(key))
    		{
    			st[hash2(key)].get(i).value = val;
    			return;
    		}
    	}
    	
    	if (st[hash(key)].size() < st[hash2(key)].size())
    	{
    		st[hash(key)].add(new Entry(key, val));
    	}
    	else
    	{
    		st[hash2(key)].add(new Entry(key, val));
    	}
    	N++;
    }
 
    @Override
    public Value get(Key key) 
    {
        //DONE
    	for (int i = 0; i < st[hash(key)].size(); i++)
    	{
    		if (st[hash(key)].get(i).key.equals(key))
    		{
    			return (Value) st[hash(key)].get(i).value;
    		}
    	}
    	
    	for (int i = 0; i < st[hash2(key)].size(); i++)
    	{
    		if (st[hash2(key)].get(i).key.equals(key))
    		{
    			return (Value) st[hash2(key)].get(i).value;
    		}
    	}
    	return null;	
    }

    @Override
    public void delete(Key key) 
    {
        //DONE
    	for (int i = 0; i < st[hash(key)].size(); i++)
    	{
    		if (st[hash(key)].get(i).key.equals(key))
    		{
    			st[hash(key)].remove(i);
    			N--;
    		}
    	}
    	
    	for (int i = 0; i < st[hash2(key)].size(); i++)
    	{
    		if (st[hash2(key)].get(i).key.equals(key))
    		{
    			st[hash2(key)].remove(i);
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
    	{
    		for (int i = 0; i < M; i++)
    		{
    			for (int j = 0; j < st[i].size(); j++)
    			{
    				list.add((Key) st[i].get(j).key);
    			}
    		}
    		return list;
    	}
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // THESE METHODS ARE ONLY FOR GRADING AND COME FROM THE TWOPROBECHAINHT INTERFACE.

    @Override
    public int getM() 
    {
        //TODO. We suggest something like:
        //return M;
        return M;
    }

    @Override
    public int getChainSize(int i) 
    {
        //TODO. We suggest something like:
        //return entries[i].size();
        return st[i].size();
    }
}