package edu.ser222.m01_03;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * CompletedList represents an implementation of a list.
 *
 * @author lbparis, Acuna
 * @version 2.0
 */
public class CompletedList<T> implements ListADT<T>, Iterable<T>
{
	// Instance variables
    protected int count;
    protected int modChange;
    protected DoubleLinearNode<T> head, tail;

    // Constructor
    public CompletedList()
    {
    	head = tail = null;
    	count = 0;
    }

    // Removes the first element from the list
    @Override
    public T removeFirst() throws NoSuchElementException
    {
    	if(isEmpty())
    		throw new java.util.NoSuchElementException("The list is empty");

    	T temp = head.getItem();

    	if(head == tail)
    	{
    		head = tail = null;
    	}

    	else if(head.getNext() == tail)
    	{
    		head.remove();
			head = tail;
    	}

    	else
    	{
    		head = head.getNext();
    		head.getPrev().remove();
    	}

    	count--;
    	modChange++;
    	return temp;
    }

    // Removes the last element from the list
    @Override
    public T removeLast() throws NoSuchElementException
    {
    	if(isEmpty())
    		throw new java.util.NoSuchElementException("The list is empty");

    	T temp = tail.getItem();

    	if(head == tail)
    	{
    		head = tail = null;
    	}

    	else if(head.getNext() == tail)
    	{
    		tail.remove();
			tail = head;
    	}

    	else
    	{
    		tail = tail.getPrev();
    		tail.getNext().remove();
    	}

    	count--;
    	modChange++;
    	return temp;
    }

    // Removes a particular element from the list
    @Override
    public T remove(T element)
    {
        if(isEmpty())
            throw new NoSuchElementException("The item is not in the list");

        if(tail.getItem().equals(element))
        {
            return removeLast();
        }

        for (DoubleLinearNode<T> current = head; current != null; current = current.getNext())
        {
            if(current.getItem().equals(element))
            {
                if(current == head)
                {
                    return removeFirst();
                }
                else
                {
                    count--;
                    modChange++;
                    return current.remove();
                }
            }
        }
        throw new NoSuchElementException("The item is not in the list");
    }

    // Examines the element at the front of the list
    @Override
    public T first()
    {
    	if(isEmpty())
    		throw new NoSuchElementException("The list is empty");

    	return head.getItem();
    }

    // Examines the element at the rear of the list
    @Override
    public T last()
    {
    	if(isEmpty())
    		throw new NoSuchElementException("The list is empty");

    	return tail.getItem();
    }

    // Determines if a particular element is in the list
    @Override
    public boolean contains(T target)
    {
    	if(isEmpty())
    		return false;

    	if(tail.getItem().equals(target))
    	{
    		return true;
    	}

    	for (DoubleLinearNode<T> current = head; current != null; current = current.getNext())
    	{
    		if(current.getItem().equals(target))
    		{
    			return true;
    		}
    	}
    	return false;
    }

	// Determines whether the list is empty
	@Override
	public boolean isEmpty()
	{
		return count == 0;
	}

	// Determines the number of elements in the list
	@Override
	public int size()
	{
		return count;
	}

	/*
	 * Returns an iterator for the list's elements
	 */
	@Override
	public Iterator<T> iterator()
	{
		return new ListIterator(head);
	}

    // Returns a string representation of the list
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();

		for (DoubleLinearNode<T> current = head; current != null; current = current.getNext())
		{
			string.append(current.getItem()).append(' ');
		}

		return string.toString();
	}

	/*
	 * ListIterator class implements the Iterator<T> interface.
	 * ListIterator is implemented as a private inner class.
	 */
	private class ListIterator implements Iterator<T>
	{
		private DoubleLinearNode<T> current;
		private int modNum;

		public ListIterator(DoubleLinearNode<T> node)
		{
			this.modNum = modChange;
			this.current = node;
		}

		// Returns true if next() would return an element rather than throwing an exception
		@Override
		public boolean hasNext()
		{
			if(this.modNum != modChange)
				throw new ConcurrentModificationException("The list has been modified");

			if(this.current != null)
			{
				return this.current.getNext() != null;
			}

			else
			{
				return false;
			}
		}

		// Returns the next element in the iteration
		@Override
		public T next()
		{
			if(!this.hasNext())
				throw new NoSuchElementException();

			this.current = this.current.getNext();

			return this.current.getItem();
		}

		// Removes from the underlying collection the last element returned by this iterator
		@Override
		public void remove()
		{
			if(current == head)
			{
				modNum++;
				removeFirst();
				current = head;
			}

			else if(current == tail)
			{
				modNum++;
				removeLast();
				current = tail;
			}

			else
			{
				modNum++;
				modChange++;
				current = current.getNext();
				current.getPrev().remove();
			}
		}
	}
}