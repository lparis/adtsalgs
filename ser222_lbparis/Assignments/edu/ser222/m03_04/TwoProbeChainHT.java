package edu.ser222.m03_04;

/**
 * TwoProbeChainHT defines an interface to a two probe chaining implementation of SymbolTable that
 * offers methods specific to a two probe chaining hashtable.
 *
 * Please note that these methods are only intended to enable effective grading. In practice, these
 * methods would be omitted from a hashtable ADT since they expose internal state.
 *
 * @author Acuna
 * @version 1.0
 * @param <Key> contained key type
 * @param <Value> contained value type
 */
public interface TwoProbeChainHT<Key, Value> extends SymbolTable<Key, Value> {

    /**
     * Returns the length of the internal array.
     *
     * @return The length of the internal array.
     */
    public int getM();

    /**
     * Returns the size of the chain at an index in the internal array. For example: if an index is
     * unused, it will return 0. If two key/value pairs have been added at the index, it will return
     * 2.
     *
     * @param i Array index.
     * @return Number of entries saved in list at index.
     */
    public int getChainSize(int i);

    /**
     * Computes the hash (will be used as an index) for a key.
     *
     * @param key Object to hash.
     * @return Hash value.
     */
    public int hash(Key key);

    /**
     * Computes the alternative hash (will be used as an index) for a key.
     *
     * @param key Object to hash.
     * @return Hash value.
     */
    public int hash2(Key key);
}
