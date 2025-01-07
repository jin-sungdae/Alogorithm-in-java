package baekjoon.DIJKSTRA;

import java.util.*;

/**
 * 문제
 * 매일 아침, 세준이는 학교에 가기 위해서 차를 타고 D킬로미터 길이의 고속도로를 지난다. 이 고속도로는 심각하게 커브가 많아서 정말 운전하기도 힘들다. 어느 날, 세준이는 이 고속도로에 지름길이 존재한다는 것을 알게 되었다. 모든 지름길은 일방통행이고, 고속도로를 역주행할 수는 없다.
 *
 * 세준이가 운전해야 하는 거리의 최솟값을 출력하시오.
 *
 * 입력
 * 첫째 줄에 지름길의 개수 N과 고속도로의 길이 D가 주어진다. N은 12 이하인 양의 정수이고, D는 10,000보다 작거나 같은 자연수이다. 다음 N개의 줄에 지름길의 시작 위치, 도착 위치, 지름길의 길이가 주어진다. 모든 위치와 길이는 10,000보다 작거나 같은 음이 아닌 정수이다. 지름길의 시작 위치는 도착 위치보다 작다.
 *
 * 출력
 * 세준이가 운전해야하는 거리의 최솟값을 출력하시오.
 */
public class 지름길 {

    public static class Node implements Comparable<Node> {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        int [] distance = new int[m + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= m; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            if (from > m || to > m) {
                continue;
            }

            graph.get(from).add(new Node(to, cost));

        }

        for (int i = 0; i < m; i++) {
            graph.get(i).add(new Node(i + 1, 1));
        }

        dijkstra(0, graph, distance, m);

        System.out.println(distance[m]);

    }

    public static void dijkstra(int start, List<List<Node>> graph, int[] distance, int end) {


        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int currentNode = cur.id;
            int currentCost = cur.cost;

            if (currentCost > distance[currentNode]) {
                continue;
            }


            for (Node n : graph.get(currentNode)) {
                int nextNode = n.id;
                int newCost = currentCost + n.cost;

                if (newCost < distance[nextNode]) {
                    distance[nextNode] = newCost;
                    pq.add(new Node(nextNode, newCost));
                }
            }
        }

    }
}
