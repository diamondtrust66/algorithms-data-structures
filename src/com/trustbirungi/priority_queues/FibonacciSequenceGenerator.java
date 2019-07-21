package com.trustbirungi.priority_queues;

/**
 * Class: FibonacciSequenceGenerator
 * Description: Generate a fibonacci sequence based on the starting number and the total number of elements that should
 * be in the sequence.
 * @author trustbirungi
 */

public class FibonacciSequenceGenerator {

    public static void main(String[] args) {
        //start timer
        long startTime = System.nanoTime();

        FibonacciSequenceGenerator sequenceGenerator = new FibonacciSequenceGenerator();

        long[] sequence = sequenceGenerator.generateSequence(1, 10);

        for (long number:sequence) {
            //System.out.println(number);
        }

        //end timer
        long endTime = System.nanoTime();

        //get the difference between startTime and endTime
        long runningTime = endTime - startTime;
        System.out.println("\n Execution time in nanoseconds is: " + runningTime);
        System.out.println("\n Execution time in milliseconds is: " + (runningTime / 1000000));
    }

    /**
     * Method that generates a fibonacci sequence
     * @param start - the first number in the sequence
     * @param length - the number of elements that should be in the sequence
     * @return fibonacciSequence - an array containing the numbers that make up the generated fibonacci sequence
     */
    private long[] generateSequence(int start, int length) {
        long[] fibonacciSequence = new long[length];

        fibonacciSequence[0] = start;

        for(int i = 1; i < length; i++) {
            if(i == 1) {
                fibonacciSequence[i] = start;
            } else {
                fibonacciSequence[i] = (fibonacciSequence[i - 1] + fibonacciSequence[i - 2]);
            }
        }

        return fibonacciSequence;
    }
}
