package baekjoon.이분탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 공유기_설치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int left = 1;
        int right = arr[n - 1] - arr[0];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(arr, c, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid  - 1;
            }
        }

        System.out.println(answer);

    }

    static boolean check(int[] arr, int c, int d) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= d) {
                count++;
                last = arr[i];
            }
        }

        return count >= c;
    }
}
