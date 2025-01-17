package baekjoon.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 이분_그래프 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            List<List<Integer>> graph = new ArrayList<>();
            for (int k = 0; k <= v; k++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean res = isBipartite(graph, v + 1);

            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static boolean isBipartite(List<List<Integer>> graph, int n) {
        int [] colors = new int[n];
        Arrays.fill(colors, 0);

        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, colors, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> graph, int[] colors, int node, int color) {
        colors[node] = color;

        for (int neighbor : graph.get(node)) {
            if (colors[neighbor] == 0) {
                if (!dfs(graph, colors, neighbor, -color)) {
                    return false;
                }
            } else if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }

}
