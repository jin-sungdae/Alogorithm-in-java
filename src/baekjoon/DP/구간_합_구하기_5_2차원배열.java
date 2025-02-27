package baekjoon.DP;

import java.util.Scanner;

public class 구간_합_구하기_5_2차원배열 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];
        int [][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }



        for (int i = 0; i < m; i++) {

            int a1 = sc.nextInt();
            int b1 = sc.nextInt();

            int a2 = sc.nextInt();
            int b2 = sc.nextInt();


            int res = dp[a2][b2] - dp[a1 - 1][b2] - dp[a2][b1 - 1] + dp[a1 - 1][b1 - 1];
            System.out.println(res);
        }




    }


}
