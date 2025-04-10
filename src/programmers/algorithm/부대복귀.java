package programmers.algorithm;

import baekjoon.BFS.촌수계산;

import java.util.*;

public class 부대복귀 {

    public static class Node {
        int x, distance;

        Node (int x, int distance) {
            this.x = x;
            this.distance = distance;
        }
    }


    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        List<List<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] x : roads) {
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        int start = n;

        if (n == destination) {
            start = 1;
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        bfs(start, destination, map, dis);



        for (int i = 0; i < sources.length; i++) {
            answer[i] = dis[sources[i]];
        }


        return answer;
    }

    public static int bfs(int start, int end, List<List<Integer>> arr, int[] dis) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(end, 0));
        dis[end] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();


            for (int next : arr.get(current.x)) {
                if (dis[next] == -1) {
                    q.offer(new Node(next, current.distance + 1));
                    dis[next] = dis[current.x] + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int n = 5;
        int[][] road = new int[][]{{1, 2},{1,4}, {2, 4}, {2,5}, {4,5}};

        int[] sources = new int[]{1,3,5};
        int des = 5;

        int [] res = solution(n, road, sources, des);
        for (int x : res) {
            System.out.println(x);
        }

    }
}
