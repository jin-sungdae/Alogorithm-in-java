package baekjoon.DIJKSTRA;

import java.util.*;

public class 미로만들기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String x = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = x.charAt(j) - '0';
            }
        }

        int res = dijkstra(map, n);


        System.out.println(res);

    }

    public static int dijkstra(int [][] map, int n) {

        Deque<int []> deque =  new ArrayDeque<>();
        int [][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        deque.add(new int [] {0, 0});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    int newCost = distance[x][y] + (map[nx][ny] == 0 ? 1 : 0);

                    if (newCost < distance[nx][ny]) {
                        distance[nx][ny] = newCost;
                        if (map[nx][ny] == 0) {
                            deque.add(new int [] {nx, ny});
                        } else {
                            deque.addFirst(new int [] {nx, ny});
                        }
                    }
                }
            }
        }

        return distance[n - 1][n - 1];
    }
}
