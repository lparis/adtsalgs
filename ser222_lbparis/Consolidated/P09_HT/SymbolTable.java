package edu.ser222.m03_04;

/**
 * Symbol table interface.
 * 
 * @author Sedgewick, Acuna
 * @param <Key> search key
 * @param <Value> return type
 */
public interface SymbolTable<Key, Value> {
    // put key-value pair into the table
    void put(Key key, Value val);
    
    //get value paired with key. returns null if key does not exist.
    Value get(Key key);
    
    //remove key (and its value) from table
    void delete(Key key);
    
    //is there a value paired with key?
    boolean contains(Key key);
    
    //is the table empty?
    boolean isEmpty();
    
    //number of key-value pairs
    int size();
    
    //all keys in the table. if st is empty, returns an empty iterable object (not a null).
    Iterable<Key> keys();
}
