package baekjoon.자료구조;

import java.util.*;

public class 임계경로_위상정렬 {

    static class Edge {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] degree = new int[n + 1];
        int[] dist = new int[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        List<List<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int time = sc.nextInt();

            graph.get(a).add(new Edge(b, time));
            reverse.get(b).add(a);
            degree[b]++;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Edge next : graph.get(now)) {
                if (dist[next.to] < dist[now] + next.cost) {
                    dist[next.to] = dist[now] + next.cost;
                }

                degree[next.to]--;
                if (degree[next.to] == 0) {
                    q.offer(next.to);
                }
            }
        }


        System.out.println(dist[end]);

        int count = 0;
        Queue<Integer> q1 = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        q1.offer(end);
        visited[end] = true;

        while (!q1.isEmpty()) {
            int cur = q1.poll();
            for (int prev : reverse.get(cur)) {
                for (Edge e : graph.get(prev)) {
                    if (e.to == cur && dist[cur] - dist[prev] == e.cost) {
                        count++;
                        if (!visited[prev]) {
                            visited[prev] = true;
                            q1.offer(prev);
                        }
                    }
                }
            }
        }

        System.out.println(count);

    }
}
