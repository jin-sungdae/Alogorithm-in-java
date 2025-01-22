package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {

    public static class Node {
        int x;
        String length;

        Node (int x, String length) {
            this.x = x;
            this.length = length;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            String str = bfs(n, m);
            System.out.println(str);
        }

    }

    public static String bfs(int n, int m) {

        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        q.offer(new Node(n, ""));
        visited[n] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == m) {
                return cur.length + "";
            }

            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                if (i == 0) {
                    newX = (cur.x * 2) % 10000;
                    if (!visited[newX]) {
                        q.offer(new Node(newX, cur.length + "D"));
                        visited[newX] = true;
                    }
                } else if (i == 1) {

                    if (newX == 0) {
                        newX = 9999;
                    } else {
                        newX = cur.x - 1;
                    }
                    if (!visited[newX]) {
                        q.offer(new Node(newX, cur.length + "S"));
                        visited[newX] = true;
                    }

                } else if (i == 2) {
                    int firstDigit = newX / 1000;
                    int remaining = newX % 1000;

                    newX =  remaining * 10 + firstDigit;
                    if (!visited[newX]) {
                        q.offer(new Node(newX, cur.length + "L"));
                        visited[newX] = true;
                    }

                } else if (i == 3) {
                    int lastDigit = newX % 10;
                    int remaining = newX / 10;

                    newX = lastDigit * 1000 + remaining;
                    if (!visited[newX]) {
                        q.offer(new Node(newX, cur.length + "R"));
                        visited[newX] = true;
                    }

                }



            }
        }

        return "";
    }
}
