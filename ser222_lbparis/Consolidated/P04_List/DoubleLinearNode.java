// package edu.ser222.m01_03;

package M3_List

/**
 * DoubleLinearNode creates a doubly linked list.
 *
 * @author lbparis, Acuna
 * @version 2.0
 */

public class DoubleLinearNode <Item>
{
    private final Item item;
    private DoubleLinearNode<Item> next;
    private DoubleLinearNode<Item> prev;

    public DoubleLinearNode(Item item) 
    {
    	this.item = item;
    	this.next = null;
    	this.prev = null;
    }

    public Item getItem() 
    {
        return item;
    }

    public DoubleLinearNode<Item> getNext() 
    {
        return next;
    }

    public void setNext( DoubleLinearNode<Item> node) 
    {
        if(this.next != null) 
        
        {
            this.next.prev = node;
            node.next = this.next;
        }
        
        this.next = node;
        
        if(node != null)
            node.prev = this;
    }

    public DoubleLinearNode<Item> getPrev()
    {
        return this.prev;
    }

    public void setPrev(DoubleLinearNode<Item> node)
    {
        if(this.prev != null)  
        {
            this.prev.next = node;
            node.prev = this.prev;
        }
        
        this.prev = node;
        
        if(node != null) 
        {
            node.next = this;
        }
    }

    public Item remove()
    {
        if(this.prev != null)
            this.prev.next = this.next;
        
        if(this.next != null)
            this.next.prev = this.prev;
        
        return this.item;
    }
}
