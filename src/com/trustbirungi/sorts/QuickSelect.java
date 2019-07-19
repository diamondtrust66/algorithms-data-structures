package com.trustbirungi.sorts;

public class QuickSelect {

    static SortingHelper helper = new SortingHelper();

    public static Comparable select(Comparable[] array, int k) {
        StdRandom.shuffle(array);

        int low = 0, high = array.length - 1;

        while(high > low) {
            int j = partition(array, low, high);

            if(j < k) {
                low = j + 1;
            } else if(j > k) {
                high = j - 1;
            } else {
                return array[k];
            }
        }
        return array[k];
    }

    private static int partition(Comparable[] array, int low, int high) {
        int i = low, j = high + 1;

        while(true) {
            // Find item on the left to swap
            while(helper.isLess(array[++i], array[low])) {
                if(i == high) {
                    break;
                }
            }

            // Find item on the right to swap
            while(helper.isLess(array[low], array[--j])) {
                if(j == low) {
                    break;
                }
            }

            // Check if pointers cross and if they do, then stop
            if(i >= j) {
                break;
            }

            // Swap array[i] with array[j]
            helper.exchange(array, i, j);
        }

        // Swap with the partitioning item
        helper.exchange(array, low, j);

        // Return the index of the item now known to be in place
        return  j;
    }



}
