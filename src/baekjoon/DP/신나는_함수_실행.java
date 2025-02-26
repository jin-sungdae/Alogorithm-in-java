package baekjoon.DP;

import java.util.Scanner;

public class 신나는_함수_실행 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int reA = a;
            int reB = b;
            int reC = c;
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            if (a <= -1) {
                reA = 0;
            }
            if (b <= -1) {
                reB = 0;
            }
            if (c <= -1) {
                reC = 0;
            }

            int[][][] dp = new int[reA + 1][reB + 1][reC + 1];


            dp[0][0][0] = 0;

            for (int i = 0; i < reA + 1; i++) {
                for (int j = 0; j < reB + 1; j++) {
                    for (int k = 0; k < reC + 1; k++) {

                        if (i <= 0 || j <= 0 || k <= 0) {
                            dp[i][j][k] = 1;
                        } else if (i > 20 || j > 20 || k > 20) {
                            dp[i][j][k] = 1048576;
                        } else if (i < j && j < k) {
                            dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
                        } else {
                            dp[i][j][k] = dp[i - 1][j][k] + dp[i -1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
                        }

                    }
                }
            }
            System.out.println("w(" + a + ", " + b + ", " + c +") = " + dp[a <= -1 ? 0 : a][b <= -1 ? 0 : b][c <= -1 ? 0 : c]);
        }


    }
}
