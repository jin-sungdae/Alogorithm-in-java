package baekjoon.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 부분합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int i = 0, j = 0, sum = 0, len = 0, lenMin = Integer.MAX_VALUE;

        while (j < n) {
                sum += arr[j++];

            while (sum >= m) {
                lenMin = Math.min(lenMin, j - i);
                sum -= arr[i++];
            }
        }

        if (lenMin == Integer.MAX_VALUE) {
            lenMin = 0;
        }
        System.out.println(lenMin);

    }
}
