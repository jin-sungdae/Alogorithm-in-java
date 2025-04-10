package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] s = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Stack<int[]> stack = new Stack<>();


        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                s[i] = stack.peek()[0] + 1;
            }

            stack.push(new int[]{i, arr[i]});
        }

        for (int x : s) {
            System.out.print(x + " ");
        }

    }
}
