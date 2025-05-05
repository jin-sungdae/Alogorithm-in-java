package baekjoon.투포인터;

import java.util.Scanner;

public class 냅색문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int count = 1, sum = 0;
        int i = 0, j = 0;

        while (j < n) {
            sum += arr[j++];

            if (sum < n) {

            }
        }
    }
}
