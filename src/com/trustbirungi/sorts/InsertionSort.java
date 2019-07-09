package com.trustbirungi.sorts;

public class InsertionSort {

    public static void main(String[] args) {
      InsertionSort sorter = new InsertionSort();

      Comparable[] unsorted = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};

      sorter.sort(unsorted);

      //System.out.println("\n Is the array " + "unsorted" + " sorted? " + isSorted(sorter.sort(unsorted)) + "\n" );

        for (Comparable value: unsorted) {
            System.out.println("\n" + value);
        }
    }

    public static Comparable[] sort(Comparable[] array) {
        int N = array.length;

        for(int i = 0; i < N; i++) {
            int min = i;

            for(int j = i; j > 0; j--) {
                if(isLess(array[j], array[j-1])) {
                    exchange(array, j, j-1);
                } else  {
                    break;
                }
            }
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
