package baekjoon.BFS;

import java.util.*;

public class 아기_상어 {

    public static class Node {
        int x, y, distance, size, eat;

        Node(int x, int y, int distance, int size, int eat) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.size = size;
            this.eat = eat;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] == 9) { // 아기 상어 초기 위치
                    x = i;
                    y = j;
                    arr[i][j] = 0; // 상어 위치를 빈 칸으로 초기화
                }
            }
        }

        Node node = new Node(x, y, 0, 2, 0);
        int totalDistance = 0;

        while (true) {
            Node result = bfs(node.x, node.y, arr, n, node.size);

            if (result == null) { // 먹을 물고기가 없으면 종료
                break;
            }

            // 상태 갱신
            arr[result.x][result.y] = 0;
            node.x = result.x;
            node.y = result.y;
            node.distance = result.distance;
            totalDistance += result.distance;
            node.eat++;

            if (node.eat == node.size) { // 크기 증가 조건
                node.size++;
                node.eat = 0;
            }
        }

        System.out.println(totalDistance);
    }

    public static Node bfs(int startX, int startY, int[][] arr, int n, int sharkSize) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        List<Node> candidates = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        q.add(new Node(startX, startY, 0, sharkSize, 0));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY]) {
                    if (arr[newX][newY] <= sharkSize) { // 이동 가능한 칸
                        visited[newX][newY] = true;

                        if (arr[newX][newY] > 0 && arr[newX][newY] < sharkSize) { // 먹을 수 있는 물고기
                            candidates.add(new Node(newX, newY, cur.distance + 1, sharkSize, 0));
                        }

                        q.add(new Node(newX, newY, cur.distance + 1, sharkSize, 0));
                    }
                }
            }
        }

        // 먹을 물고기 선택
        if (!candidates.isEmpty()) {
            candidates.sort((a, b) -> {
                if (a.distance != b.distance) return a.distance - b.distance; // 거리 우선
                if (a.x != b.x) return a.x - b.x; // 위쪽 우선
                return a.y - b.y; // 왼쪽 우선
            });
            return candidates.get(0);
        }

        return null; // 먹을 물고기 없음
    }
}