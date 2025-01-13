package baekjoon.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 스타트링크 {

    public static class Node {
        int x, distance;

        Node(int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();



        int res = bfs(F, S, G, U, D);
        if (res != -1) {
            System.out.println(res);
        } else {
            System.out.println("use the stairs");
        }

    }

    public static int bfs(int F, int S, int G, int U, int D) {

        int [] arr = new int[F + 1];
        boolean[] visited = new boolean[F + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[S] = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(S, 0));

        int []dx = {U, -1 * D};
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == G) {
                return cur.distance;
            }

            for (int i = 0; i < 2; i++) {
                int nx = cur.x + dx[i];

                if (nx > 0 && nx <= F && !visited[nx]) {
                    visited[nx] = true;
                    q.add(new Node(nx, cur.distance + 1));
                }
            }

        }


        return -1;

    }


}
