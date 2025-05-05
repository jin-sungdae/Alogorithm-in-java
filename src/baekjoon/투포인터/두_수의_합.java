package baekjoon.투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class 두_수의_합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        Arrays.sort(arr);

        int i = 0, j = n - 1, sum = 0, count = 0;

        while (i < j) {
            sum = arr[i] + arr[j];

            if (sum == m) {
                count++;
                i++;
                j--;
            } else if (sum < m) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(count);

    }
}
