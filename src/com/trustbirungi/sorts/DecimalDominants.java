package com.trustbirungi.sorts;

import java.util.ArrayList;

/**
 * Class: DecimalDominants
 * Description: Given an array with nn keys, design an algorithm to find all values that occur more than n/10n/10 times.
 * The expected running time of your algorithm should be linear.
 * @author trustbirungi
 */
public class DecimalDominants {

    public ArrayList<Integer> findDecimalDominants(ArrayList<Integer> arrayList) {
        int arrayLength = arrayList.size();

        ArrayList<Integer> decimalDominants = new ArrayList<Integer>();

        for(int i = 0; i < arrayLength; i++) {
            if(arrayList.contains(arrayList.get(i))) {

            }
        }

        return decimalDominants;
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
