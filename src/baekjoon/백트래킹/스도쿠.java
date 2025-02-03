package baekjoon.백트래킹;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 스도쿠 {
    public static int[][] newMap = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [][] map = new int[9][9];

        List<int[]> arr = new ArrayList<int[]>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 0) {
                    arr.add(new int[]{i, j});
                }
            }
        }


        dfs(map, arr, 0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(newMap[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void dfs(int[][] map , List<int[]> arr, int t) {

        if (t == arr.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    newMap[i][j] = map[i][j];
                }
            }
            return;
        }



            int[] num = new int[9];
            int[] newNum = new int[9];
            int a = arr.get(t)[0];
            int b = arr.get(t)[1];


            for (int i = 0; i < 9; i++) {
                if (map[a][i] != 0) {
                    num[map[a][i] - 1] = 1;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (num[i] == 0) {
                    newNum[i]++;
                }
            }

            num = new int[9];

            for (int i = 0; i < 9; i++) {
                if (map[i][b] != 0) {
                    num[map[i][b] - 1] = 1;
                }
            }

            for (int i = 0; i < 9; i++) {
                if (num[i] == 0) {
                    newNum[i]++;
                }
            }


            for (int i = ((a / 3) * 3); i < ((a / 3) * 3) + 3; i++ ) {
                for (int j = ((b / 3) * 3); j < ((b / 3) * 3) + 3; j++ ) {
                    if (map[i][j] != 0) {
                        num[map[i][j] - 1] = 1;
                    }

                }
            }

            for (int i = 0; i < 9; i++) {
                if (num[i] == 0) {
                    newNum[i]++;
                }
            }


            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                if (newNum[i] == 3) {
                    numList.add(i + 1);
                }
            }

            for (Integer n : numList) {
                map[a][b] = n;
                dfs(map, arr, t + 1);
                map[a][b] = 0;
            }



    }
}
