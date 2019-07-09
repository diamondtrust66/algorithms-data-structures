package com.trustbirungi.sorts;

public class ShellSort {

    public static void main(String[] args) {
      ShellSort sorter = new ShellSort();

      Comparable[] unsorted = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};

      sorter.sort(unsorted);

      //System.out.println("\n Is the array " + "unsorted" + " sorted? " + isSorted(sorter.sort(unsorted)) + "\n" );

        for (Comparable value: unsorted) {
            System.out.println("\n" + value);
        }
    }

    public static Comparable[] sort(Comparable[] array) {
        int N = array.length;
        int h = 1;

        while (h < N/3) {
            // 3x + 1 increment sequence
            h = 3 * h + 1;
        }

        while(h >= 1) {
            // h-sort the array
            for(int i = h; i < N; i++) {
                // Insertion sort
                for(int j = i; j >= h && isLess(array[j], array[j-h]); j -= h) {
                    exchange(array, j, j-h);
                }
            }

            //move to next increment
            h = h/3;

        }

        return array;
    }

    public static boolean isLess(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void exchange(Comparable[] array, int i, int j) {
        Comparable swap = array[i];

        array[i] = array[j];
        array[j] = swap;
    }

    private static boolean isSorted(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            if (isLess(array[i], array[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
