package baekjoon.자료구조;

import java.util.Scanner;

public class 커피숍2_세그먼트트리 {

    static class SegmentTree {
        long [] tree , arr;
        int n;

        SegmentTree (long [] a) {
            this.arr = a;
            n = a.length;
            tree = new long[n * 4];
            build(1, 0, n - 1);
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

        long query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return 0;
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            return query(node * 2, start, mid, l, r) + query(node * 2 + 1, mid + 1, end, l, r);
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
        int Q = sc.nextInt();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree st = new SegmentTree(arr);

        for (int i = 0; i < Q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            int temp = 0;
            if (x > y) {
                temp = x;
                x = y;
                y = temp;
            }

            long num = st.query(1, 0, N - 1, x - 1, y - 1);

            st.update(1, 0, N - 1, a - 1, b);

            System.out.println(num);
        }
    }
}
