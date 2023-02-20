package edu.ser222.m03_02;

/**
 * BST defines an interface to a BST implementation of OrderedSymbolTable that offers methods
 * specific to trees.
 *
 * @author Acuna
 * @version 1.0
 * @param <Key> contained key type
 * @param <Value> contained value type
 */
public interface BST<Key, Value> extends OrderedSymbolTable<Key, Value>{

    /**
     * Puts a key value pair into the tree. If key already exists, then only updates value.
     * @param key key to add
     * @param val value for key
     */
    void putFast(Key key, Value val);

    /**
     * Returns the value paired with a key in the tree. Returns null if key does not exist.
     * @param key key to find
     * @return value of key
     */
    Value getFast(Key key);

    /**
     * Returns a string representation of the tree. The ordering is a level traversal of the tree,
     * and each node's value is separated by a space. If there is no valid subtree rooted at the
     * given key, returns "empty".
     * @return the level order string representation of the tree
     */
    public String displayLevel(Key key);

    public void balance();

    /**
     * Returns the root node of the BST.
     * @return the root node
     */
    public Node<Key, Value> getRoot();
}
