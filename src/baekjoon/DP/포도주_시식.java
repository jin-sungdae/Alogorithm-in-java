package baekjoon.DP;

import java.util.Scanner;


/**
 * 🔹 3. 최적의 선택을 찾기
 * **"연속된 3잔을 모두 마실 수 없다"**는 조건 때문에 경우를 나누어야 합니다.
 *
 * dp[i] = i번째 포도주까지 마셨을 때 최대로 마실 수 있는 포도주의 양
 *
 * ✅ 경우의 수 3가지
 * 현재 잔을 마시지 않는 경우
 * → dp[i] = dp[i-1]
 * 현재 잔을 마시고, 이전 잔을 마시지 않는 경우
 * → dp[i] = dp[i-2] + wine[i]
 * 현재 잔을 마시고, 이전 잔도 마시는 경우 (이전 이전 잔은 마시면 안 됨)
 * → dp[i] = dp[i-3] + wine[i-1] + wine[i]
 * 즉, 점화식은 다음과 같이 정리할 수 있습니다.
 */
public class 포도주_시식 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] wine = new int[n + 1];
        int [] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        if (n >= 1) dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];
        if (n >= 3) dp[3] = Math.max(Math.max(dp[2], wine[1] + wine[3]), wine[2] + wine[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));

        }

        System.out.println(dp[n]);

    }
}
