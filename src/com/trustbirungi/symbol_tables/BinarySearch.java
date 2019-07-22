package com.trustbirungi.symbol_tables;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] numbers = new int[300];

        for (int i = 0; i < 300; i++) {
            numbers[i] = i;
        }

        System.out.println(search.search(67, numbers));
    }

    private int search(int searchTerm, int[] numbers) {
        int searchResult = 0;

        int min = 0, max = numbers.length;

        int mid = 0;

        for (int number:numbers) {
            mid = (min + max)/2;

            if(numbers[mid] == searchTerm) {
                return numbers[mid];
            } else if(numbers[mid] < searchTerm) {
                min = mid + 1;
            } else if(numbers[mid] > searchTerm) {
                max = mid - 1;
            } else {
                System.out.println("Number not found!");
                return -0;
            }
        }

        return searchResult;
    }


}
