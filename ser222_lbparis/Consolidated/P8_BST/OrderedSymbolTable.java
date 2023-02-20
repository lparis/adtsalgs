package edu.ser222.m03_02;

/**
 * Ordered symbol table interface.
 * 
 * @author Sedgewick, Acuna
 * @param <Key> search key
 * @param <Value> return type
 */
public interface OrderedSymbolTable<Key, Value> extends SymbolTable<Key, Value> {

    /**
     * Returns the minimum key.
     * @throws NoSuchElementException if the ST is empty
     * @return minimum key.
     */
    Key min();

    /**
     * Returns the maximum key.
     * @throws NoSuchElementException if the ST is empty
     * @return maximum key.
     */
    Key max();

    /**
     * Returns largest key less than or equal to key. If no such key exists, returns null.
     * @throws NoSuchElementException if the ST is empty
     * @param key target floor
     * @return closest key
     */
    Key floor(Key key);

    /**
     * Returns smallest key greater than or equal to key. If no such key exists, returns null.
     * @throws NoSuchElementException if the ST is empty
     * @param key target floor
     * @return closest key
     */
    Key ceiling(Key key);

    /**
     * Returns number of keys less than key.
     * @param key target key
     * @return rank
     */
    int rank(Key key);

    /**
     * Returns key of rank k.
     * @param k target rank
     * @return key
     */
    Key select(int k);

    /**
     * Delete smallest key.
     * @throws NoSuchElementException if the ST is empty
     */
    void deleteMin();

    /**
     * Deletes largest key.
     * @throws NoSuchElementException if the ST is empty
     */
    void deleteMax();

    /**
     * Returns the number of keys in [lo..hi].
     * @param lo begining of range
     * @param hi end of range
     * @return number of keys
     */
    int size(Key lo, Key hi);

    /**
     * Returns all keys in [lo..hi] in sorted order.
     * @param lo begining of range
     * @param hi end of range
     * @return Iterable container of keys.
     */
    Iterable<Key> keys(Key lo, Key hi);
}