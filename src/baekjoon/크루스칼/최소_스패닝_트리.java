package baekjoon.크루스칼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 최소_스패닝_트리 {

     static class UnionFind {
        private int[] parent;
        private int[] rank;

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
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }

        }
    }

    static class Edge implements Comparable<Edge> {

        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight, o.weight);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        List<Edge> mst = kruskal(v, edges);


        int totalWeight = 0;
        for (Edge edge : mst) {
//            System.out.println("정점 " + edge.u + " - 정점 " + edge.v + " (가중치: " + edge.weight + ")");
            totalWeight += edge.weight;
        }
        System.out.println(totalWeight);

    }

    public static List<Edge> kruskal(int nodes, List<Edge> edges) {
        Collections.sort(edges);
        UnionFind uf = new UnionFind(nodes + 1);
        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            // 두 정점이 서로 다른 집합에 속하면 간선 추가
            if (uf.find(e.u) != uf.find(e.v)) {
                uf.union(e.u, e.v);
                mst.add(e);
            }
        }

        return mst;
    }


}
