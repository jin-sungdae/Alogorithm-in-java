package baekjoon.자료구조;

import java.util.Scanner;

public class 여행_갸자 {

    static class UnionFind {
        int [] parent;
        int [] rank;

        UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int n) {
            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }

            return parent[n];
        }

        void union(int x, int y) {
            int unionX = find(x);
            int unionY = find(y);

            if (unionX != unionY) {
                if (rank[unionX] < rank[unionY]) {
                    parent[unionX] = unionY;
                } else if (rank[unionY] < rank[unionX]) {
                    parent[unionY] = unionX;
                } else {
                    parent[unionX] = unionY;
                    rank[unionY]++;
                }
            }

        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        UnionFind uf = new UnionFind(n);
        int[][] map = new int[n][n];
        int [] list = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    uf.union(i + 1, j + 1);
                }
            }
        }

        int parent = 0;

        for (int i = 0; i < m; i++) {
            list[i] = sc.nextInt();

        }
        Boolean ch = false;
        parent = uf.find(list[0]);
        for (int i = 1 ; i < m; i++) {
            if (parent != uf.find(list[i])) {
                ch = true;
            }
        }

        if (ch) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }



    }
}
