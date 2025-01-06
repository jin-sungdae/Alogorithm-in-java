package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {

    static class Node implements Comparable<Node> {
        int id, cost;

        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost); // 비용 기준 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine()); // 시작 정점

        // 그래프 초기화
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());

        // 간선 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w)); // 방향 그래프
        }

        // 다익스트라 실행
        int[] distances = dijkstra(K, graph, V);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distances[i]).append("\n");
            }
        }
        System.out.print(sb);
    }

    public static int[] dijkstra(int start, List<List<Node>> graph, int V) {
        int[] dist = new int[V + 1]; // 최단 거리 배열
        Arrays.fill(dist, Integer.MAX_VALUE); // 초기값: 무한대
        dist[start] = 0; // 시작점의 거리는 0

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.id;
            int currentCost = current.cost;

            // 이미 처리된 노드면 스킵
            if (currentCost > dist[currentNode]) continue;

            // 인접 노드 탐색
            for (Node neighbor : graph.get(currentNode)) {
                int nextNode = neighbor.id;
                int newCost = currentCost + neighbor.cost;

                // 최단 거리 갱신
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }

        return dist;
    }
}
