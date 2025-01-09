package baekjoon.BFS;

import java.util.*;

public class 촌수계산 {

    public static class Node {
        int x, distance;

        Node (int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int m = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.get(x).add(y);
            arr.get(y).add(x);
        }

        boolean[] visited = new boolean[n + 1];
        int res = bfs(b, a, visited, arr);

        System.out.println(res);
    }

    public static int bfs(int start, int end, boolean[] visited, List<List<Integer>> arr) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == end) {
                return current.distance;
            }

            for (int next : arr.get(current.x)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, current.distance + 1));
                }
            }
        }

        return -1;
    }
}
