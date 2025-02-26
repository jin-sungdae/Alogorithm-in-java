package baekjoon.DP;

import java.util.Scanner;

public class 피보나치_수일 {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static int fibonacci(int n) {
        int[] f = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2++;
        }
        return f[n];
    }
}
