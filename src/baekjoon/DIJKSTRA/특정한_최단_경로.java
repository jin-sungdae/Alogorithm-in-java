package baekjoon.DIJKSTRA;

import java.util.*;

/**
 * 문제
 * 방향성이 없는 그래프가 주어진다. 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다. 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
 *
 * 세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라. 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다. (2 ≤ N ≤ 800, 0 ≤ E ≤ 200,000) 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c가 주어지는데, a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c라는 뜻이다. (1 ≤ c ≤ 1,000) 다음 줄에는 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2가 주어진다. (v1 ≠ v2, v1 ≠ N, v2 ≠ 1) 임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재한다.
 *
 * 출력
 * 첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
 */
public class 특정한_최단_경로 {

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
        int e = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int cost = sc.nextInt();
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        int v1 = sc.nextInt() - 1;
        int v2 = sc.nextInt() - 1;

        int shortPath = dijkstraWithMandatoryPoint(0, n - 1, v1, v2, graph, n);
        System.out.println(shortPath);
    }

    public static int dijkstraWithMandatoryPoint(
            int start, int end, int mandatory1, int mandatory2, List<List<Node>> graph, int v
    ) {
        int[] distFromStart = dijkstra(start, graph, v);
        int toMandatory = distFromStart[mandatory1];

        int[] distFromMandatory1 = dijkstra(mandatory1, graph, v);
        int toMandatory2 = distFromMandatory1[mandatory2];
        int toEndFromMandatory2 = dijkstra(mandatory2, graph, v)[end];

        int[] distFromStartAlt = dijkstra(start, graph, v);
        int toMandatory2Alt = distFromStartAlt[mandatory2];

        int[] distFromMandatory2Alt = dijkstra(mandatory2, graph, v);
        int toMandatory1Alt = distFromMandatory2Alt[mandatory1];
        int toEndFromMandatory1Alt = dijkstra(mandatory1, graph, v)[end];

        if (toMandatory >= Integer.MAX_VALUE || toMandatory2 >= Integer.MAX_VALUE || toEndFromMandatory2 >= Integer.MAX_VALUE) {
            return -1;
        }
        if (toMandatory2Alt >= Integer.MAX_VALUE || toMandatory1Alt >= Integer.MAX_VALUE || toEndFromMandatory1Alt >= Integer.MAX_VALUE) {
            return -1;
        }

        int path1 = toMandatory + toMandatory2 + toEndFromMandatory2;
        int path2 = toMandatory2Alt + toMandatory1Alt + toEndFromMandatory1Alt;

        return Math.min(path1, path2);
    }

    public static int[] dijkstra(int start, List<List<Node>> graph, int v) {
        int[] dist = new int[v];
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
                int nextCost = currentCost + n.cost;

                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.add(new Node(nextNode, nextCost));
                }
            }
        }

        return dist;
    }
}
