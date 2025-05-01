package baekjoon.자료구조;

import java.util.*;

public class 최종순위_위상정렬 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();


        for (int i = 0; i < k; i++) {
            Queue<Integer> pq = new LinkedList<>();
            int n = sc.nextInt();

            int[] degree = new int[n + 1];
            int[] sl = new int[n + 1];
            List<Integer> res = new ArrayList<>();
            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 1; j <= n; j++) {
                sl[j] = sc.nextInt();
            }

            for (int j = 1; j <= n; j++) {
                for (int t = j + 1; t <= n; t++) {
                    graph.get(sl[j]).add(sl[t]);
                    degree[sl[t]]++;
                }
            }

            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (graph.get(a).contains(b)) {
                    graph.get(a).remove(Integer.valueOf(b));
                    degree[b]--;
                    graph.get(b).add(a);
                    degree[a]++;
                } else {
                    graph.get(b).remove(Integer.valueOf(a));
                    degree[a]--;
                    graph.get(a).add(b);
                    degree[b]++;
                }
            }

            for (int j = 1; j <= n; j++) {
                if (degree[sl[j]] == 0) {
                    pq.add(sl[j]);
                }
            }

            boolean isAmbiguous = false;
            while (!pq.isEmpty()) {
                if (pq.size() > 1) {
                    isAmbiguous = true;
                }
                int next = pq.poll();
                res.add(next);

                for (int x : graph.get(next)) {
                    degree[x]--;
                    if (degree[x] == 0) {
                        pq.add(x);
                    }
                }
            }

            if (res.size() != n) {
                System.out.println("IMPOSSIBLE");
            } else if (isAmbiguous) {
                System.out.println("?");
            } else {
                for (int x : res) {
                    System.out.print(x + " ");

                }
                System.out.println();
            }

        }

    }
}
