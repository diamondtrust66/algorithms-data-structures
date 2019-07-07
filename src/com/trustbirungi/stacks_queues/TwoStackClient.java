package com.trustbirungi.stacks_queues;

public class TwoStackClient {
    public static void main(String[] args) {
        TwoStack twoStackClient = new TwoStack();
        System.out.println(twoStackClient.evaluate("(1+((2+3)*(4*5)))"));
    }
}
