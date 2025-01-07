package baekjoon.DIJKSTRA;

import java.util.*;

public class 특정_거리의_도시_찾기 {

    public static class Node implements Comparable<Node> {
        int id, cost;

        Node (int id, int cost) {
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

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        List<List<Node>> arr = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            arr.get(a).add(new Node(b, 1));
        }

        int [] result = dijkstra(arr, X - 1, N);

        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == K) {
                answer++;
                System.out.println(i + 1);
            }
        }

        if (answer == 0)
            System.out.println(-1);
    }

    public static int[] dijkstra(List<List<Node>> map, int start, int v) {

        int [] dist = new int[v];
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

            for (Node neighbor : map.get(currentNode)) {
                int nextNode = neighbor.id;
                int newCost = currentCost + neighbor.cost;

                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }

        return dist;

    }
}
