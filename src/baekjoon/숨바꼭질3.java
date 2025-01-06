package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * 문제
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
 *
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 *
 * 출력
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */
public class 숨바꼭질3 {


    static class Node implements Comparable<Node>{
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
        int m = sc.nextInt();



        int result = dijkstra(n,m);
        System.out.println(result);

    }

    public static int dijkstra(int n, int m) {
        int MAX = 100000;
        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int currentPosition = cur.position;
            int currentCost = cur.cost;

            if (currentPosition == m) {
                return currentCost;
            }

            if (currentCost > dist[currentPosition]) {
                continue;
            }

            // X - 1
            if (currentPosition - 1 >= 0) {
                int newCost = currentCost + 1;
                if (newCost < dist[currentPosition - 1]) {
                    dist[currentPosition - 1] = newCost;
                    pq.add(new Node(currentPosition - 1, newCost));
                }
            }


            // X + 1
            if (currentPosition + 1 <= MAX) {
                int newCost = currentCost + 1;
                if (newCost < dist[currentPosition + 1]) {
                    dist[currentPosition + 1] = newCost;
                    pq.add(new Node(currentPosition + 1, newCost));
                }
            }


            // X * 2
            if (currentPosition * 2 <= MAX) {
                int newCost = currentCost;
                if (newCost < dist[currentPosition * 2]) {
                    dist[currentPosition * 2] = newCost;
                    pq.add(new Node(currentPosition * 2, newCost));
                }
            }
        }

        return -1;
    }
}
