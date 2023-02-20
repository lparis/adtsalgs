package edu.ser222.m03_02;

/**
 * A class to represent a node in a binary search tree.
 *
 * @author Sedgewick, Acuna
 * @version 1.0
 * @param <Key> contained key type
 * @param <Value> contained value type
 */
public class Node<Key, Value>  {
    public final Key key;
    public Value val;
    public Node<Key, Value> left, right;
    public int N;

    public Node(Key key, Value val, int N) {
        this.key = key; this.val = val; this.N = N;
    }
}