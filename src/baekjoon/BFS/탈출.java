package baekjoon.BFS;

import java.util.*;

public class 탈출 {

    public static class Node {
        int x, y, count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String [][] map = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        boolean[][] qVisited = new boolean[n][m];

        int x = 0;
        int y = 0;
        int lX = 0;
        int lY = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) + "";
                if (map[i][j].equals("S")) {
                    x = i;
                    y = j;
                }
                if (map[i][j].equals("D")) {
                    lX = i;
                    lY = j;
                }
                if (map[i][j].equals("*")) {
                    q.add(new Node(i, j, 0));
                    qVisited[i][j] = true;
                }
            }
        }

        int res = bfs(map, visited, x, y, lX, lY, q, qVisited);
        if (res == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(res);
        }


    }

    public static int bfs(String [][] map, boolean[][] visited, int i, int j, int lX, int lY, Queue<Node> q, boolean[][] qVisited) {

        visited[i][j] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j, 0));

        while (!queue.isEmpty()) {


            int [] dx = {-1, 1, 0, 0};
            int [] dy = {0, 0, -1, 1};


            makeMap(map, dx, dy, q, qVisited);

            int size = queue.size();

            for (int t = 0; t < size; t++) {
                Node node = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = node.x + dx[k];
                    int ny = node.y + dy[k];

                    if (nx == lX && ny == lY) {
                        return node.count + 1;
                    }

                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && !map[nx][ny].equals("S") && !map[nx][ny].equals("*") && !map[nx][ny].equals("X")) {

                        visited[nx][ny] = true;
                        map[nx][ny] = "S";
                        queue.add(new Node(nx, ny, node.count + 1));




                    }
                }
            }


        }

        return -1;
    }

    public static void makeMap(String [][] map, int[] dx, int[] dy, Queue<Node> q, boolean[][] qVisited) {


        int size = q.size();

        for (int i = 0; i < size; i++) {

            Node node = q.poll();


            for (int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny].equals(".") && !qVisited[nx][ny]) {
                    map[nx][ny] = "*";
                    q.add(new Node(nx, ny, 0));
                    qVisited[nx][ny] = true;
                }
            }
        }


    }


}
