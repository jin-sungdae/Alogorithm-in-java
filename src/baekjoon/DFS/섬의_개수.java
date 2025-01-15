package baekjoon.DFS;

import java.util.Scanner;

public class 섬의_개수 {

    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; // 상, 하, 좌, 우, 좌상, 좌하, 우상, 우하
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1}; // 상, 하, 좌, 우, 좌상, 좌하, 우상, 우하


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            if (w == 0 && h == 0) {
                break;
            }
            int [][] map = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            boolean[][] visited = new boolean[h][w];
            int res = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        dfs(map, visited, i, j);
                        res++;
                    }
                }
            }

            System.out.println(res);
        }

    }

    private static void dfs(int[][] map, boolean[][] visited, int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && visited[nx][ny] == false && map[nx][ny] == 1) {
                dfs(map, visited, nx, ny);
            }
        }
    }
}
