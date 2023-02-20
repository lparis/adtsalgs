package edu.ser222.m01_01;


/**
 * This program provides an implementation of the Deque interface. Also provides a main that
 * demonstrates it.
 *
 * @author lbparis, Acuna
 * @version 1.0
 */

public class Node<Item>
{
	// Attributes
	Item item;
	Node<Item> prev;
	Node<Item> next;

	// Constructor
	public Node(Item item)
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
	public Node<Item> getPrev()
	{
		return prev;
	}

	// Set previous item
	public void setPrev(Node<Item> prev)
	{
		this.prev = prev;
	}

	// Get next item
	public Node<Item> getNext()
	{
		return next;
	}

	// Set next item
	public void setNext(Node<Item> next)
	{
		this.next = next;
	}
}
