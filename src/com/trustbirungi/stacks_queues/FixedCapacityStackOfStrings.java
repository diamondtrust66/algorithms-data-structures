package com.trustbirungi.stacks_queues;

/*
* Class: FixedCapacityStackOfStrings
* Description: a stack implementation using arrays
* */
public class FixedCapacityStackOfStrings {

    private  String[] strings;
    private int arrayLength = 0;

    // Added a cheat that lets the client define the capacity of the array.
    // This is bad practice however since it asks the client to know about the details of the implementation
    public FixedCapacityStackOfStrings(int capacity) {
        strings = new String[capacity];
    }

    // If the array length is 0, then it is empty
    public boolean isEmpty() {
        return arrayLength == 0;
    }

    public void push(String item) {
        // Place the new string at the N + 1 index
        strings[arrayLength++] = item;
    }

    public String pop() {
        // Get the string at the N - 1 index
        String item = strings[--arrayLength];

        // Remove the reference to the item at N - 1 since it's no longer needed (avail it for garbage collection).
        // This prevents loitering(keeping reference to an object that's no longer needed).
        strings[arrayLength] = null;

        return item;
    }
}
