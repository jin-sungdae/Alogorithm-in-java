package baekjoon.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 인구_이동 {

    public static class Node {
        public int x, y, distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();
        int [][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int dayCount = 0;

        while (true) {
            boolean [][] visited = new boolean[n][n];
            int count = 0;
            boolean check = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        count = bfs(map, i, j, n, L, R, visited);

                        if (count > 0) {
                            check = true;
                        }
                    }

                }
            }


            if (!check) {
                break;
            }

            dayCount++;




        }

        System.out.println(dayCount);
    }

    public static int bfs(int [][] map, int x, int y, int n, int L, int R, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        List<Node> union = new LinkedList<>();

        visited[x][y] = true;
        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};
        q.add(new Node(x,y,0));
        union.add(new Node(x,y,0));

        int peopleCount = map[x][y];
        int count = 1;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    int temp = Math.abs(map[newX][newY] - map[cur.x][cur.y]);
                    if (temp >= L && temp <= R) {
                        visited[newX][newY] = true;
                        q.add(new Node(newX,newY,0));
                        union.add(new Node(newX,newY,0));
                        peopleCount += map[newX][newY];
                        count++;
                    }
                }
            }

        }

        if (count == 1) {
            return 0;
        }


        int newPopulation = peopleCount / count;
        for (Node node : union) {
            map[node.x][node.y] = newPopulation;
        }

        return count;
    }
}
