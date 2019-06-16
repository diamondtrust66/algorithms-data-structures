package com.trustbirungi.union_find;

import java.util.Arrays;

public class WeightedQuickUnion {
    private int[] parent; //parent[i] = parent of i
    private int unionCount = 0;
    private  int count; //number of components

    //array to count the number of objects in the tree rooted at i
    private int[] size; //size[i] = number of sites in subtree rooted at i

    public WeightedQuickUnion(int N) {
        parent = new int[N];
        count = N;
        size = new int[N];

        //set id of each object to itself
        //(N array accesses)
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        System.out.println("Initial id array: " + Arrays.toString(parent));
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between 1 and n)
     */
    public int count() {
        return count;
    }

    private int root(int i) {

        //chase parent pointers until reach root
        //(depth of i array accesses)
        while (i != parent[i]){
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        //check if p and q have same root
        //(depth of p and q array accesses)
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if(rootP == rootQ) {
            return;
        }

        // make smaller root point to larger one
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;

        unionCount++;

        System.out.println("Id array after " + unionCount + " runs " + Arrays.toString(parent));
    }
}
