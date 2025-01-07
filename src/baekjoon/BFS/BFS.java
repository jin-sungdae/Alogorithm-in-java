package baekjoon.BFS;

import java.util.*;

public class BFS {

    public static class Node {
        int x, y, distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        int n = sc.nextInt(); // 미로의 행
        int m = sc.nextInt(); // 미로의 열
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        // BFS 실행
        int result = bfs(maze, n, m);

        // 결과 출력
        System.out.println(result);
    }

    public static int bfs(int[][] maze, int n, int m) {
        // 방향 벡터 (상, 하, 좌, 우)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 방문 여부 체크 배열
        boolean[][] visited = new boolean[n][m];

        // BFS를 위한 큐 초기화
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1)); // 시작 위치 (0,0)에서 거리 1로 시작
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // 목표 지점 도달 시 거리 반환
            if (current.x == n - 1 && current.y == m - 1) {
                return current.distance;
            }

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 범위 내에 있고, 이동 가능하며, 방문하지 않은 경우
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.distance + 1));
                }
            }
        }

        // 도달할 수 없는 경우 (문제에서는 항상 도달 가능하다고 명시)
        return -1;
    }
}
