package com.trustbirungi.priority_queues;

import com.trustbirungi.sorts.SortingHelper;

/**
 * Class: UnorderedMaxPriorityQueue
 * Description: An implementation of a maximum-oriented priority queue using an unordered array
 */
public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> {
    private Key[] priorityQueue; // priorityQueue[i] = ith element on the priority queue
    private int pqSize; // the number of elements on the priority queue

    // constructor for creating a new priority queue
    // @param capacity - the size of the unordered array. This can be replaced with a resizing array
    public UnorderedMaxPriorityQueue(int capacity) {
        priorityQueue = (Key[]) new Comparable[capacity];
    }

    public void insert(Key key) {
        priorityQueue[pqSize++] = key; // insert the key at the end of the array
    }

    public boolean isEmpty() {
        return pqSize == 0;
    }

    public Key deleteMax() {
        int max = 0;

        for (int i = 1; i < pqSize; i++){
            if(SortingHelper.isLess(max, i)) {
                max = i;
            }
        }

        SortingHelper.exchange(priorityQueue, max, pqSize - 1);

        return priorityQueue[--pqSize]; // null out entry to prevent loitering
    }


}
