package programmers.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 비밀_코드_해독 {

    public static int ch = 0;

    public class Solution {
        public static int solution(int n, int[][] q, int[] ans) {
            int answer = 0;


            dfs(n, 1, q[0].length, new ArrayList<>(), q, ans, n);

            System.out.println(ch);

            return answer;
        }

        public static void bigDfs(List<Integer> arr, int[] ans, int[][] q) {


            int count = 0;
            int check = 0;

            for (int t = 1; t < q.length; t++) {
                count = 0;

                for (int i = 0; i < arr.size(); i++) {
                    for (int j = 0; j < q[t].length; j++) {
                        if (arr.get(i) == q[t][j]) {
                            count++;
                        }
                    }
                }

                if (ans[t] == count) {
                    check++;
                }
            }

            if (check == ans.length - 1) {
                ch++;
            }



        }


        public static void dfs(int nums, int start, int k, List<Integer> current, int [][] q, int[] ans, int n) {

            if (current.size() == k) {
                checkNum(current, q, ans);
                return;
            }

            for (int i = start; i <= n; i++) {
                current.add(i);
                dfs(i, i + 1, k, current, q, ans, n);
                current.remove(current.size() - 1);
            }
        }

        public static void checkNum(List<Integer> nums, int[][] q, int[] ans) {

            int count = 0;
            for (int i = 0; i < nums.size(); i++) {

                for (int j = 0; j < q[0].length; j++) {
                    if (nums.get(i) == q[0][j]) {
                        count++;
                    }
                }

            }

            if (ans[0] == count) {
                bigDfs(nums, ans, q);
            }

        }
    }

    public static void main(String[] args) {
        int [][] q = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int [] ans = new int[]{2, 3, 4, 3, 3};

        Solution.solution(10, q, ans);
    }
}
