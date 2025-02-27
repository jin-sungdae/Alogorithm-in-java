package programmers.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 택배_상자_꺼내기 {

    static class Solution {
        public static int solution(int n, int w, int num) {
            int answer = 0;

            int[][] map = new int[n / w + 1][w];


            int count = 1;
            int maxWeight = n / w;
            for (int i = maxWeight; i >= 0; i--) {
                if ((i % 2 == 0 && maxWeight % 2 == 0) || (i % 2 == 1 && maxWeight % 2 == 1)) {
                    for (int j = w - 1; j >= 0; j--) {
                        if (n < count) {
                            map[i][j] = 0;
                        } else {
                            map[i][j] = count;
                            count++;
                        }
                    }
                } else if ((i % 2 == 1 && maxWeight % 2 == 0) || (i % 2 == 0 && maxWeight % 2 == 1)) {
                    for (int j = 0; j < w; j++) {
                        if (n < count) {
                            map[i][j] = 0;
                        } else {
                            map[i][j] = count;
                            count++;
                        }
                    }
                }

            }

            List<List<Integer>> transposedList = new ArrayList<>();

            for (int j = 0; j < w; j++) {
                List<Integer> newRow = new ArrayList<>();
                for (int i = 0; i < maxWeight + 1; i++) {
                    newRow.add(map[i][j]);
                }
                transposedList.add(newRow);
            }

           int row = 0;
            for (int i = 0; i < transposedList.size(); i++) {
                for (int j = 0; j < transposedList.get(i).size(); j++) {
                    if (transposedList.get(i).get(j) == num) {
                       row = i;
                    }
                }
            }

            for (int i = 0; i < transposedList.get(row).size(); i++) {
                if (transposedList.get(row).get(i) != 0 && transposedList.get(row).get(i) >= num) {
                    answer++;
                }
            }

            for (int i = 0; i < maxWeight + 1; i++) {
                for (int j = 0; j < w; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }


            return answer;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Solution.solution(22,	6,	8));
        System.out.println(Solution.solution(13	,3,	6));
    }
}
