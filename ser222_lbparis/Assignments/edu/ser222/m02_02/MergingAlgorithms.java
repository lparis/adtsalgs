/**
 * Defines various divide and conquer algorithms.
 *
 * @author Acuna
 * @verison 1.1
 */
package edu.ser222.m02_02;

public interface MergingAlgorithms {

    /**
     * Merges sorted queues. Takes two sorted queues as input, and returns a queue containing the
     * elements in sorted order. Input queues may be emptied afterward. Assumes input does not
     * contain nulls.
     * @param q1 first queue
     * @param q2 second queue
     * @return merged queue
     */
    public <T extends Comparable> Queue<T> mergeQueues(Queue<T> q1, Queue<T> q2);

    /**
     * Sorts the contents of an array. Array is sorted in-place. Uses a mergesort approach involving
     * helper methods mergesort(), and merge(). Assumes input does not contain nulls.
     * @param a Array to sort.
     */
    public void sort(Comparable[] a);

    /**
     * Implementation of mergesort. Only uses arrays as parameters, not integer indices. Assumes
     * input does not contain nulls.
     *
     * @param a array to sort
     * @return sorted array
     */
    public Comparable[] mergesort(Comparable[] a);

    /**
     * Merges two sorted arrays into one. Types must match between input arrays. Input arrays must
     * not change, or be returned as the result. Assumes input does not contain nulls.
     * @param a first array to merge
     * @param b second array to merge
     * @return merged array
     */
    public Comparable[] merge(Comparable[] a, Comparable[] b);

    /**
     * Shuffles an array in nlog(n) time using a recursive merging mechanism. It must be possible
     * for any element to reposition to any other position. Assumes input does not contain nulls.
     * @param a an array
     */
    public void shuffle(Object[] a);
}
