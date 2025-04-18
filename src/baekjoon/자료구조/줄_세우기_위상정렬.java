package baekjoon.자료구조;

import java.util.*;

public class 줄_세우기_위상정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] degree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            degree[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int x : graph.get(now)) {
                degree[x]--;
                if (degree[x] == 0) {
                    q.add(x);
                }
            }
        }

        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
