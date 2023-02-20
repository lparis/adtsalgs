package edu.ser222.m03_04;

/**
 * A symbol table implemented using a hashtable with quadratic probing.
 * 
 * @author lbparis, Acuna
 * 
 * @version 6.0
 * @date 2023-02-19
 */

/**
* The type Quad probing ht.
*
* @param <Key> the type parameter
* @param <Value> the type parameter
*/
public class CompletedQuadProbingHT<Key, Value> extends CompletedLinearProbingHT<Key, Value> 
{
    //any constructors must be made public
    //DONE
	
	private int M;
	
	/**
	 * CONSTRUCTOR #1
	 * Instantiates a new QuadProbingHT
	 */
	public CompletedQuadProbingHT()
	{
		this(997);
	}
	
	/**
	 * CONSTRUCTOR #2
	 * Instantiates a new QuadProbingHT
	 * 
	 * @param size the size
	 */
	public CompletedQuadProbingHT(int size)
	{
		super(size);
		this.M = size;
	}
	
	/**
	 * Hash table create
	 * 
	 * @param key is the key
	 * @param i is an int
	 * @return the int
	 */
	public int hash(Key key, int i)
	{
		return ((key.hashCode() & 0x7fffffff) + i * i) % M;
	}
}