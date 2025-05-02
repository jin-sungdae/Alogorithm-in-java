package baekjoon.투포인터;

import java.util.Scanner;

public class 수들의_합_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            A[i] = a;
        }



        int left = 0, right = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= M) {
                sum -= A[left++];
            } else if (right == N) {
                break;
            } else {
                sum += A[right++];
            }

            if (sum == M) {
                count++;
            }
        }

        System.out.println(count);
    }
}
