package baekjoon.DP;

import java.util.Scanner;

public class 가장_긴_감소하는_부분_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] A = new int[n];
        int [] dp = new int[n];

        for (int i = n -1; i >= 0; i--) {
            A[i] = sc.nextInt();
        }

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(maxLen);


    }
}
