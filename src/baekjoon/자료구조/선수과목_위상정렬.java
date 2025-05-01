package baekjoon.자료구조;

import java.util.*;

public class 선수과목_위상정렬 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] t = new int[n + 1];
        int [] degree = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        int [] dp = new int[n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            degree[b]++;
            t[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
            dp[i] = 1;
        }

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int next : graph.get(x)) {
                degree[next]--;
                dp[next] = Math.max(dp[next], dp[x] + 1);
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
