package baekjoon.자료구조;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 절대값_힙 {
    public static void main(String[] args) {
        // 우선순위 큐로 절대값이 가장 작은 수를 선택
        PriorityQueue<Integer> q = new PriorityQueue<>(
                (a, b) -> {
                    if (Math.abs(a) == Math.abs(b)) {
                        return a - b;
                    }
                    return Math.abs(a) - Math.abs(b);
                }
        );

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.add(num);
            }
        }
    }
}
