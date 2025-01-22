package baekjoon.BFS;

import java.util.*;

public class 뱀과_사다리_게임 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] board = new int[101];

        for (int i = 0; i < 101; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            board[a] = b;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            board[a] = b;
        }


        int res = bfs(board);
        System.out.println(res);
    }

    public static int bfs(int[] board) {
        Queue<int []> queue = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int []x = {1, 2, 3, 4, 5, 6};

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int position = cur[0];
            int count = cur[1];

            if (position == 100) {
                return count;
            }

            for (int i = 0; i < 6; i++) {
                int newX = position + x[i];

                if (newX > 0 && newX < 101 && !visited[newX]) {
                    queue.offer(new int[]{board[newX], count + 1});
                    visited[newX] = true;
                }
            }
        }

        return -1;

    }

}
