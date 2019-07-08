package com.trustbirungi.sorts;

public class SelectionSort {

    public static void sort(Comparable[] array) {
        int N = array.length;

        for(int i = 0; i < N; i++) {
            int min = i;

            for(int j = i+1; j < N; j++) {
                if(isLess(array[j], array[min])) {
                    min = j;
                }

            exchange(array, i, min);
            }
        }
    }

    public static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        Comparable swap = array[i];

        array[i] = array[j];
        array[j] = swap;
    }

}
