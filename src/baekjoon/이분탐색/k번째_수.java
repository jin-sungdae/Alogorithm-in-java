package baekjoon.이분탐색;

import java.util.Scanner;

public class k번째_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();


        long left = 1, right = k, answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid, n) >= k) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static long check(long mid, int n) {
        long count = 0;

        for (int i = 1; i <= n; i++) {
            count += Math.min(mid / i, n);
        }

        return count;
    }
}
