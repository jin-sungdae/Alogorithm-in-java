package baekjoon.DP;

import java.util.Scanner;

public class 평범한_배낭_배낭문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        int[] wt = new int[n + 1];
        int[] val = new int[n + 1];
        int [][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= k; w++) {
                if (wt[i] > w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w -wt[i]] + val[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
