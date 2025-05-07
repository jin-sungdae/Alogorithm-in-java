package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 나무자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long [] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long left = 0, right = arr[n - 1], answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long num = check(arr, mid);

            if (num >= m) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);

    }

    static long check(long[] arr, long target) {
        long num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                num += (arr[i] - target);
            }
        }
        return num;
    }
}
