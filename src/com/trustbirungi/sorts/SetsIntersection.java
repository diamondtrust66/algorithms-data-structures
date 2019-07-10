package com.trustbirungi.sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class takes two arrays 𝚊[] and 𝚋[], each containing nn distinct 2D points in the plane, and counts the number of
 * points that are contained both in array 𝚊[] and array 𝚋[]
* */
public class SetsIntersection {

    public static void main(String[] args) {

        SetsIntersection set = new SetsIntersection();

        int[][] firstArray = {{1, 2}, {7, 3}, {6, 9}, {10, 1}, {23, 15}};
        int[][] secondArray = {{11, 0}, {6, 9}, {4, 20}, {7, 3}, {20, 13}};

        System.out.println("Number of matching points = " + set.checkIntersection(firstArray, secondArray));

    }

    public int checkIntersection(int[][] firstArray, int[][] secondArray) {
        int firstLength = firstArray.length;

        List<int[]> matchesList = new ArrayList<int[]>();

        for(int i = 0; i < firstLength; i++) {

            System.out.println("\nFirst Array: " + firstArray[i][0] + ", " + firstArray[i][1]);
            System.out.println("\nSecond Array: " + secondArray[i][0] + ", " + secondArray[i][1]);

            if(Arrays.equals(firstArray[i], secondArray[i])) {
                matchesList.add(firstArray[i]);
            }


        }

        return matchesList.size();
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
