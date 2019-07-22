package com.trustbirungi.priority_queues;

import com.trustbirungi.sorts.SortingHelper;

/**
 * Class: HeapSort
 * Description: An implementation of heap sort
 */
public class HeapSort {
    public static void sort(Comparable[] heap) {
        int heapSize = heap.length;

        for(int k = heapSize/2; k >= 1; k--) {
            sink(heap, k, heapSize);
        }

        while(heapSize > 1) {
            SortingHelper.exchange(heap, 1, heapSize);
            sink(heap, 1, --heapSize);
        }
    }

    private static void sink(Comparable[] heap, int k, int heapSize) {
        while (2*k <= heapSize) {
            int j = 2*k;

            if(j < heapSize && SortingHelper.isLess(j, j+1)) {
                j++;
            }

            if(!SortingHelper.isLess(k, j)) {
                break;
            }

            SortingHelper.exchange(heap, k, j);

            k = j;
        }
    }
}
