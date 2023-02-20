package arrays;
import java.util.Arrays;
import java.util.Queue;

public class MinPQ 
{
	// Class members
	private int[] queueData;
	private int maxSize;
	private int front;
	private int rear;
	private int currentSize;
	
	// Class constructor
	public MinPQ(int size) 
	{
		this.maxSize = size;
		this.queueData = new int[size];
		front = 0;
		rear = -1;
		currentSize = 0;
	}
	
	// Queue insert
	public void insert(int item)
	{
		// Check if queue is full by calling the method isMinPQFull()
		if(isQueueFull())
		{
			System.out.println("Queue is full!");
			return;
		}
		
		if(rear == maxSize -1)
		{
			rear = -1;
		}
		
		// Increment the rear then insert item
		queueData[++rear] = item;
		currentSize++;
		System.out.println("Item added to queue: " + item);
	}

	// Boolean to check if queue is full
	private boolean isQueueFull() 
	{
		//Check if current size = max size 
		return (maxSize == currentSize);
	}
	
	// Queue delete
	public int delete()
	{
		if (isQueueEmpty())
		{
			throw new RuntimeException("Queue is empty");
		}
		
		// Retrieve queue element and then increment 
		int temp = queueData[front++];
		
		if (front == maxSize)
		{
			front = 0;
		}
		
		currentSize--;
		return temp;
	}
	
	// Boolean to check if queue is empty
	private boolean isQueueEmpty() 
	{
		return (currentSize == 0);
	}
	
	// Queue peek operation
	public int peek()
	{
		return queueData[front];
	}
	
	// Display queue
	public String display()
	{
		String queueDataString = null;
		
		queueDataString = Arrays.toString(queueData);
		
		return queueDataString;
	}

	// Driver code
	public static void main(String[] args) 
	{
		MinPQ minpq1 = new MinPQ(10);

		System.out.println("Queue contents: " + minpq1.display());		

		minpq1.insert(2);
		minpq1.insert(3);

		System.out.println("Item at the front of the queue: " + minpq1.peek());		
		System.out.println("Queue contents: " + minpq1.display());		
				
		System.out.println("Item deleted from queue: " + minpq1.delete());
		System.out.println("Item deleted from queue: " + minpq1.delete());

		System.out.println("Item at the front of the queue: " + minpq1.peek());		
		System.out.println("Queue contents: " + minpq1.display());		
		
		minpq1.insert(5);
		
		System.out.println("Item deleted from queue: " + minpq1.delete());
		System.out.println("Item at the front of the queue: " + minpq1.peek());
	}
}
