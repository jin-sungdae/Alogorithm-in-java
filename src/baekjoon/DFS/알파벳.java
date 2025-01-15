package baekjoon.DFS;

import java.util.Scanner;

public class 알파벳 {

    public static boolean[] arr = new boolean[26];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int maxCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거
        char [][] map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine(); // 각 행 입력
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j); // 보드에 알파벳 저장
            }
        }

        arr[map[0][0] - 'A'] = true;
        dfs(map, 0, 0, 1);



        System.out.println(maxCount);
    }

    private static void dfs(char[][] map, int x, int y, int count) {


        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                int index = map[nx][ny] - 'A';
                if (!arr[index]) {
                    arr[index] = true;
                    dfs(map, nx, ny, count + 1);
                    arr[index] = false;


                }
            }
        }

    }
}
