package baekjoon.자료구조;

import java.util.*;

// 어떤 작업을 먼저 해야하만 다음작업을 할 수 있다.
public class 문제집_위상정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M =sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int [] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.get(a).add(b);
            indegree[b]++;
        }

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);

            for (int next : list.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (Integer a : result) {
            System.out.print(a + " ");
        }
    }
}
