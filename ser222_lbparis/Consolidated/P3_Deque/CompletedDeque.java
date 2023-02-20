// package edu.ser222.m01_03;

package M2_Deque

import java.util.NoSuchElementException;

/**
 * This program provides an implementation of the Deque interface. Also provides a main that
 * demonstrates it.
 * 
 * @author lbparis, Acuna
 * @version 2.0
 */

public class CompletedDeque<Item> implements Deque<Item> 
{	
	// Private attributes
	private DoubleLinearNode<Item> head;
	private DoubleLinearNode<Item> tail;
	private int size;
	
	// Constructor to initialize empty deque
    public CompletedDeque() 
    {
    	head = null;
    	tail = null;
    	size = 0;
    }
	
    /**  
     * Adds one element to the front of this deque. 
     * @param element the element to be added to the front of the deque  
     */
	@Override
	public void enqueueFront(Item element) 
	{
		// Create Node object with element
		DoubleLinearNode<Item> node = new DoubleLinearNode<Item>(element);
		
		// Set as head and tail if head is null (thus empty deque)
		if(head == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			// Add before head node and update head node
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
		
		// Increment the size of deque
		size++;
	}
	
    /**  
     * Adds one element to the back of this deque. 
     * @param element the element to be added to the back of the deque  
     */
	@Override
	public void enqueueBack(Item element) 
	{
		// Create a node object with element
		DoubleLinearNode<Item> node = new DoubleLinearNode<Item>(element);
		
		// Set as head and tail if tail is null empty deque
		if(tail == null)
		{
			head = node;
			tail = node;
		}
		else
		{
			// Add after tail node and update tail node
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
		}
		
		// Increment deque size
		size++;
	}

    /**  
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */	
	@Override
	public Item dequeueFront() throws NoSuchElementException 
	{
		// Check if deque is empty
		if(head == null)
		{
			throw new NoSuchElementException("Deque is empty");
		}
		
		// Get item at head node, and store in a variable
		Item item = head.getItem();
		
		// Updating head node
		head = head.getNext();
		
		// Update tail node to null if deque is empty
		if(head == null)
		{
			tail = null;
		}
		else
		{
			// Remove previous node
			head.setPrev(null);
		}
		
		// Decrement deque size
		size--;
		
		// Return the item
		return item;
	}

    /**  
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     * @return the element at the back of the deque. 
     * @throws NoSuchElementException if the deque is empty
     */	
	@Override
	public Item dequeueBack() throws NoSuchElementException 
	{
		// Check if deque is empty
		if(tail == null)
		{
			throw new NoSuchElementException("Deque is empty");
		}
		
		// Get item at tail node, and store in a variable
		Item item = tail.getItem();
		
		// Updating tail node
		tail = tail.getPrev();
		
		// Update head and tail to null if deque is empty
		if(tail == null)
		{
			head = null;
		}
		else
		{
			// Remove next node from tail
			tail.setNext(null);
		}
		
		// Decrement deque size
		size--;
		
		// Return the item
		return item;
	}

    /**  
     * Returns, without removing, the element at the front of this deque.
     * Should throw an exception if the deque is empty.
     * @return the first element in the deque
     * @throws NoSuchElementException if the deque is empty
     */	
	@Override
	public Item first() throws NoSuchElementException 
	{
		if(head == null)
		{
			throw new NoSuchElementException("Deque is empty");
		}
		
		// Get item at head node
		Item item = head.getItem();
		
		// Return item
		return item;
	}

    /**  
     * Returns, without removing, the element at the back of this deque.
     * Should throw an exception if the deque is empty.
     * @return the last element in the deque
     * @throws NoSuchElementException if the deque is empty
     */	
	@Override
	public Item last() throws NoSuchElementException 
	{
		if(tail == null)
		{
			throw new NoSuchElementException("Deque is empty");
		}
		
		// Get item at tail node
		Item item = tail.getItem();
		
		// Return item
		return item;

	}

    /**  
     * Returns true if this deque is empty and false otherwise.
     * @return if deque empty
     */	
	@Override
	public boolean isEmpty() 
	{
		// Deque is empty if head or tail is null
		return head == null || tail == null;
	}

    /**  
     * Returns the number of elements in this deque. 
     * @return the number of elements in the deque
     */	
	@Override
	public int size() 
	{
		// Return the size of deque
		return size;
	}

    /**  
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     * @return the string representation of the deque
     */
	@Override
	public String toString() 
	{
		String result = "";
		
		if(isEmpty())
		{
			// Result is empty
			result = "empty";
		}
		else
		{
			// Get last node
			DoubleLinearNode<Item> node = tail;
			
			// Construct the result string with each node value
			while (node != null)
			{
				result += node.getItem() + " ";
				node = node.getPrev();
			}
		}
		
		// Return the result string
		return result;
	}

    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        CompletedDeque<Integer> deque = new CompletedDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }
} 