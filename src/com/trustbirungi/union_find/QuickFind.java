package com.trustbirungi.union_find;

import java.util.Arrays;

public class QuickFind {

    private int[] id;

    private int unionCount = 0;

    public QuickFind(int N) {
        id = new int[N];

        //set id of each object to itself
        //(N array accesses)
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }

        System.out.println("Initial id array: " + Arrays.toString(id));

    }

    public boolean connected(int p, int q) {
       return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        //change all entries with id[p] to id[q]
        //(at most 2N + 2 array accesses)
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid) {
                id[i] = qid;
            }
        }

        unionCount++;

        System.out.println("Id array after " + unionCount + " runs " + Arrays.toString(id));
    }
}
