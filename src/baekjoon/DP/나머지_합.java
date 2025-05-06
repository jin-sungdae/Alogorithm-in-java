package baekjoon.DP;

import java.util.Scanner;

public class 나머지_합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] arr = new int[n];
        long[] count = new long[m];
        long sum = 0, answer = 0;

        count[0] = 1;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int mod = (int) (sum % m);

            if (mod < 0) mod += m;
            answer += count[mod];
            count[mod]++;
        }

        System.out.println(answer);
    }
}
