package baekjoon.백트래킹;

import java.util.*;

public class 치킨_배달 {

    public static List<Integer> resList = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] map = new int[n][n];

        List<int[]> chickenList = new ArrayList<>();
        List<int[]> homeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    homeList.add(new int[]{i, j});
                }
                if (map[i][j] == 2) {
                    chickenList.add(new int[]{i, j});
                }
            }
        }

        boolean[] visited = new boolean[chickenList.size()];
        combination(chickenList, visited, 0, m, homeList);
        Collections.sort(resList);

        System.out.println(resList.get(0));

    }

    public static void combination(List<int[]> arr, boolean[] visited, int start, int r, List<int[]> homeList) {
        if (r == 0) {
            print(arr, visited, homeList);
            return ;
        }

        for (int i = start; i < arr.size(); i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, r - 1, homeList);
            visited[i] = false;
        }
    }

    public static void print(List<int[]> arr, boolean[] visited, List<int[]> homeList) {

        int sum = 0;
        for (int[] x : homeList) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.size(); i++) {
                if (visited[i]) {
                    int a = x[0];
                    int b = x[1];

                    int a1 = arr.get(i)[0];
                    int b1 = arr.get(i)[1];
                    min = Math.min(min, Math.abs(a1 - a) + Math.abs(b1 - b));

                }
            }
            sum += min;
        }



        resList.add(sum);

    }
}
