package baekjoon.자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 작업_위상정렬_dp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] degree = new int[N + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] timeList = new int[N + 1];
        int [] dp = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int time = sc.nextInt();
            int l = sc.nextInt();

            timeList[i] = time;
            dp[i] = time;
            for (int j = 0; j < l; j++) {
                int x = sc.nextInt();
                graph.get(x).add(i);
                degree[i]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                pq.add(i);
            }
        }


        while (!pq.isEmpty()) {
            int x = pq.poll();

            for (int next : graph.get(x)) {
                dp[next] = Math.max(dp[next], dp[x] + timeList[next]);

                degree[next]--;
                if (degree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

        System.out.println(answer);
    }
}
