package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 플로이드 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] map = new int[m][3];
        int [][] map2 = new int[n][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(map2[i], Integer.MAX_VALUE);
            map2[i][i] = 0; // 자기 자신으로 가는 경로는 0
        }


        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();

            // 더 작은 비용으로 갱신
            map2[from][to] = Math.min(map2[from][to], cost);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map2[i][k] != Integer.MAX_VALUE && map2[k][j] != Integer.MAX_VALUE) {
                        map2[i][j] = Math.min(map2[i][j], map2[i][k] + map2[k][j]);
                    }
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
