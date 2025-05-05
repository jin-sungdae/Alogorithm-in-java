package baekjoon.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 용액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        long sum = 0, temp = Long.MAX_VALUE, num1 = 0, num2 = 0;

        while (i < j) {
            sum = arr[i] + arr[j];

            if (Math.abs(sum) < Math.abs(temp)) {
                temp = sum;
                num1 = arr[i];
                num2 = arr[j];
            }

            if (sum == 0) break;
            if (sum < 0) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(num1 + " " + num2);
    }
}
