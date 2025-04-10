package programmers.algorithm;

public class 거스름돈 {

    public static int solution(int n, int[] money) {
        int answer = 0;

        int [] dp = new int[n + 1];
        // dp
        dp[0] = 1;  // 자기 자신의 수
        for (int coin : money)
            for (int i = coin; i <= n; i++)
                dp[i] += dp[i - coin];

        return dp[n];
    }

    public static void main(String[] args) {

        int [] money = new int[]{1,2,5};
        System.out.println(solution(5, money));
    }
}
