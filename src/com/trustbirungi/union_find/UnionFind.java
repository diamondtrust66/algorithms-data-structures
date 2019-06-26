package com.trustbirungi.union_find;

import java.util.Arrays;
public class UnionFind {
    private int[] id;
    private int unionCount = 0;

    //initialize union-find data structure with N objects (0 to N - 1)
    public UnionFind(int N) {
        id = new int[N];
        //set id of each object to itself
        //(N array accesses)
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        System.out.println("Initial id array: " + Arrays.toString(id));
    }

    private int root(int i) {
        //chase parent pointers until reach root
        //(depth of i array accesses)
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }

    //add connection between p and q
    public  void union(int p, int q) {
        int i = root(p);
        int j = root(q);

        //change root of p to point to root of q
        //(depth of p and q array accesses)
        id[i] = j;
        unionCount++;

        System.out.println("Id array after " + unionCount + " runs " + Arrays.toString(id));
    }

    //are p and q in the same component?
    public boolean connected(int p, int q) {
        //check if p and q have same root
        //(depth of p and q array accesses)
        return root(p) == root(q);
    }

    public int find(int[] component){
        int count = component.length;
        int max = component[0];

        for(int i = 0; i < count; i++) {
            if(component[i] > max) {
                max = component[i];
            }
        }

        return max;
    }
}
