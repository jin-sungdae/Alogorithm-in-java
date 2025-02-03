package baekjoon.DP;

import java.util.Scanner;

public class 일콤마이콤마삼더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            System.out.println(dp[a]);
        }
    }
}
