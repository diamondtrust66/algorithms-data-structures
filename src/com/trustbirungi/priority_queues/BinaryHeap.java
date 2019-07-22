package com.trustbirungi.priority_queues;

import com.trustbirungi.sorts.SortingHelper;

/**
 * Class: BinaryHeap
 * Description: An implementation of a binary heap using a maximum-oriented unordered array of fixed size
 */
public class BinaryHeap<Key extends Comparable<Key>> {
    private Key[] binaryHeap;
    private int heapSize;

    public BinaryHeap(int capacity) {
        binaryHeap = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public void insert(Key key) {
        binaryHeap[heapSize++] = key; // insert the key at the end of the array
        swim(heapSize);
    }

    public Key deleteMax() {
        Key max = binaryHeap[1];

        SortingHelper.exchange(binaryHeap, 1, heapSize--); // use 1-based array indexing

        sink(1);

        binaryHeap[heapSize+1] = null;

        return max;
    }

    private void swim(int k) {
        while (k > 1 && SortingHelper.isLess(k/2, k)) {
            SortingHelper.exchange(binaryHeap, k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= heapSize) {
            int j = 2*k;

            if(j < heapSize && SortingHelper.isLess(j, j+1)) {
                j++;
            }

            if(!SortingHelper.isLess(k, j)) {
                break;
            }

            SortingHelper.exchange(binaryHeap, k, j);

            k = j;
        }
    }
}
