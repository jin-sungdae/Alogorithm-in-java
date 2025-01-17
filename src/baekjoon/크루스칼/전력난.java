package baekjoon.크루스칼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 전력난 {

    static class Edge implements Comparable<Edge> {
        int x, y, weight;
        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;

            List<Edge> edges = new ArrayList<>();
            int totalWeight = 0;

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int weight = sc.nextInt();
                edges.add(new Edge(x, y, weight));
                totalWeight += weight;
            }

            List<Edge> mst = kruskal(n, edges);

            int mstWeight = 0;
            for (Edge e : mst) {
                mstWeight += e.weight;
            }

            System.out.println(totalWeight - mstWeight);
        }
    }

    public static List<Edge> kruskal (int node, List<Edge> edgeList) {
        Collections.sort(edgeList);
        UnionFind uf = new UnionFind(node);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edgeList) {
            if (uf.find(edge.x) != uf.find(edge.y)) {
                uf.union(edge.x, edge.y);
                mst.add(edge);
            }
        }

        return mst;
    }

}
