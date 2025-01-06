package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로_탐색 {


    public static class Node {
        int x, y, distance;

        Node (int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs(map, n, m);

        System.out.println(result);

    }

    public static int bfs(int[][] map, int n, int m) {
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][m];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == n - 1 && node.y == m - 1) {
                return node.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.distance + 1));
                }
            }
        }

        return -1;
    }
}
