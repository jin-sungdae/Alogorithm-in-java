package baekjoon.자료구조;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 거짓말_Union_find {

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find (int n) {
            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }

            return parent[n];
        }

        public void union (int x, int y) {
            int unionX = find(x);
            int unionY = find(y);

            if (unionY != unionX) {
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

        int N = sc.nextInt();
        int M = sc.nextInt();

        int A = sc.nextInt();
        int [] list = new int[A];
        UnionFind uf = new UnionFind(N);
        List<List<Integer>> arr = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            arr.add(new ArrayList<>());
        }
        if (A != 0) {

            for (int i = 0; i < A; i++) {
                list[i] = sc.nextInt();
            }

            for (int i = 1; i < A; i++) {
                uf.union(list[i - 1], list[i]);
            }
        } else {
            list = new int[1];
            list[0] = 0;
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            for (int j = 0; j < a; j++) {
                int num = sc.nextInt();

                arr.get(i).add(num);
            }


            for (int j = 1; j < a; j++) {
                uf.union(arr.get(i).get(j - 1), arr.get(i).get(j));
            }


        }


        for (List<Integer> x : arr) {

            for (int t : x) {
                if (uf.find(t) == uf.find(list[0])) {
                    answer++;
                    break;
                }
            }

        }

            System.out.println(M - answer);



    }
}
