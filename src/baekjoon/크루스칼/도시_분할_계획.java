package baekjoon.크루스칼;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 도시_분할_계획 {

    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
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
                    parent[rootX] = rootY;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
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

        Collections.sort(edges);
        UnionFind uf = new UnionFind(n + 1);
        int totalCost = 0;
        int maxEdgeWeight = 0;

        for (Edge edge : edges) {
            if (uf.find(edge.x) != uf.find(edge.y)) {
                uf.union(edge.x, edge.y);
                totalCost += edge.weight;
                maxEdgeWeight = edge.weight; // 가장 큰 간선 가중치 추적
            }
        }

        System.out.println(totalCost - maxEdgeWeight);
    }




}
