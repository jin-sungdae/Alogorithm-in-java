package baekjoon.DIJKSTRA;

import java.util.*;

public class 최소비용구하기 {

    static class Node implements Comparable<Node> {
        int id, cost;

        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    public static int dijkstra(int start, List<List<Node>> graph, int end, int n) {
       int [] dist = new int[n];
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int currentNode = cur.id;
            int currentCost = cur.cost;

            if (currentNode == end) {
                return currentCost;
            }

            if (currentCost > dist[currentNode]) {
                continue;
            }

            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.id;
                int newCost = currentCost + neighbor.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }


        return dist[end] == Integer.MAX_VALUE ? 0 : dist[end]; // 도달 불가능한 경우 0 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
        }


        int from  = sc.nextInt() - 1;
        int to = sc.nextInt() - 1;


        int result = dijkstra(from, graph, to, n);
        System.out.println(result);

    }
}
