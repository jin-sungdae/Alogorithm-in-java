package programmers.algorithm;

import java.util.*;

public class 표_편집 {

    /**
     * "U X": 현재 선택된 행에서 X칸 위에 있는 행을 선택합니다.
     * "D X": 현재 선택된 행에서 X칸 아래에 있는 행을 선택합니다.
     * "C" : 현재 선택된 행을 삭제한 후, 바로 아래 행을 선택합니다. 단, 삭제된 행이 가장 마지막 행인 경우 바로 윗 행을 선택합니다.
     * "Z" : 가장 최근에 삭제된 행을 원래대로 복구합니다. 단, 현재 선택된 행은 바뀌지 않습니다.
     * @param n
     * @param k
     * @param cmd
     * @return
     */
    public static String solution(int n, int k, String[] cmd) {


        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] removed = new boolean[n];


        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;


        Deque<Integer> stack = new ArrayDeque<>();




        int point = k;
        for (String x : cmd) {
            if (x.startsWith("U")) {
                String[] u = x.split(" ");
                int num = Integer.parseInt(u[1]);
                for (int i = 0; i < num; i++) {
                    point = prev[point];
                }
            } else if (x.startsWith("D")) {
                String[] u = x.split(" ");
                int num = Integer.parseInt(u[1]);
                for (int i = 0; i < num; i++) {
                    point = next[point];
                }
            } else if (x.startsWith("C")) {
                stack.push(point);
                removed[point] = true;

                if (prev[point] != -1) {    // 맨앞
                    next[prev[point]] = next[point];
                }

                if (next[point] != -1) {        // 맨끝
                    prev[next[point]] = prev[point];
                }

                point = (next[point] != -1) ? next[point] : prev[point];
            } else if (x.startsWith("Z")) {
                int restore = stack.pop();
                removed[restore] = false;

                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(removed[i] ? 'X' : 'O');
        }
        return sb.toString();
    }

    public static void main(String[] args) {

//        String[] cmd = new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};



        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n, k, cmd));  // "OOOOXOOO"
    }
}
