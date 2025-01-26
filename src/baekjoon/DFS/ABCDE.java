package baekjoon.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABCDE {

    public static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr.get(a).add(b);
            arr.get(b).add(a);
        }



        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            dfs(arr, visited, i, 0);
            if (check) break;
        }


        if (check) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void dfs(List<List<Integer>> arr, boolean[] visited, int n, int depth) {

        if (check) {
            return;
        }

        for (int x : arr.get(n)) {
            if (depth >= 4) {
                check = true;
                return;
            }
            if (!visited[x]) {
                visited[x] = true;

                dfs(arr, visited, x, depth + 1);
                visited[x] = false;
            }
        }
    }
}
