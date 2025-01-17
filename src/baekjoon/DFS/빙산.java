package baekjoon.DFS;

import java.util.Scanner;

public class 빙산 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] map = new int[n][m];
        int [][] map2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                map[i][j] = x;
                map2[i][j] = x;
            }
        }

        int count = 0;
        int res = 0;
        while (true) {
            res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != 0) {
                        checkMap(map, map2, i, j);
                    }
                }
            }


            boolean[][] isVisited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map2[i][j] != 0 && !isVisited[i][j]) {
                        dfs(map2, isVisited, i, j);
                        res++;
                    }
                }
            }

            count++;
            if (res != 1) {
                break;
            }

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = map2[i][j];
                }
            }


        }

        if (res == 0) {
            count = 0;
        }
        System.out.println(count);

    }

    private static void dfs(int[][] map2, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && map2.length > nx && map2[0].length > ny && map2[nx][ny] != 0 && !isVisited[nx][ny]) {
                dfs(map2, isVisited, nx, ny);
            }
        }

    }

    private static void checkMap(int[][] map, int[][] map2, int i, int j) {

        int count = 0;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                if (map[nx][ny] == 0) {
                    count++;
                }
            }
        }

        if (count != 0) {
            map2[i][j] = Math.max(0, map[i][j] - count);
        }

    }
}
