package programmers.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최고의_집합 {


    public static int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int q = s / n;
        int r = s % n;

        int[] answer = new int[n];
        Arrays.fill(answer, q);
        for (int i = n - 1; i >= n - r; i--) {
            answer[i]++;
        }

        return answer;
    }
    public static void main(String[] args) {

        int [] rs = solution(2, 8);
        for (int x : rs) {
            System.out.println(x);
        }
    }
}
