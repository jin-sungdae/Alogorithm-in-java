package baekjoon.자료구조;

import java.util.*;

public class 장난감_조립_위상정렬 {


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
        int [] degree = new int[n + 1];
        int [][] parts = new int[n + 1][n + 1];
        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n ; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            degree[a]++;
            graph.get(b).add(new Edge(a, c));

        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (degree[i] == 0) {
                q.add(i);
                parts[i][i] = 1;
            }
        }


        while (!q.isEmpty()) {
            int now = q.poll();

            for (Edge next : graph.get(now)) {

                for (int i = 1; i <= n; i++) {
                    parts[next.to][i] += parts[now][i] * next.cost;
                }

                degree[next.to]--;

                if (degree[next.to] == 0) {
                    q.add(next.to);
                }

            }
        }

        for (int i = 1; i < n; i++) {
            if (parts[n][i] > 0) {
                System.out.println(i + " " + parts[n][i]);
            }
        }
    }
}
