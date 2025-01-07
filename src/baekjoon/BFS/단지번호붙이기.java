package baekjoon.BFS;

import java.util.*;

public class 단지번호붙이기 {

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

        int [][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (map[i][j] == 1) {
                    list.add(bfs(map, i, j, n));
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    public static int bfs(int[][] map, int x, int y, int n) {
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[n][n];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        int distance = 1;
        while (!queue.isEmpty()) {
            Node node = queue.poll();


            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.distance + 1));
                    map[nx][ny] = 0;
                    distance++;
                }
            }
        }

        return distance;
    }

}
