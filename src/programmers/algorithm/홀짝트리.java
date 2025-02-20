package programmers.algorithm;

import java.util.*;

public class 홀짝트리 {
    class Solution {
        public static int[] solution(int[] nodes, int[][] edges) {
            int n = nodes.length;

            Map<Integer, Integer> nodeToIndex = new HashMap<>();

            for (int i = 0; i < n; i++) {
                nodeToIndex.put(nodes[i], i);
            }

            List<Integer>[] graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                int u = nodeToIndex.get(edge[0]);
                int v = nodeToIndex.get(edge[1]);
                graph[u].add(v);
                graph[v].add(u);
            }

            int[] degree = new int[n];
            for (int i = 0; i < n; i++) {
                degree[i] = graph[i].size();
            }

            boolean[] visited = new boolean[n];
            int countHolijjakTree = 0;
            int countReverseTree = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    List<Integer> component = new ArrayList<>();
                    Deque<Integer> stack = new LinkedList<>();
                    stack.push(i);
                    visited[i] = true;

                    while (!stack.isEmpty()) {
                        int cur = stack.pop();
                        component.add(cur);
                        for (int next : graph[cur]) {
                            if (!visited[next]) {
                                visited[next] = true;
                                stack.push(next);
                            }
                        }
                    }

                    int cnt0 = 0, cnt1 = 0;
                    for (int idx : component) {
                        int f = degree[idx] & 1;  // degree의 패리티 (짝수: 0, 홀수: 1)
                        int p = nodes[idx] & 1;   // 노드 번호의 패리티 (짝수: 0, 홀수: 1)
                        int a = f ^ p;
                        if (a == 0) { // f 와 p가 같으면
                            cnt0++;
                        } else {
                            cnt1++;
                        }

                    }


                    int compSize = component.size();
                    if (cnt0 == 1 && cnt1 == compSize - 1) {
                        countHolijjakTree++;
                    }

                    if (cnt1 == 1 && cnt0 == compSize - 1) {
                        countReverseTree++;
                    }
                }
            }


            return new int[]{countHolijjakTree, countReverseTree};
        }




    }

    public static void main(String[] args) {
        int[]nodes0 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 23};
        int[][] edge0 = {{2, 4}, {4, 6}, {6, 8}, {8, 10}, {10, 12}, {12, 14}, {14, 16}, {16, 18}, {18, 20}, {20, 22}, {22, 23}};

        int[] nodes = new int[400000];
        for (int i = 1; i <= 400000; i++) nodes[i - 1] = i;

        int[][] edges = new int[200000][2];
        for (int i = 0; i < 200000; i++) {
            edges[i] = new int[]{2 * i + 1, 2 * i + 2}; // 균형 이진 트리
        }

        int[] nodes1 = new int[5000]; // 1부터 9999까지의 홀수만 포함
        for (int i = 0; i < 5000; i++) {
            nodes1[i] = 2 * i + 2; // 1, 3, 5, ..., 9999
        }

        int[][] edges1 = new int[4999][2];
        for (int i = 0; i < 4999; i++) {
            edges1[i] = new int[]{nodes1[i], nodes1[i + 1]}; // (1,3), (3,5), (5,7), ..., (9997,9999)
        }


        int[] nodes2 = new int[50000];
        for (int i = 1; i <= 50000; i++) nodes2[i - 1] = i;

        int[][] edges2 = new int[15000][2];
        for (int i = 0; i < 5000; i++) {
            edges2[i] = new int[]{i * 2 + 1, i * 2 + 2}; // 첫 번째 트리
        }
        for (int i = 5000; i < 10000; i++) {
            edges2[i] = new int[]{20000 + (i - 5000) * 2, 20000 + (i - 5000) * 2 + 1}; // 두 번째 트리
        }
        for (int i = 10000; i < 15000; i++) {
            edges2[i] = new int[]{40000 + (i - 10000) * 3, 40000 + (i - 10000) * 3 + 1}; // 세 번째 트리
        }

        int[] nodes3 = {2, 4, 6, 8, 10, 3, 7, 11, 15};

        int[][] edges3 = new int[][]{
                {2, 4}, {4, 6}, {6, 8}, {8, 10},
                {3, 7}, {7, 11}, {11, 15}
        };

        int[] nodes4 = {1, 2, 3, 4};

        int[][] edges4 = new int[][]{
                {1, 2}, {2, 3}, {3, 4}
        };





        int [] res = Solution.solution(nodes, edges);
        System.out.println(Arrays.toString(res));
    }
}
