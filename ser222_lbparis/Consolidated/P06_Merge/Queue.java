package edu.ser222.m02_02;

import java.util.NoSuchElementException;

/**
 * A simple queue interface.
 * 
 * @author Wedgewick and Wayne, Acuna
 * @version 1.1
 */
public interface Queue<Item> {
    
    /**
     * Add an item.
     * @param item an item
     */
    public void enqueue(Item item);
    
    /**
     * Remove the least recently added item.
     * @return an item
     */
    public Item dequeue() throws NoSuchElementException;
    
    /**
     * Return, but do not remove, the least recently added item.
     * @return an item
     */
    public Item peek() throws NoSuchElementException;

    /**
     * Is the queue empty?
     * @return if empty
     */
    public boolean isEmpty();
    
    /**
     * Number of items in the queue.
     * @return number of items
     */
    public int size();
}