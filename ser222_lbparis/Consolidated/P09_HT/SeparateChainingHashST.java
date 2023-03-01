package hashmap;

public class SeparateChainingHashST<Key, Value> 
{
	private int N; // number of key-value pairs 
	private int M; // hash table size
	private SequentialSearchST<Key, Value>[] st;
	
	public SeparateChainingHashST() 
	{ 
		this(997);
	}
	public SeparateChainingHashST(int M) 
	{ 
		this.M = M;
		
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M]; 
		
		for (int i = 0; i < M; i++)
		{
			st[i] = new SequentialSearchST();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
