package baekjoon.DP;

import java.util.Scanner;

public class 구간_합_구하기_4_1차원배열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }


        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int sum = dp[y] - dp[x - 1];
            System.out.println(sum);
        }
    }
}
