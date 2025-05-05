package baekjoon.투포인터;


import java.util.Arrays;
import java.util.Scanner;

public class 소수의_연속합 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = getPrimesUpTo(n);

        int i = 0, j = 0, sum = 0, count = 0;

        while (j < arr.length) {

            sum += arr[j++];

            while (sum > n) {
                sum -= arr[i++];
            }

            if (sum == n) {
                count++;
                sum -= arr[i++];
            }
        }

        System.out.println(count);


    }

    public static int[] getPrimesUpTo(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        int sqrtLimit = (int) Math.sqrt(limit);
        for (int i = 2; i <= sqrtLimit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }


        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) count++;
        }

        int[] primes = new int[count];
        int index = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes[index++] = i;
            }
        }

        return primes;
    }
}
