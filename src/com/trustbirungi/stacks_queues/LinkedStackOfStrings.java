package com.trustbirungi.stacks_queues;

/*
* Class: LinkedStackOfStrings
* Description: A an implementation of a stack in Java using a Linked-list
* */
public class LinkedStackOfStrings {

    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    // If the first node in the linked list is null, then the linked list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Add the new item to the top of the linked list
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;

        /*push the node that was previously at the top of the linked list by setting the
        reference of the newly top item to the address of the previously top item
        */
        first.next = oldFirst;
    }

    // Remove the item at the top of the linked list and return it
    public  String pop() {
        String item = first.item;
        first = first.next;

        return  item;
    }
}
