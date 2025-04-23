package baekjoon.자료구조;

import java.util.Scanner;

public class 최솟값_세그먼트트리 {

    static class SegmentTree {
        int[] tree, arr;
        int n;

        SegmentTree(int[] a) {
            this.n = a.length;
            this.arr = a;
            this.tree = new int[n * 4];
            build(1, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                build(node * 2, start, mid);
                build(node * 2 + 1, mid + 1, end);
                tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
            }
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return Integer.MAX_VALUE;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return Math.min(query(node * 2, start, mid, l, r), query(node * 2 + 1, mid + 1, end, l, r));
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

                tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
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

        SegmentTree st = new SegmentTree(arr);

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int num = st.query(1, 0, N - 1, a - 1, b - 1);
            System.out.println(num);
        }
    }
}
