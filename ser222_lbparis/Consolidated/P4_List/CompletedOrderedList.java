// package edu.ser222.m01_03;

package M3_List

/**
 * CompletedOrderedList represents an implementation of an ordered list that builds on
 * CompletedList.
 *
 * @author lbparis, Acuna
 * @version 2.0
 */

// Class that extends CompletedList by adding a method to add new elements
// Implements the Comparable interface to compare elements for ordering
public class CompletedOrderedList<T extends Comparable<T>> extends CompletedList<T>
         implements OrderedListADT<T> 
{
	// Constructor that uses the constructor from parent CompletedList
	// Ordered Linked List that implements the OrderedListADT interface
	public CompletedOrderedList()
	{
		super();
	}
	
	// Adds elements to a list in the correct order/place in the collection
    @Override
    public void add(T element) throws NullPointerException 
    {
        if(element == null)
            throw new NullPointerException("Element cannot be null");
        
        if(isEmpty()) 
        {
            head = new DoubleLinearNode<>(element);
            tail = head;
            count++;
            modChange++;
        }
        
        else
        {
            count++;
            modChange++;
            DoubleLinearNode<T> front = head;
            DoubleLinearNode<T> back = tail;
            DoubleLinearNode<T> newNode = new DoubleLinearNode<>(element);
        
            // Check if the element is less than the head or greater than the tail
            if(element.compareTo(front.getItem()) <= 0) 
            {
                newNode.setNext(front);
                head = newNode;
                return;
            }
            
            else if(element.compareTo(back.getItem()) >= 0) 
            {
                newNode.setPrev(back);
                tail = newNode;
                return;
            }
            
            // Traverse the list from both ends until the position is found
            while((front = front.getNext()) != (back = back.getPrev())) 
            {
                if(element.compareTo(front.getItem()) <= 0) 
                {
                    front.setPrev(newNode);
                    return;
                }
                else if(element.compareTo(back.getItem()) >= 0) 
                {
                    back.setNext(newNode);
                    return;
                }
                if(back.getPrev() == null) {
                    System.out.println("Back is null");
                }
            }
            
            // Check to see where the element should be placed
            switch(element.compareTo(front.getItem())) 
            {
                case -1:
                    front.getPrev().setNext(newNode);
                    break;
                case 0:
                    front.setPrev(newNode);
                    break;
                case 1:
                    front.getNext().setPrev(newNode);
                    break;
            }
        }
    }
    
    // Check if the list contains the target element
    @Override
    public boolean contains(T target) 
    {
        if(isEmpty())
            return false;
        
        DoubleLinearNode<T> front = head;
        
        DoubleLinearNode<T> back = tail;
        
        if(target.compareTo(front.getItem()) == 0)
            return true;
        
        if(target.compareTo(back.getItem()) == 0)
            return true;
        
        while((front = front.getNext()) != (back = back.getPrev())) 
        {
            if(target.compareTo(front.getItem()) == 0)
                return true;
            if(target.compareTo(back.getItem()) == 0)
                return true;
        }
        
        return false;
    }
}
