package baekjoon.DP;

import java.util.Scanner;

public class 이친수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1) {
            System.out.println(1);
            return;
        }

        long [][] dp = new long[n + 1][2];

        dp[1][1] = 1;
        dp[1][0] = 0;

        if (n >= 2) {
            dp[2][0] = 1;
            dp[2][1] = 0;
            for (int i = 3; i <= n; i++) {


                        dp[i][0] = dp[i - 1][1] + dp[i - 1][0];

                        dp[i][1] = dp[i - 1][0];


                }
        }




        System.out.println(dp[n][0] + dp[n][1]);
    }
}
