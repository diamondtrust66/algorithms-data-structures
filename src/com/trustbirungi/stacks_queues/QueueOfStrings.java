package com.trustbirungi.stacks_queues;

/*
* Class: QueueOfStrings
* Description: An implementation of a queue using a linked list
* */
public class QueueOfStrings {

    private Node first = null;
    private Node last = null;

    // Create an empty queue
    public QueueOfStrings() {

    }

    private class Node {
        String item;
        Node next;
    }

    // If the first node in the linked list is null, then the queue is empty
    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if(isEmpty()) {
            first = last;
        } else {
            /*push the node that was previously at the top of the linked list by setting the
            reference of the newly top item to the address of the previously top item
            */
            oldLast.next = last;
        }
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;

        if(isEmpty()) {
            last = null;
        }

        return item;
    }

}
