package com.trustbirungi.union_find;

public class DynamicConnectivityClient {

    public static void main(String[] args) {

        /*
        int N = StdIn.readInt();
        UnionFind uf = new UnionFind(N);

        while(!StdIn.isEmpty()) {

            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if(!uf.connected(p, q)) {

                uf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
        */

        QuickFind qf = new QuickFind(10);

        // qf.union(3, 8);

        QuickUnion qu = new QuickUnion(10);

        //qu.union(4,  3);

        WeightedQuickUnion wqu = new WeightedQuickUnion(10);
        wqu.union(4, 3);



    }
}
