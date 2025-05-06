package baekjoon.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 가장_긴_증가하는_부분_수열_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] prev = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
            prev[i] = -1;
        }

        int maxLen = 1;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> lis = new ArrayList<>();

        while (lastIndex != -1) {
            lis.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        Collections.reverse(lis);

        System.out.println(lis.size());
        for (Integer x : lis) {
            System.out.print(x + " ");
        }
    }
}
