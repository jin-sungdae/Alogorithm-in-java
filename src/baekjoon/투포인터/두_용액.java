package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 두_용액 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;



        long num1 = 0, num2 = 0,  sum = 0,num = Long.MAX_VALUE;

        while (i < j) {
            sum = arr[i] + arr[j];

            if (Math.abs(sum) < Math.abs(num)) {
                num = sum;
                num1 = arr[i];
                num2 = arr[j];


            }
            if (sum == 0) break;
            if (sum < 0) {
                i++;
            } else if (sum > 0) {
                j--;
            }
        }
        System.out.println(num1+ " " + num2);
    }
}
