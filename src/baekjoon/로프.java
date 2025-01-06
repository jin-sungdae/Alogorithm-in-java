package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 로프 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);




        int sum = arr[0] * n;
        int temp = n - 1;
        for (int i = 1; i < n; i++) {
            if (sum <= arr[i] * temp) {
                sum = arr[i] * temp;
            }
            temp--;
        }

        System.out.println(sum);
    }
}
