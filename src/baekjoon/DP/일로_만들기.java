package baekjoon.DP;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 일로_만들기 {

    static class Node implements Comparable<Node> {
        int position, cost;

        Node(int position, int cost) {
            this.position = position;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = dijkstra(n, 1);
        System.out.println(result);
    }

    public static int dijkstra(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int currentPosition = cur.position;
            int currentCost = cur.cost;

            if (currentPosition == start) {
                return currentCost;
            }

            if (currentCost > dist[currentPosition]) {
                continue;
            }

            // X / 3
            if (currentPosition % 3 == 0) {
                int newCost = currentCost + 1;
                if (newCost < dist[currentPosition / 3]) {
                    dist[currentPosition / 3] = newCost;
                    pq.add(new Node(currentPosition / 3, newCost));
                }
            }


            // X / 2
            if (currentPosition % 2 == 0) {
                int newCost = currentCost + 1;
                if (newCost < dist[currentPosition / 2]) {
                    dist[currentPosition / 2] = newCost;
                    pq.add(new Node(currentPosition / 2, newCost));
                }
            }


            // X - 1
            if (currentPosition - 1 >= 1) {
                int newCost = currentCost + 1;
                if (newCost < dist[currentPosition - 1]) {
                    dist[currentPosition - 1] = newCost;
                    pq.add(new Node(currentPosition - 1, newCost));
                }
            }
        }

        return -1;
    }
}
