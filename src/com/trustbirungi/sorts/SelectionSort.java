package com.trustbirungi.sorts;

public class SelectionSort {

    public static void main(String[] args) {
      SelectionSort sorter = new SelectionSort();

      Comparable[] unsorted = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};

      sorter.sort(unsorted);

      //System.out.println("\n Is the array " + "unsorted" + " sorted? " + isSorted(sorter.sort(unsorted)) + "\n" );

        for (Comparable value: unsorted) {
            System.out.println("\n" + value);
        }

        int[] myArray = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};

        sorter.selectionSort(myArray);

        for (int value: myArray) {
            System.out.println(value);
        }

    }

    public static Comparable[] sort(Comparable[] array) {
        int N = array.length;

        for(int i = 0; i < N; i++) {
            int min = i;

            for(int j = i+1; j < N; j++) {
                if(isLess(array[j], array[min])) {
                    min = j;
                }
            }

            exchange(array, i, min);
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


    private static void selectionSort(int[] input) {

        int inputLength = input.length;

        for (int i = 0; i < inputLength - 1; i++) {

            int min = i;

            // find the first, second, third, fourth... smallest value
            for (int j = i + 1; j < inputLength; j++) {
                if (input[j] < input[min]) {
                    min = j;
                }
            }

            // swaps the smallest value with the position 'i'
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;

            //next pls
        }

    }


}
