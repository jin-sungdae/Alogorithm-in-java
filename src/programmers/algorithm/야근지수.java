package programmers.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 야근지수 {

    public static long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i : works) {
            q.add(i);
        }

        for (int i = 0; i < n && q.size() != 0; i++) {
            Integer a = q.poll();

            a = a - 1;
            if (a != 0) {
                q.add(a);
            }

        }

        int len = q.size();
        for (int i = 0; i < len; i++) {
            int a = q.poll();
            answer = answer + (a * a);
        }


        return answer;
    }

    public static void main(String[] args) {

        int n = 3;
        int[] works = {1, 1};
        long answer = solution(n, works);
        System.out.println(answer);
    }
}
