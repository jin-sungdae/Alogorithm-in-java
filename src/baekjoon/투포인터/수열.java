package baekjoon.투포인터;

import java.util.Scanner;

public class 수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int temp = 0;

        while (j < n) {
            temp += arr[j++];
            if (j - i > k ) {
                temp -= arr[i++];
            }
            if (j - i == k){
                sum = Math.max(sum, temp);

            }
        }

        System.out.println(sum);
    }
}
