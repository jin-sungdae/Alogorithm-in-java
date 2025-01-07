package baekjoon.DIJKSTRA;

import java.util.*;

public class 파티 {


    static class Node implements Comparable<Node> {

        int id, cost;

        Node(int id, int cost) {
            this.id = id;
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
        int m = sc.nextInt();
        int x = sc.nextInt() - 1; // 파티 마을 (0-indexed)

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();

            graph.get(from).add(new Node(to, cost));
            reverseGraph.get(to).add(new Node(from, cost));
        }

        int[] toX = dijkstra(x, reverseGraph, n);
        int[] fromX = dijkstra(x, graph, n);

        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, toX[i] + fromX[i]);
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(int start, List<List<Node>> graph, int V) {

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int currentNode = cur.id;
            int currentCost = cur.cost;

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (Node n : graph.get(currentNode)) {
                int nextNode = n.id;
                int newCost = currentCost + n.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }

        return dist;
    }
}
