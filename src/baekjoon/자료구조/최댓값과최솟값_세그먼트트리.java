package baekjoon.자료구조;

import java.util.Scanner;

public class 최댓값과최솟값_세그먼트트리 {
     static class SegmentTree {
        int[] tree, maxTree, minTree , arr;
        int n;

        SegmentTree(int[] input) {
            this.arr = input;
            this.n = input.length;
            this.tree = new int[n * 4];
            this.maxTree = new int[n * 4];
            this.minTree = new int[n * 4];
            build(1, 0, n - 1);
            maxBuild(1, 0, n - 1);
            minBuild(1, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(node * 2, start, mid);
                build(node * 2 + 1, mid + 1, end);
                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }

         void maxBuild(int node, int start, int end) {
             if (start == end) {
                 maxTree[node] = arr[start];
             } else {
                 int mid = (start + end) / 2;
                 maxBuild(node * 2, start, mid);
                 maxBuild(node * 2 + 1, mid + 1, end);
                 maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
             }
         }

         void minBuild(int node, int start, int end) {
             if (start == end) {
                 minTree[node] = arr[start];
             } else {
                 int mid = (start + end) / 2;
                 minBuild(node * 2, start, mid);
                 minBuild(node * 2 + 1, mid + 1, end);
                 minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
             }
         }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return query(node * 2, start, mid, l, r) + query(node * 2 + 1, mid + 1, end, l, r);
        }

         int maxQuery(int node, int start, int end, int l, int r) {
             if (r < start || end < l) return Integer.MIN_VALUE;
             if (l <= start && end <= r) return maxTree[node];
             int mid = (start + end) / 2;
             int left = maxQuery(node * 2, start, mid, l, r);
             int right = maxQuery(node * 2 + 1, mid + 1, end, l, r);
             return Math.max(left, right);
         }

         int minQuery(int node, int start, int end, int l, int r) {
             if (r < start || end < l) return Integer.MAX_VALUE;
             if (l <= start && end <= r) return minTree[node];
             int mid = (start + end) / 2;
             int left = minQuery(node * 2, start, mid, l, r);
             int right = minQuery(node * 2 + 1, mid + 1, end, l, r);
             return Math.min(left, right);
         }
        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node] = val;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(node * 2, start, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, end, idx, val);
                }

                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree s = new SegmentTree(arr);



        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int max = s.maxQuery(1, 0, N - 1, x - 1, y - 1);
            int min = s.minQuery(1, 0, N - 1, x - 1, y - 1);
            System.out.println(min + " " + max);
        }
    }
}
