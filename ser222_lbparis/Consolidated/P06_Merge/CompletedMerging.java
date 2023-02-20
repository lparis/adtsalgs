package edu.ser222.m02_02;

/**
 * Implements various divide and conquer algorithms.
 *
 * Last updated 2/5/2023.
 *
 * Completion time: 8+ hours
 *
 * @author lbparis, Acuna, Sedgewick and Wayne
 * @verison 5.0
 */
import java.util.Random;

public class CompletedMerging implements MergingAlgorithms 
{
	/*
	 * The mergeQueues() method merges sorted queues.
	 * Takes two queues of sorted items as arguments 
	 * and returns a queue that is merged and sorted. 
	 * 
	 * @param Queue named q1
	 * @param Queue named q2
	 * 
	 * @return merged queue named returnQueue
	 */
	
    @Override
    public <T extends Comparable> Queue<T> mergeQueues(Queue<T> q1, Queue<T> q2) 
    {    	
    	Queue returnQueue = new ListQueue();
    	
    	while(!q1.isEmpty() || !q2.isEmpty())
    	{
    		if(q1.isEmpty()) returnQueue.enqueue(q2.dequeue());
    		
    		else if(q2.isEmpty()) returnQueue.enqueue(q1.dequeue());

    		else if(q1.peek().compareTo(q2.peek()) < 0)
    			returnQueue.enqueue(q1.dequeue());
    
    		else
    			returnQueue.enqueue(q2.dequeue());
    	}
    		
        return returnQueue;
    }

    /*
     * The sort() method is the starting point for the recursive mergesort process
     */
    @Override
    public void sort(Comparable[] a) 
    {
        mergesort(a);
    }

    /*
     * Helper method to sort for the mergesort recursion process
     * SER222_02_02_Samples/src/Mergesort.java
     * Reimplemented mergesort algorithm to pass only arrays as parameters
     */
    @Override
    public Comparable[] mergesort(Comparable[] a) 
    {
    	Comparable[] newArray;
    	
    	if(a.length == 1)
    		return a;
    	
    	int mid = a.length/2;
    	
    	// left side merge sort
    	Comparable[] left = new Comparable[mid];
    	
    	for(int i = 0; i < mid; i++)
    	{
    		left[i] = a[i];
    	}
    	mergesort(left);
    	
    	// right side merge sort
    	Comparable[] right = new Comparable[a.length - mid];
    	
    	for(int i = mid; i < a.length; i++)
    	{
    		right[i - mid] = a[i];
    	}
    	mergesort(right);
    	
    	// merge left and right
    	newArray = merge(left,right);
    	for(int i = 0; i < newArray.length; i++)
    	{
    		a[i] = newArray[i];
    	}
    	
        return newArray;
    }

    /*
     * Helper method for sort and the mergesort recursion process
     */
    @Override
    public Comparable[] merge(Comparable[] a, Comparable[] b) 
    {
    	Comparable[] newArray = new Comparable[a.length + b.length];
    	
    	Comparable[] temp = new Comparable[a.length + b.length];

    	for(int i = 0; i < temp.length; i++) 
    	{
    		if(i < a.length) 
    			temp[i] = a[i];
    		
    		else temp[i] = b[i - a.length];
    	}

    	int i = 0; 
    	int j = a.length;

    	// merge it back to a[]
    	for (int k = 0; k < temp.length; k++) 
    	{
    		if (i > a.length - 1) 
    			newArray[k] = temp[j++];
    		
    		else if (j > temp.length - 1) 
    			newArray[k] = temp[i++];
    		
    		else if (less(temp[j], temp[i])) 
    			newArray[k] = temp[j++];
    		
    		else newArray[k] = temp[i++];
    	}
    	return newArray;
    }
/*
 * The shuffle(Object[] a) method shuffles an array in nlog(n) time using
 * a recursive merging mechanism. Calls helper method shuffleDown() which
 * calls shuffleMerge()
 */
    @Override
    public void shuffle(Object[] a) 
    {
        Object[] aux = new Object[a.length];
        shuffleDown(a, aux, 0, a.length - 1);
    }

    //Helper method for shuffle()
    private void shuffleDown(Object[] a, Object[] aux, int start, int end) 
    {
		if(end <= start)
			return;

		int mid = (start + (end - start)/2);
		
		//left
		shuffleDown(a, aux, start, mid);
		
		//right
		shuffleDown(a, aux, mid + 1, end);
		
		//merge
		shuffleMerge(a, aux, start, mid, end);
		
	}

    //Helper method for shuffle()    
	private void shuffleMerge(Object[] a, Object[] aux, int start, int mid, int end) 
	{
		for (int i = start; i <= end; i++)
		{
			aux[i] = a[i];
		}
		
		int first = start, second = mid + 1;

		for (int i = start; i <= end; i++) 
		{
			if (first > mid) 
				a[i] = aux[first++];
			
			else if (second > end) 
				a[i] = aux[first++];
			
			else if (randomBool()) 
				a[i] = aux[second++];
			
			else a[i] = aux[first++];
		}
	}

    //Helper method for shuffle()
	private static boolean randomBool() 
	{
		Random rand = new Random();
		return rand.nextBoolean();
	}

	/**
     * entry point for sample output.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue<String> q1 = new ListQueue<>(); q1.enqueue("E"); q1.enqueue("L"); q1.enqueue("O"); q1.enqueue("R"); q1.enqueue("T");
        Queue<String> q2 = new ListQueue<>(); q2.enqueue("A"); q2.enqueue("E"); q2.enqueue("M"); q2.enqueue("P"); q2.enqueue("S"); q2.enqueue("X");
        Queue<Integer> q3 = new ListQueue<>(); q3.enqueue(5); q3.enqueue(12); q3.enqueue(15); q3.enqueue(17); q3.enqueue(20);
        Queue<Integer> q4 = new ListQueue<>(); q4.enqueue(1); q4.enqueue(4); q4.enqueue(12); q4.enqueue(13); q4.enqueue(16); q4.enqueue(18);

        MergingAlgorithms ma = new CompletedMerging();

        //Q1 - sample test cases
        Queue merged1 = ma.mergeQueues(q1, q2);
        System.out.println(merged1.toString());
        Queue merged2 = ma.mergeQueues(q3, q4);
        System.out.println(merged2.toString());
        
        //Q2 - sample test cases
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ma.sort(a);
        assert isSorted(a);
        show(a);
        
        //Q3 - sample test cases
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ma.shuffle(b);
        show(b);
        
        ma.shuffle(b);
        show(b);
    }

    //below are utilities functions, please do not change them.
        
    //sorting helper from text
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //sorting helper from text
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }
    
    //sorting helper from text
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        
        return true;
    }
}