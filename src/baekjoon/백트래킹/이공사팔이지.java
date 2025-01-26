package baekjoon.백트래킹;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 이공사팔이지 {


    public static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                map[i][j] = sc.nextInt();
            }
        }

        dfs(map, 0);



        System.out.println(maxNum);

    }

    public static void dfs(int[][] map, int depth) {

        if (depth == 5) {
            maxNum = Math.max(maxNum, sumMap(map));
            return;
        }

        for (int i = 0; i < 4; i++) {

            int [][] tempMap2 = new int[map.length][map[0].length];
            for (int x = 0; x <map.length; x++) {
                for (int y = 0; y <map[0].length; y++) {
                    tempMap2[x][y] = map[x][y];
                }
            }
            pushMap(map, i);
            dfs(map, depth + 1);
            for (int x = 0; x <map.length; x++) {
                for (int y = 0; y <map[0].length; y++) {
                    map[x][y] = tempMap2[x][y];
                }
            }
        }
    }

    public static void pushMap(int[][] map, int i) {



        // 오른쪽
        if (i == 0) {
            for (int t = 0; t < map.length; t++) {

                for (int k = 0; k < map[0].length; k++) {
                    for (int z = map[0].length - 1; z > 0; z--) {
                        if (map[t][z] == 0) {
                            map[t][z] = map[t][z - 1];
                            map[t][z - 1] = 0;
                        }
                    }
                }

                for (int k = map[0].length - 1; k > 0; k--) {

                    if (map[t][k] == map[t][k - 1]) {
                        map[t][k] = map[t][k] + map[t][k - 1];
                        map[t][k - 1] = 0;
                    }
                }
                for (int k = 0; k < map[0].length; k++) {
                    for (int z = map[0].length - 1; z > 0; z--) {
                        if (map[t][z] == 0) {
                            map[t][z] = map[t][z - 1];
                            map[t][z - 1] = 0;
                        }
                    }
                }




            }

        }
        // 왼쪽
        else if (i == 1) {

            for (int t = 0; t < map.length; t++) {

                for (int k = 0; k < map[0].length; k++) {
                    for (int z = 1; z < map[0].length; z++) {
                        if (map[t][z - 1] == 0) {
                            map[t][z - 1] = map[t][z];
                            map[t][z] = 0;
                        }
                    }
                }


                for (int k = 0; k < map[0].length - 1; k++) {

                    if (map[t][k] == map[t][k + 1]) {
                        map[t][k] = map[t][k] + map[t][k + 1];
                        map[t][k + 1] = 0;
                    }
                }

                for (int k = 0; k < map[0].length; k++) {
                    for (int z = 1; z < map[0].length; z++) {
                        if (map[t][z - 1] == 0) {
                            map[t][z - 1] = map[t][z];
                            map[t][z] = 0;
                        }
                    }
                }



            }
        }
        // 상
        else if (i == 2) {
            for (int k = 0; k < map[0].length; k++) {

                for (int t = 0; t < map.length; t++) {
                    for (int z = 1; z < map.length; z++) {
                        if (map[z - 1][k] == 0) {
                            map[z - 1][k] = map[z][k];
                            map[z][k] = 0;
                        }
                    }
                }

                for (int t = 0; t < map.length - 1; t++) {

                    if (map[t][k] == map[t + 1][k]) {
                        map[t][k] = map[t][k] + map[t + 1][k];
                        map[t + 1][k] = 0;
                    }
                }



                for (int t = 0; t < map.length; t++) {
                    for (int z = 1; z < map.length; z++) {
                        if (map[z - 1][k] == 0) {
                            map[z - 1][k] = map[z][k];
                            map[z][k] = 0;
                        }
                    }
                }


            }
        }
        // 하
        else if (i == 3) {
            for (int k = 0; k < map[0].length; k++) {

                for (int t = 0; t < map.length; t++) {
                    for (int z = map.length - 1; z > 0; z--) {
                        if (map[z][k] == 0) {
                            map[z][k] = map[z - 1][k];
                            map[z - 1][k] = 0;
                        }
                    }
                }

                for (int t = map.length - 1; t > 0; t--) {

                    if (map[t][k] == map[t - 1][k]) {
                        map[t][k] = map[t][k] + map[t - 1][k];
                        map[t - 1][k] = 0;
                    }
                }


                for (int t = 0; t < map.length; t++) {
                    for (int z = map.length - 1; z > 0; z--) {
                        if (map[z][k] == 0) {
                            map[z][k] = map[z - 1][k];
                            map[z - 1][k] = 0;
                        }
                    }
                }



            }
        }



    }

    public static int sumMap(int[][] map) {
        int sum = Integer.MIN_VALUE;
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                sum = Math.max(sum, map[x][y]);
            }
        }

        return sum;
    }
}
