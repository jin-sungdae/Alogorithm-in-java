package baekjoon.BFS;

import java.util.*;

public class 치즈 {

    public static class Node {
        int x, y;

        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        List<Integer> list = new ArrayList<>();
        int count = 0;

        while (true) {
            make9Map(map);
            boolean ch = makeMap(map);
            make0Map(map);
            if (ch) break;

            boolean[][] visited = new boolean[n][m];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 2) {
                        count = count + bfs(map, i, j, visited);
                    }
                }
            }

            list.add(count);
            time++;

        }

        System.out.println(time);
        System.out.println(list.get(list.size() - 1));


    }

    public static int bfs(int[][] map, int x, int y, boolean[][] visited ) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        int size = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visited[x][y] = true;
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 2) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx,ny));
                    map[nx][ny] = 0;
                    size++;
                }
            }
        }

        return size;

    }

    public static boolean makeMap(int[][] map) {
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        boolean check = true;



        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (map[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 9) {
                            map[i][j] = 2;
                            check = false;

                        }
                    }
                }

            }
        }

        return check;
    }


    public static void make9Map(int[][] map) {
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        Boolean[][] visited = new Boolean[map.length][map[0].length];
        visited[0][0] = true;
        map[0][0] = 9;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 0) {
                    map[nx][ny] = 9;
                    queue.add(new Node(nx,ny));
                }
            }
        }
    }

    public static void make0Map(int[][] map) {
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};


        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        map[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 9) {
                    map[nx][ny] = 0;
                    queue.add(new Node(nx,ny));
                }
            }
        }
    }


}
