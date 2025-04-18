package baekjoon.자료구조;

import java.util.*;

public class 게임_개발_위상정렬_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int []build = new int[n + 1];
        int [] dp = new int[n + 1];
        int [] degree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }



        for (int i = 1; i <= n; i++) {
            build[i] = sc.nextInt();

            while (true) {
                int a = sc.nextInt();

                if (a == -1) {
                    break;
                }

                graph.get(a).add(i);
                degree[i]++;
            }
        }

        for (int i = 1 ; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
            dp[i] = build[i];
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int next : graph.get(x)) {
                degree[next]--;
                dp[next] = Math.max(dp[next], dp[x] + build[next]);
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(dp[i]);
        }
    }
}
