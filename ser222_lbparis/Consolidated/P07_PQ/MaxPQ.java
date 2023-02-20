package queues;

import arrays.MinPQ;

public class MaxPQ<Key extends Comparable<Key>> 
{ 
	private Key[] pq;
	private int N = 0;
	
	public MaxPQ(int maxN) 
	{
		pq = (Key[]) new Comparable[maxN+1];
	}
	
	public boolean isEmpty() 
	{ 
		return N == 0;
	}
	
	public int size() 
	{ 
		return N;
	}
	
	public void insert(Key v) 
	{ 
		pq[++N] = v;
		swim(N); 
	}
	
	public Key delMax() 
	{ 
		Key max = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return max;
	}
	
	private void swim(int k) 
	{
		while (k > 1 && less(k/2, k)) 
		{
	        exch(k, k/2);
	        k = k/2;
		}
	}
	
	private void sink(int k) 
	{ 
		while (2*k <= N) 
		{
			int j = 2*k;
			if (j < N && less(j, j+1)) j++; 
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) 
	{ 
		return ((Comparable<Key>) pq[i])
				.compareTo(pq[j]) < 0;
	}
			
	private void exch(int i, int j) 
	{ 
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}
	
	public static void main(String[] args) 
	{
		MaxPQ maxpq1 = new MaxPQ(10);

		System.out.println("Queue contents: " + maxpq1.toString());		

		maxpq1.insert(2);
		maxpq1.insert(3);

		System.out.println("Item at the front of the queue: " + maxpq1.toString());		
		System.out.println("Queue contents: " + maxpq1.toString());
	}
}
