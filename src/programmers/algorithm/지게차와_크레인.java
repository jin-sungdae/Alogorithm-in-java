package programmers.algorithm;

import java.util.*;

public class 지게차와_크레인 {

    class Solution {
        static class Node {
            int x, y;

            Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public static int solution(String[] storage, String[] requests) {
            int answer = 0;

            int rows = storage.length + 2;
            int cols = storage[0].length() + 2;
            char[][] map = new char[rows][cols];
            Arrays.fill(map[0], '0');
            Arrays.fill(map[rows - 1], '0');




            for (int i = 0; i < storage.length; i++) {
                map[i + 1][0] = '0';
                for (int j = 0; j < storage[i].length(); j++) {
                    map[i + 1][j + 1] = storage[i].charAt(j);
                }

                map[i + 1][storage[i].length() + 1] = '0';
            }



            for (String request : requests) {
                if (request.length() == 1) {
                    bfs(map, 0, 0, request.charAt(0));
                } else {
                    checkMap(map, request);
                }

            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j] != '0') {
                        answer++;
                    }

                }

            }



            return answer;
        }

        public static void bfs(char[][] map, int x, int y, char s) {

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(x, y));
            map[x][y] = '0';
            boolean[][] visited = new boolean[map.length][map[0].length];
            visited[x][y] = true;
            int [] dx = {-1, 1, 0, 0};
            int [] dy = {0, 0, -1, 1};

            while (!q.isEmpty()) {
                Node node = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == s) {
                        map[nx][ny] = '0';
                        visited[nx][ny] = true;
                    }

                    if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == '0' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny));
                    }
                }

            }
        }

        public static void checkMap(char[][] map, String s) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j] == s.charAt(0)) {
                        map[i][j] = '0';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] storage = {"HAH", "HBH", "HHH", "HAH", "HBH"};
        String[] requests = {"C", "B", "B", "B", "B", "H"};

        System.out.println(Solution.solution(storage, requests));
    }

}
