package baekjoon.DFS;

import java.util.*;

public class DFS와_BFS {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr.get(a).add(b);
            arr.get(b).add(a);

            Collections.sort(arr.get(a));
            Collections.sort(arr.get(b));
        }

        boolean[] visited = new boolean[n + 1];
        dfs(arr, visited, v);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(arr, visited, v);

    }

    public static void dfs(List<List<Integer>> arr, boolean[] visited, int v) {

        visited[v] = true;
        System.out.print(v + " ");

        for (int next : arr.get(v)) {
            if (!visited[next]) {
                dfs(arr, visited, next);
            }
        }

        return;
    }

    public static void bfs(List<List<Integer>> arr, boolean[] visited, int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;


        System.out.print(v + " ");
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : arr.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    System.out.print(next + " ");
                }
            }
        }

    }
}
