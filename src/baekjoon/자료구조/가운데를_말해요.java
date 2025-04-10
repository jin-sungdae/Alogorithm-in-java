package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 가운데를_말해요 {
    static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap
    static PriorityQueue<Integer> right = new PriorityQueue<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            add(num);
            sb.append(getMedian()).append('\n');
        }

        System.out.print(sb); // 출력 한 번에
    }


    public static void add(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }


        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public static int getMedian() {
        return left.peek();
    }
}
