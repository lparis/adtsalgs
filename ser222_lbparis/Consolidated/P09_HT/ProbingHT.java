package edu.ser222.m03_04;

/**
 * ProbingHT defines an interface to a probing (linear or quadratic) implementation of SymbolTable
 * that offers methods specific to a probing hashtable.
 *
 * Please note that these methods are only intended to enable effective grading. In practice, these
 * methods would be omitted from a hashtable ADT since they expose internal state.
 *
 * @author Acuna
 * @version 1.0
 * @param <Key> contained key type
 * @param <Value> contained value type
 */
public interface ProbingHT<Key, Value> extends SymbolTable<Key, Value> {

    /**
     * Returns the length of the internal array.
     *
     * @return The length of the internal array.
     */
    public int getM();

    /**
     * Returns the object being stored at an index in the internal array. If index is not used, it
     * must return null.
     *
     * @param i Array index.
     * @return Number of entries saved in list at index.
     */
    public Object getTableEntry(int i);

    /**
     * Computes the hash (will be used as an index) for a key.
     *
     * @param key Object to hash.
     * @return Hash value.
     */
    public int hash(Key key, int i);
}
