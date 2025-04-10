package baekjoon.DP;

import java.util.Scanner;

public class 동전1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] coins = new int[n];
        int [] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[k]);
    }
}
