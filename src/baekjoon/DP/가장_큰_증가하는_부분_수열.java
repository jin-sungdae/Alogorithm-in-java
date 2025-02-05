package baekjoon.DP;

import java.util.Scanner;

public class 가장_큰_증가하는_부분_수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int [] dp = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = A[i];
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);

    }
}
