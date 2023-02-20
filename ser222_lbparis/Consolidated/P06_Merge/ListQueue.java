package edu.ser222.m02_02;

import java.util.NoSuchElementException;

/**
 * A simple queue implementation. Uses list as internal representation. All 
 * operations are O(1).
 * 
 * @author Acuna
 * @version 1.1
 * @param <Item> item type
 */
public class ListQueue<Item> implements Queue<Item> {
    LinearNode<Item> tail; //back
    LinearNode<Item> head; //front
    private int count;

    public ListQueue() {
        head = tail = null;
        count = 0;
    } 

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void enqueue(Item item) {
     LinearNode newNode = new LinearNode(item);

        if(isEmpty())
            tail = newNode;
        else
            head.setNext(newNode);

        head = newNode;
        count++;
    }

    @Override
    public Item dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();

        Item result = tail.getElement();
        tail = tail.getNext();
        count--;
        
        if(isEmpty())
            head = null;

        return result;
    }

    @Override
    public Item peek() {
        if(isEmpty())
            throw new NoSuchElementException();

        return tail.getElement();
    }
    
    @Override
    public String toString()
    {
        LinearNode iter = tail;
        String result = "(tail) ";
        
        while(iter != null) {
            //result = iter.getElement() + " " + result;
            result = result + iter.getElement() + " ";
            iter = iter.getNext();
        }
            
        return result.trim();
    }

    @Override
    public int size() {
        return count;
    }
}