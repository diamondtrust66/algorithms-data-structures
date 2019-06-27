package com.trustbirungi.stacks_queues;

/*
* Class: Stack
* Description: A stack implementation using a singly-linked list that takes in generic types
* */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    // If the first node in the linked list is null, then the linked list is empty
    public boolean isEmpty() {
        return first == null;
    }

    // Add the new item to the top of the linked list
    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;

        /*push the node that was previously at the top of the linked list by setting the
        reference of the newly top item to the address of the previously top item
        */
        first.next = oldFirst;
    }

    // Remove the item at the top of the linked list and return it
    public  Item pop() {
        Item item = first.item;
        first = first.next;

        return  item;
    }

    // Implement the iteration
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;

            try {
                current = current.next;

            } catch (NoSuchElementException noSuchElement) {
                noSuchElement.printStackTrace();

            }

            return item;
        }
    }
}
