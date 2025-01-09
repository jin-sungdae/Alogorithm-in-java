package baekjoon.DIJKSTRA;



import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 벽_부수고_이동하기 {

    public static class Node implements Comparable<Node> {
        int x, y, cost, distance;

        Node(int x, int y, int cost, int distance) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int res = dijkstra(n, m, map);
        System.out.println(res);
    }

    public static int dijkstra(int n, int m, int[][] map) {
        int [][][] dis = new int[n][m][2];

        for (int[][] layer : dis) {
            for (int [] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 1, 0));
        dis[0][0][0] = 1;


        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == n - 1 && cur.y == m - 1) {
                return cur.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    // 벽이 없는 곳으로 이동
                  if (map[nx][ny] == 0 && cur.cost + 1 < dis[nx][ny][cur.distance]) {
                      dis[nx][ny][cur.distance] = cur.cost + 1;
                      pq.offer(new Node(nx, ny, cur.cost + 1, cur.distance));
                  }

                  // 벽이 있는 곳으로 이동
                  if (map[nx][ny] == 1 && cur.distance == 0 && cur.cost + 1 < dis[nx][ny][1]) {
                      dis[nx][ny][1] = cur.cost + 1;
                      pq.offer(new Node(nx, ny, cur.cost + 1, 1));
                  }
                }
            }
        }

        return -1;
    }
}
