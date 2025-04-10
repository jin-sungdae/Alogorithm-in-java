package baekjoon.자료구조;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드_정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer>  q = new PriorityQueue<>();
        int [] sumArr = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            q.add(a);
        }


        int total = 0;
        while (q.size() > 1) {
            int a = q.poll();
            int b = q.poll();

            int sum = a + b;
            total += sum;
            q.add(sum);
        }


        System.out.println(total);
    }
}
