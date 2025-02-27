package baekjoon.세그먼트트리;

import java.util.Scanner;

public class 구간_합_구하기 {

    static class SegmentTree {
        private long[] tree;
        private int n;

        public SegmentTree(long[] arr) {
            this.n = arr.length;
            this.tree = new long[4 * n];
            buildTree(arr, 0, 0, n - 1);
        }

        private void buildTree(long[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                int leftChild = 2 * node + 1;
                int rightChild = 2 * node + 2;
                buildTree(arr, leftChild, start, mid);
                buildTree(arr, rightChild, mid + 1, end);
                tree[node] = tree[leftChild] + tree[rightChild];
            }
        }

        public long query(int node, int start, int end, int L, int R) {
            if (R < start || end < L) {
                return 0;
            }
            if (L <= start && end <= R) {
                return tree[node];
            }

            int mid = (start + end) / 2;
            long leftSum = query(2 * node + 1, start, mid , L, R);
            long rightSum = query(2 * node + 2, mid + 1, end , L, R);
            return leftSum + rightSum;
        }

        public void update(int node, int start, int end, int index, long value) {
            if (start == end) {
                tree[node] = value;
            } else {
                int mid = (start + end) / 2;
                if (index <= mid) {
                    update(2 * node + 1, start, mid, index, value);
                } else {
                    update(2 * node + 2, mid + 1, end, index, value);
                }
                tree[node] = tree[ 2 * node + 1] + tree[2 * node + 2];
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();
        }
        SegmentTree st = new SegmentTree(arr);

        for (int i = 0; i < M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if (a == 1) {
                st.update(0, 0, N - 1, b - 1, c);
            } else if (a == 2) {
                System.out.println(st.query(0, 0, N - 1, b - 1, (int) c - 1));
            }
        }
    }
}
