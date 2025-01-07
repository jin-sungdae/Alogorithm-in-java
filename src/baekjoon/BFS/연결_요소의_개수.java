package baekjoon.BFS;

import java.util.*;

/**
 * 문제
 * 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
 *
 * 출력
 * 첫째 줄에 연결 요소의 개수를 출력한다.
 */
public class 연결_요소의_개수 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr.get(a).add(b);
            arr.get(b).add(a);

        }


        // 방문 배열
        boolean[] visited = new boolean[n + 1];

        // 연결 요소 개수
        int components = 0;

        // 모든 정점을 탐색
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) { // 방문하지 않은 정점 발견
                bfs(arr, visited, i); // BFS 실행
                components++; // 연결 요소 카운트 증가
            }
        }

        // 결과 출력
        System.out.println(components);
    }

    public static void bfs(List<List<Integer>> arr, boolean[] visited, int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;


        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : arr.get(current)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);

                }
            }
        }


    }
}
