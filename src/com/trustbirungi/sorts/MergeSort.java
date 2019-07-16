package com.trustbirungi.sorts;

public class MergeSort {

    private static void merge(Comparable[] unsortedArray, Comparable[] auxillaryArray, int low, int mid, int high) {
        //assert isSorted(unsortedArray, low, mid);
        //assert  isSorted(unsortedArray, mid+1, high);

        //Copy over the items in the unsortedArray into the auxillaryArray
        for(int k = low; k <= high; k++) {
            auxillaryArray[k] = unsortedArray[k];
        }

        int i = low, j = mid + 1;

        //Merge the sub arrays
        for(int k = low; k <= high; k++) {
            if(i > mid) {
                unsortedArray[k] = auxillaryArray[j++];
            } else if(j > high) {
                unsortedArray[k] = auxillaryArray[i++];
            } else if(isLess(auxillaryArray[j], auxillaryArray[i])) {
                unsortedArray[k] = auxillaryArray[j++];
            } else {
                unsortedArray[k] = auxillaryArray[i++];
            }
        }

        //assert isSorted(unsortedArray, low, high);
    }

    private static void sort(Comparable[] unsortedArray, Comparable[] auxillaryArray, int low, int high) {
        if(high <= low) {
            return;
        }

        int mid = low + (high - low)/2;

        sort(unsortedArray, auxillaryArray, low, mid);
        sort(unsortedArray, auxillaryArray, mid+1, high);
        merge(unsortedArray, auxillaryArray, low, mid, high);

    }

    public static void sort(Comparable[] unsortedArray) {

    }

    public static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

}
