package symbol_table;

/******************************************************************************
 *  Compilation:  javac BinarySearchST.java
 *  Execution:    java BinarySearchST
 *
 *  Symbol table implementation with ordered array. Uses repeated
 *  doubling to resize the array.
 *
 *  % java BinarySearchST
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *
 *
 ******************************************************************************/


public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_SIZE = 8;

    private Value[] vals;    // symbol table values
    private Key[] keys;      // symbol table keys
    private int n = 0;       // number of elements

    public BinarySearchST() {
        this(INIT_SIZE);
    }

    public BinarySearchST(int initCapacity) {
        vals = (Value[]) new Object[initCapacity];
        keys = (Key[]) new Comparable[initCapacity];
    }


    public boolean isEmpty() { return n == 0; }
    public int     size()    { return n;      }

    // double the size of the arrays
    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        for (int i = 0; i < n; i++)
            tempk[i] = keys[i];
        keys = tempk;
        vals = tempv;
    }

    // add key-value pair
    public void put(Key key, Value val) {
        if (n >= vals.length) resize(2*n);

        // duplicate
        if (contains(key)) {
            int i = bsearch(key);
            vals[i] = val;
            return;
        }

        // shift key-value pairs one position to right, and add new key-value pair
        int i = n;
        while ((i > 0) && (key.compareTo(keys[i-1]) < 0)) {
            keys[i] = keys[i-1];
            vals[i] = vals[i-1];
            i--;
        }
        vals[i] = val;
        keys[i] = key;
        n++;
    }

    // does symbol table contain given key?
    public boolean contains(Key key) {
        int i = bsearch(key);
        return i >= 0;
    }

    // return value associated with given key, or null if no such key
    public Value get(Key key) {
        int i = bsearch(key);
        if (i == -1) return null;
        return vals[i];
    }

    // binary search in interval [lo, hi]
    private int bsearch(Key key) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    // all keys, as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }
}