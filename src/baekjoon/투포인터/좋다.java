package baekjoon.투포인터;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1, count = 0;
        long sum = 0;

        for (int k = 0; k < n; k++ ){
            i = 0;
            j = n - 1;
            sum = 0;
            while (i < j) {
                if (i == k) { i++; continue; }
                if (j == k) { j--; continue; }
                sum = arr[i] + arr[j];

                if (sum == arr[k]) {
                    count++;
                    break;
                } else if (sum < arr[k]) {
                    i++;
                } else if (sum > arr[k]) {
                    j--;
                }


            }
        }


        System.out.println(count);
    }
}
