package baekjoon.자료구조;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 친구_네트워크_Union_find {

    static class UnionFind {

        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();

        public String find(String n) {
            if (!parent.getOrDefault(n, n).equals(n)) {
                parent.put(n, find(parent.get(n)));
            }

            return parent.getOrDefault(n, n);
        }

        public int union(String x, String y) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                rank.put(x, 1);
            }
            if (!parent.containsKey(y)) {
                parent.put(y, y);
                rank.put(y, 1);
            }

            String unionX = find(x);
            String unionY = find(y);

            if (unionY != unionX) {
                    parent.put(unionY, unionX);
                    rank.put(unionX, rank.get(unionX) + rank.get(unionY));

            }

            return rank.get(find(x));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            sc.nextLine();
            UnionFind uf = new UnionFind();
            for (int j = 0; j < k; j++) {
                String[] a = sc.nextLine().split(" ");

                int num = uf.union(a[0], a[1]);


                System.out.println(num);
            }
        }
    }
}
