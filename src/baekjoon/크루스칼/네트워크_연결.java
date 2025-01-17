package baekjoon.크루스칼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 네트워크_연결 {

    static class Edge implements Comparable<Edge> {
        int x, y, weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
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

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        List<Edge> mst = kruskal(n + 1, edges);
        int totalWeight = 0;

        for (Edge e : mst) {
            totalWeight += e.weight;
        }
        System.out.println(totalWeight);
    }

    public static List<Edge> kruskal (int nodes, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(nodes);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (uf.find(edge.x) != uf.find(edge.y)) {
                uf.union(edge.x, edge.y);
                mst.add(edge);
            }
        }

        return mst;
    }


}
