package baekjoon;

import java.util.List;
import java.util.Scanner;

public class 경로찾기 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // 입력 받기
            int n = sc.nextInt();
            int[][] graph = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            // 플로이드-와샬 알고리즘
            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) {
                            graph[i][j] = 1;
                        }
                    }
                }
            }

            // 결과 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }

            sc.close();
        }


}
