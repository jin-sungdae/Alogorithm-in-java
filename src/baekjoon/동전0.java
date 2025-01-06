package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr = new Integer[n]; // 배열 선언 (내림차순 정렬 위해 Integer 사용)
        for (int i = 0; i < n; i++) { // 입력받기
            arr[i] = sc.nextInt();
        }

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());

        int j = 0;
        int cnt = 0;
        while (true) {

            if (k - arr[j] < 0) {
                j++;
            } else {
                k = k - arr[j];
                cnt++;
            }

            if (k <= 0) {
                break;
            }
        }

        System.out.println(cnt);
    }
}
