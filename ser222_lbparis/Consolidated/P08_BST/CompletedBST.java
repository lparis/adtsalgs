package edu.ser222.m03_02;

/**
 * A binary search tree based implementation of a symbol table.
 *
 * Completion time: 48 hours
 *
 * @author lbparis, Sedgewick, Acuna
 * @version 16.0
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
//import org.w3c.dom.Node;

public class CompletedBST<Key extends Comparable<Key>, Value> implements BST<Key, Value>
{
    private Node<Key, Value> root;

    @Override
    public int size()
    {
//    	System.out.println("Size = " + size(root));
        return size(root);
    }

    private int size(Node<Key, Value> x)
    {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    @Override
    public Value get(Key key)
    {
        Node<Key, Value> iter = root;

        while(iter != null) {
            int cmp = key.compareTo(iter.key);

            if (cmp < 0)
                iter = iter.left;
            else if (cmp > 0)
                iter = iter.right;
            else
                return iter.val;
        }

        return null;
    }

    private Value get(Node<Key, Value> x, Key key)
    {
        // Return value associated with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x.
        if (x == null) 
        	return null;
        
        int cmp = key.compareTo(x.key);
        
        if (cmp < 0) 
        	return get(x.left, key);
        
        else if (cmp > 0) 
        	return get(x.right, key);
        
        else return x.val;
    }

    @Override
    public void put(Key key, Value val)
    {
        root = put(root, key, val);
    }

    private Node<Key, Value> put(Node<Key, Value> x, Key key, Value val)
    {
        if (x == null)
            return new Node<Key, Value>(key, val, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    @Override
    public Key min()
    {
        if(root == null)
            throw new NoSuchElementException();
        return min(root).key;
    }

    private Node<Key, Value> min(Node<Key, Value> x)
    {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    @Override
    public Key max()
    {
        if(root == null)
            throw new NoSuchElementException();
        return max(root).key;
    }

    private Node<Key, Value> max(Node<Key, Value> x)
    {
    if (x.right == null) 
    	return x;
    return min(x.right);
    }

    @Override
    public Key floor(Key key)
    {
        if(root == null)
            throw new NoSuchElementException();

        Node<Key, Value> x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    private Node<Key, Value> floor(Node<Key, Value> x, Key key)
    {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) 
        	return x;
        if (cmp < 0) 
        	return floor(x.left, key);
        Node<Key, Value> t = floor(x.right, key);
        if (t != null) 
        	return t;
        else 
        	return x;
    }

    @Override
    public Key select(int k)
    {
        return select(root, k).key;
    }

    private Node<Key, Value> select(Node<Key, Value> x, int k) {
        if (x == null) 
        	return null;
        int t = size(x.left);
        if (t > k) 
        	return select(x.left, k);
        else if (t < k) 
        	return select(x.right, k - t - 1);
        else 
        	return x;
    }

    @Override
    public int rank(Key key)
    {
        return rank(key, root);
    }

    private int rank(Key key, Node<Key, Value> x)
    {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) 
        	return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) 
        	return rank(key, x.left);
        else if (cmp > 0) 
        	return 1 + size(x.left) + rank(key, x.right);
        else 
        	return size(x.left);
    }

    @Override
    public void deleteMin()
    {
        if(root == null)
            throw new NoSuchElementException();
        root = deleteMin(root);
    }

    private Node<Key, Value> deleteMin(Node<Key, Value> x)
    {
        if (x.left == null) 
        	return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key)
    {
        root = delete(root, key);
    }

    private Node<Key, Value> delete(Node<Key, Value> x, Key key)
    {
        if (x == null) 
        	return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) 
        	x.left = delete(x.left, key);
        else if (cmp > 0) 
        	x.right = delete(x.right, key);
        else
        {
            if (x.right == null) 
            	return x.left;
            if (x.left == null) 
            	return x.right;
            Node<Key, Value> t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<Key> keys()
    {
        if (root == null)
            return new LinkedList<>();
        else
            return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node<Key, Value> x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) 
        	return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) 
        	keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) 
        	queue.add(x.key);
        if (cmphi > 0) 
        	keys(x.right, queue, lo, hi);
    }

    @Override
	public Key ceiling(Key key)
    {
//        Node<Key, Value> n = ceiling(root, key);
        
//        if (n == null)
        	return null;
        
//        return n.key;
    }

    public Node<Key, Value> getRoot()
    {
        return root;
    }

    //IMPLEMENTED
    @Override
	public boolean contains(Key key)
    {
        return get(key) != null;
    }

    //IMPLEMENTED
    @Override
	public boolean isEmpty()
    {
        if (size() == 0)
        	return true;
        else
        	return false;
    }

    //IMPLEMENTED
    @Override
	public void deleteMax()
    {
        // Recursive call to the deleteMax() method
    	root = deleteMax(root);
    }

    //IMPLEMENTED
    // Method deleteMax() implementation
    private Node<Key, Value> deleteMax(Node<Key, Value> n)
    {
		// Check if empty
        if(n == null)
            throw new NoSuchElementException();

    	if (n.right == null)
    		return n.left;

    	n.right = deleteMax(n.right);

    	n.N = size(n.left) + size(n.right) + 1;

    	return n;
    }

    //IMPLEMENTED
    // Size method    
    @Override
	public int size(Key lo, Key hi)
    {
    	if (lo.compareTo(hi) > 0)
    		return 0;

    	if (contains(hi))
    		return rank(hi) - rank(lo) + 1;

    	else
    		return rank(hi) - rank(lo);
    }
    
    //IMPLEMENTED
	/*
     * Search for key and update value if found;
     * Grow table if new
     */
    @Override
	public void putFast(Key key, Value val)
    {
    	
    	if (root == null)
    	{
    		root = new Node<Key, Value>(key, val, 1);
    	}
    	
    	else
    	{
    		Node<Key, Value> node = root;
    		Node<Key, Value>parent = null;
    		
    		while (node != null)
    		{
    			parent = node;
    			
    			if (key.compareTo(node.key) < 0)
    			{
    				node = node.left;
    			}
    			
    			else if (key.compareTo(node.key) > 0)
    			{
    				node = node.right;
    			}
    			
    			else
    			{
    				node.val = val;
    				return;
    			}
    		}
    		
    		node = root;
    		while (node != null)
    		{
    			node.N = node.N + 1;
    			
    			if (key.compareTo(node.key) < 0)
    			{
    				node = node.left;
    			}
    			else if (key.compareTo(node.key) > 0)
    			{
    				node = node.right;
    			}
    		}
    		
    		Node<Key, Value> newNode = new Node<Key, Value>(key, val, 1);
    		
    		if (key.compareTo(parent.key) < 0)
    			parent.left = newNode;
    		
    		else
    			parent.right = newNode;
    	}
    }
        
    //IMPLEMENTED
    @Override
	public Value getFast(Key key)
    {
    	Node<Key, Value> n = root;
    	while (n != null)
    	{
    		int value = key.compareTo(n.key);
    		
    		if (value == 0)
    			return n.val;
    		
    		else if (value <0)
    			n = n.left;
    		
    		else
    			n = n.right;
    	}
    	return null;
    }

    //IMPLEMENTED
    /*
     * The balance() method balances an existing BST.
     * A BST is balanced if the height of its left and right sub-trees are different by at most one.
     * Recursively applied.
     * 
     * balance() creates a LinkedList of Nodes and 
     * calls the sortNodes method to sort the nodes
     */
    @Override
	public void balance()
    {
    	LinkedList<Node<Key, Value>> nodes = new LinkedList<Node<Key, Value>>();

    	sortNodes(nodes, root);

    	root = balanceTree(nodes, 0, size() - 1);   	
    }

    //IMPLEMENTED
    /*
     * Sort the nodes in order
     */
    private void sortNodes(LinkedList<Node<Key, Value>> nodes, Node<Key, Value> n) 
    {
    	if (n == null)
    		return;
    	
    	sortNodes(nodes, n.left);
    	
    	nodes.add(n);
    	
    	sortNodes(nodes, n.right);
	}

    //IMPLEMENTED
	private Node<Key, Value> balanceTree(LinkedList<Node<Key, Value>> nodes, int start, int end)
    {
		if (start > end)
			return null;

		int middle = (start + end) / 2;

		if ((start + end) % 2 == 1)
			middle++;

		Node<Key, Value> middleNode = nodes.get(middle);

		middleNode.left = balanceTree(nodes, start, middle - 1);

		middleNode.right = balanceTree(nodes, middle + 1, end);

		return middleNode;
	}

    //IMPLEMENTED
	/*
     * Write a method displayLevel(Key key) that takes a Key as argument and
     * prints the values in the subtree rooted at that node in level order
     * (in order of their distance from the root, with nodes on each level
     * in order from left to right). Hint: Use a Queue.
     */

    @Override
	public String displayLevel(Key key)
    {
    	
        Node<Key, Value> node = root;
        
        while (node != null)
        {
        	int value = key.compareTo(node.key);

        	if (value < 0)
        		node = node.left;

        	else if (value > 0)
        			node = node.right;

        	else
        		break;
        }

        Queue<Node<Key, Value>> queue = new LinkedList<Node<Key, Value>>();

        queue.add(node);

        while (!queue.isEmpty())
        {
        	node = queue.poll();
        	
        	System.out.print(" " + node.val);
            
//        	Value v = get(node, key);
//        	System.out.print(" " + v);
        	
        	if (node.left != null)
        	{
        		queue.add(node.left);
        	}

        	if (node.right != null)
        	{
        		queue.add(node.right);
        	}
        }
        
        /*
         * @return the level order string representation of the tree
         */
        return  " ";
    }

    /**
     * entry point for testing.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BST<Integer, String> bst = new CompletedBST<Integer, String>();

        bst.put(10, "TEN");
        bst.put(3, "THREE");
        bst.put(1, "ONE");
        bst.put(5, "FIVE");
        bst.put(2, "TWO");
        bst.put(7, "SEVEN");

        System.out.println("Before balance:");
        System.out.println(bst.displayLevel(10)); //root

        System.out.println("After balance:");
        bst.balance();
        System.out.println(bst.displayLevel(5)); //root
    }
}