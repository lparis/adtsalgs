package edu.ser222.m01_01;


/**
 * This program creates a doubly linked list data structure.
 * It is a separate node class called DoubleLinearNode that goes with CompletedDeque.
 *
 * @author lbparis, Acuna
 * @version 1.0
 */

public class DoubleLinearNode<Item>
{

	// Attributes
	Item item;
	DoubleLinearNode<Item> prev;
	DoubleLinearNode<Item> next;

	// Constructor
	public DoubleLinearNode(Item item)
	{
		this.item = item;
		prev = null;
		next = null;
	}

	// Get item
	public Item getItem()
	{
		return item;
	}

	// Set item
	public void setItem(Item item)
	{
		this.item = item;
	}

	// Get previous item
	public DoubleLinearNode<Item> getPrev()
	{
		return prev;
	}

	// Set previous item
	public void setPrev(DoubleLinearNode<Item> prev)
	{
		this.prev = prev;
	}

	// Get next item
	public DoubleLinearNode<Item> getNext()
	{
		return next;
	}

	// Set next item
	public void setNext(DoubleLinearNode<Item> next)
	{
		this.next = next;
	}

	public void remove() {
		// TODO Auto-generated method stub

	}
}
