package baekjoon.DP;

import java.util.Scanner;

public class 파도반_수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int reA = a;
            if (a <= 6) {
              a = 6;
            }
            long [] dp = new long[a + 3];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;
            dp[5] = 2;
            dp[6] = dp[3] + dp[5];
            dp[7] = dp[2] + dp[6];
            dp[8] = dp[1] + dp[7];
            if (a == 6) {
                System.out.println(dp[reA]);
            } else {
                for (int j = 9; j <= a; j++) {
                    dp[j] = dp[j - 5] + dp[j - 1];
               }
                System.out.println(dp[reA]);
            }




        }
    }
}
