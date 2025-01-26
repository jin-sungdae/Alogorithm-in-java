package baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리의_지름 {

    public static int maxCount = 0;
    public static class Node {
        int x, y, weight;

        Node (int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Node>> arr = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        List<Integer> leafNode = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            arr.get(a).add(new Node(a, b, c));
            arr.get(b).add(new Node(b, a, c));

        }

        for (int i = 1; i <= n; i++) {
            if (arr.get(i).size() == 1) {
                leafNode.add(i);
            }
        }

        for (Integer i : leafNode) {

            boolean[] visited = new boolean[n + 1];
            dfs(arr, visited, i, 0);
        }


            System.out.println(maxCount);
    }

    public static void dfs(List<List<Node>> arr, boolean[] visited, int n, int count) {


        visited[n] = true;

        for (Node node : arr.get(n)) {
            if (!visited[node.y]) {
                maxCount = Math.max(maxCount, node.weight + count);
                dfs(arr, visited, node.y, node.weight + count);
            }
        }
    }
}
