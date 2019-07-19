package com.trustbirungi.sorts;
/**
 * Class: SortingHelper
 * Description: Contains commonly used helper methods for implementing various sorts
 */

public class SortingHelper {

    public static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        Comparable swap = array[i];

        array[i] = array[j];
        array[j] = swap;
    }
}
