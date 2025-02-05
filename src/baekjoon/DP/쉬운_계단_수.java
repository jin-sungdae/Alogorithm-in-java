package baekjoon.DP;

import java.util.Scanner;

/**
 * 계단 수 문제와 현재 상태 연결
 * 이제 우리가 풀고 있는 **"계단 수 문제"**에서 이전 상태를 활용하는 이유를 살펴보겠습니다.
 *
 * ✅ 이 문제의 핵심 조건:
 *
 * 각 자리 숫자의 차이가 1이어야 한다.
 * 예를 들어, 45656이라는 숫자는 4 → 5 → 6 → 5 → 6처럼 연속된 숫자의 차이가 1이어야 한다.
 * 이 조건을 생각하면, N=3일 때 가능한 계단 수를 만들기 위해서는 N=2일 때의 숫자들을 활용해야 함을 알 수 있습니다.
 *
 * 예제:
 * 만약 우리가 길이가 3이고 마지막 숫자가 2인 계단 수를 구하려고 한다면:
 *
 * 가능한 숫자: 210, 212, 232, 234
 * 즉, N=3, 끝자리=2가 되려면, N=2에서 끝자리가 1이거나 3이었던 경우에서만 올 수 있음.
 *
 * 이걸 일반화하면:
 *
 * dp[3][2] = dp[2][1] + dp[2][3]
 * 즉, 현재 상태를 이전 상태에서 만들 수 있다는 규칙을 찾는 것이 핵심입니다.
 * → 이걸 모르고 매번 새롭게 숫자를 만들어 계산하면 중복 계산이 너무 많아지고 시간 초과가 발생합니다.
 */
public class 쉬운_계단_수 {
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        int [][] dp = new int[n+1][10];

        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % MOD;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % MOD;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
                }

            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res = (res + dp[n][i]) % MOD;
        }

        System.out.println(res);

    }
}
