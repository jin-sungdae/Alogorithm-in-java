package baekjoon.자료구조;

import java.util.*;

public class ACM_크래프트_위상정렬_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int k = sc.nextInt();

            int[] build = new int[N + 1];
            int[] dp = new int [N + 1];
            Queue<Integer> q = new LinkedList<>();
            int[] degree = new int[N + 1];
            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 1; j <= N; j++) {
                build[j] = sc.nextInt();
                dp[j] = build[j];
            }

            for (int j = 0; j < k; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                degree[b]++;
            }

            int finish = sc.nextInt();

            for (int j = 1; j <= N; j++) {
                if (degree[j] == 0) {
                    q.add(j);
                }
            }

            while (!q.isEmpty()) {
                int x = q.poll();

                for (int next : graph.get(x)) {
                    dp[next] = Math.max(dp[next], dp[x] + build[next]);
                    degree[next]--;
                    if (degree[next] == 0) {
                        q.add(next);

                    }
                }
            }

            System.out.println(dp[finish]);

        }
    }
}
