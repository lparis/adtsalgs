// package edu.ser222.m01_03;

package M3_List

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ListADT defines the interface to a general list collection. Specific types of lists will extend
 * this interface to complete the set of necessary operations.
 *
 * @author Lewis and Chase, Acuna
 * @version 5.1
 */
public interface ListADT<T> extends Iterable<T>
{
    /**  
     * Removes and returns the first element from this collection.
     * 
     * @return the first element from this collection
     * @throws NoSuchElementException if the collection is empty
     */
    T removeFirst() throws NoSuchElementException;

    /**  
     * Removes and returns the last element from this collection.
     *
     * @return the last element from this collection
     * @throws NoSuchElementException if the collection is empty
     */
    T removeLast() throws NoSuchElementException;

    /**  
     * Removes and returns the specified element from this collection.
     *
     * @param element the element to be removed from the collection
     * @throws NoSuchElementException if the target is not in the collection
     */
    T remove(T element);

    /**  
     * Returns, without removing, the first element in the collection.
     *
     * @return a reference to the first element in this collection
     * @throws NoSuchElementException if the collection is empty
     */
    T first();

    /**  
     * Returns, without removing, the last element in the collection.
     *
     * @return a reference to the last element in this collection
     * @throws NoSuchElementException if the collection is empty
     */
    T last();

    /**  
     * Returns true if this collection contains the specified target element, false otherwise.
     *
     * @param target the target that is being sought in the collection
     * @return true if the collection contains this element
     */
    boolean contains(T target);

    /**  
     * Returns true if this collection is empty and false otherwise.
     *
     * @return true if this collection empty
     */
    boolean isEmpty();

    /**  
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    int size();

    /**  
     * Returns an iterator for the elements in this collection. The returned object must have implementations of hasNext() and next() that throw ConcurrentModificationException when the contents of the list change. 
     *
     * @return an iterator over the elements in this collection
     */
    Iterator<T> iterator();

    /**  
     * Returns a string representation of this collection. If the list is empty, returns "empty".
     *
     * @return a string representation of this collection
     */
    String toString();
}