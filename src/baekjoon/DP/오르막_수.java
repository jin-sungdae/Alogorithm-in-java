package baekjoon.DP;

import java.util.Scanner;

public class 오르막_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int MOD = 10007;

        int[][] dp = new int[n + 1][10];


        for (int j = 0; j <= 9; j++) {
            dp[1][j] = 1;
        }



            for (int i = 2; i <= n; i++) {
                for (int j = 9; j >= 0; j--) {
                    if (j == 9) {
                        dp[i][j] = dp[i -1][j];
                    } else {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j + 1]) % MOD;
                    }

                }
            }

            int res = 0;
            for (int i = 0; i <= 9; i++) {
                res = (res +  dp[n][i]) % MOD;
            }

            System.out.println(res);



    }
}
