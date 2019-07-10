package com.trustbirungi.sorts;

class ArrayValueSimilarityChecker {
    public static void main(String[] args) {
        //start timer
        long startTime = System.nanoTime();

        int[] firstArray = {101, 45, 99, 23, 11, 1, 4, 7, 2, 929, 22};
        int[] secondArray = {45, 11, 1, 22, 2, 101, 99, 4, 929, 7, 23};

        for(int i = 0; i < firstArray.length; i++) {
            if(!contains(secondArray, firstArray[i])) {
                System.out.print("The arrays have different values.");
                System.exit(0);
            }
        }

        System.out.println("The arrays have the same values.");

        //end timer
        long endTime = System.nanoTime();

        //get the difference between startTime and endTime
        long runningTime = endTime - startTime;
        System.out.println("\n Execution time in nanoseconds is: " + runningTime);
        System.out.println("\n Execution time in milliseconds is: " + (runningTime / 1000000));
    }

    public static boolean contains(int[] array, int value) {
        int arrayLength = array.length;

        for(int i = 0; i < arrayLength; i++) {
            if(array[i] == value) {
                return true;
            }
        }

        return false;
    }
}