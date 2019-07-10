package com.trustbirungi.sorts;

/**
 * This class checks if two arrays have exactly the same values but in different order
 * @author Trust Birungi
* */
public class ArrayPermutationChecker {

    public static void main(String[] args) {
        //start timer
        long startTime = System.nanoTime();

        ArrayPermutationChecker apc = new ArrayPermutationChecker();

        int[] firstArray = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};
        int[] secondArray = {45, 11, 1, 22, 2, 101, 99, 4, 929, 7, 23};

        sort(firstArray);
        sort(secondArray);

        if (apc.permutationChecker(firstArray, secondArray)) {
            System.out.println("The two arrays have the same values");
        } else {
            System.out.println("The two arrays have different values");
        }

        //end timer
        long endTime = System.nanoTime();

        //get the difference between startTime and endTime
        long runningTime = endTime - startTime;
        System.out.println("\n Execution time in nanoseconds is: " + runningTime);
        System.out.println("\n Execution time in milliseconds is: " + (runningTime / 1000000));
    }

    public boolean permutationChecker(int[] firstArray, int[] secondArray) {


        if (firstArray.length != secondArray.length) {
            System.out.println("Error: The arrays have different sizes!");
            System.exit(0);
        }

        int firstLength = firstArray.length;

        for(int i = 0; i < firstLength; i++) {
            if(firstArray[i] != secondArray[i]) {
                return false;
            }
        }

        return true;
    }

    public static int[] sort(int[] array) {
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

    public static boolean isLess(int x, int y) {
        return x < y;
    }

    public static void exchange(int[] array, int i, int j) {
        int swap = array[i];

        array[i] = array[j];
        array[j] = swap;
    }
}
