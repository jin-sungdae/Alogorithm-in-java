package baekjoon.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 전깃줄_LIS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[][] a  = new int[n][2];
        int [] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i][1] > a[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }

          }
            maxLen = Math.max(maxLen, dp[i]);
        }




        System.out.println(n - maxLen );

    }
}
