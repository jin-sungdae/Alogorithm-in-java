package baekjoon.자료구조;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 음악프로그램_위상정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] arr = new int[N + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int j = 1; j < a; j++) {
                int x = sc.nextInt();

                graph.get(b).add(x);
                arr[x]++;
                b = x;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            int next = pq.poll();
            res.add(next);

            for (int x : graph.get(next)) {
                arr[x]--;
                if (arr[x] == 0) {
                    pq.add(x);
                }
            }
        }

        if (res.isEmpty() || res.size() != N) {
            System.out.println(0);
            return ;
        }

        for (Integer x : res) {
            System.out.println(x);
        }
    }
}
