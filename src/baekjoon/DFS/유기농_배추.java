package baekjoon.DFS;

import java.util.Scanner;

public class 유기농_배추 {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            int M1 = sc.nextInt();
            int N1 = sc.nextInt();
            int K1 = sc.nextInt();
            int [][] map1 = new int[N1][M1];
            boolean [][] visited1 = new boolean[N1][M1];
            for (int i = 0; i < K1; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map1[y][x] = 1;
            }

            int res1 = 0;

            for (int i = 0; i < N1; i++) {
                for (int j = 0; j < M1; j++) {
                    if (map1[i][j] == 1 && visited1[i][j] == false) {
                        dfs(map1, visited1, i, j);
                        res1++;
                    }
                }
            }

            System.out.println(res1);
        }

    }

    public static void dfs(int[][] map, boolean[][] visited, int i, int j) {



        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == 1) {
                if (!visited[nx][ny]) {
                    dfs(map, visited, nx, ny);
                }
            }
        }
    }
}
