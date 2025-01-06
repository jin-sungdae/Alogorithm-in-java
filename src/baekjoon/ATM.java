package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int [] arr = new int[N];
        int [] tempArr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        Arrays.sort(arr);


        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
            tempArr[i] = sum;
        }

        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += tempArr[i];
        }

        System.out.println(sum);

    }
}
