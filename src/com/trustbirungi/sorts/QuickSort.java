package com.trustbirungi.sorts;

public class QuickSort {

    static SortingHelper helper = new SortingHelper();

    static final int CUTOFF = 10;

    private static int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;

        while(true) {
            // Find item on the left to swap
            while(helper.isLess(array[++i], array[low])) {
                if(i == high) {
                    break;
                }
            }

            // Find item on the right to swap
            while(helper.isLess(array[low], array[--j])) {
                if(j == low) {
                    break;
                }
            }

            // Check if pointers cross and if they do, then stop
            if(i >= j) {
                break;
            }

            // Swap array[i] with array[j]
            helper.exchange(array, i, j);
        }

        // Swap with the partitioning item
        helper.exchange(array, low, j);

        // Return the index of the item now known to be in place
        return  j;
    }

    public static void sort(Comparable[] array) {
        // Shuffling guarantees performance by avoiding quadratic running time in case the array is already sorted
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {
        if(high <= low) return;

        // Use Insertion sort for small sub arrays
        if (high <= low + CUTOFF - 1) {
            InsertionSort.sort(array);
            return;
        }

        int j = partition(array, low, high);
        sort(array, low, j - 1);
        sort(array, j + 1, high);

    }



}
