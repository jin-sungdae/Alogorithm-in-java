package baekjoon.자료구조;

import java.util.Scanner;

public class 수열과_쿼리_16_세그먼트_트리 {

    static class SegmentTree {
        int[][] tree;
        int[] arr;
        int n;

        SegmentTree(int[] a) {
            arr = a;
            n = a.length;
            tree = new int[n * 4][2];
            build(1, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {
                tree[node][0] = arr[start];
                tree[node][1] = start;
            } else {
                int mid = (start + end) / 2;
                build(node * 2, start, mid);
                build(node * 2 + 1, mid + 1, end);
                tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
                tree[node][1] = tree[node * 2][0] == tree[node][0] ? tree[node * 2][1] : tree[node * 2 + 1][1];
            }
        }

        int[] query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) return new int[]{Integer.MAX_VALUE, 0};
            if (l <= start && end <= r) return tree[node];
            int mid = (start + end) / 2;
            int[] a = query(node * 2, start, mid, l, r);
            int[] b = query(node * 2 + 1, mid + 1, end, l, r);
            int temp = Math.min(a[0], b[0]);
            int[] temp2 = temp == a[0] ? new int[]{a[0], a[1]} : new int[]{b[0], b[1]};
            return temp2;
        }

        void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                tree[node][0] = val;
                tree[node][1] = idx;
            } else {
                int mid = (start + end) / 2;
                if (idx <= mid) {
                    update(node * 2, start, mid, idx, val);
                } else {
                    update(node * 2 + 1, mid + 1, end, idx, val);
                }
                tree[node][0] = Math.min(tree[node * 2][0], tree[node * 2 + 1][0]);
                tree[node][1] = tree[node * 2][0] == tree[node][0] ? tree[node * 2][1] : tree[node * 2 + 1][1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }

        SegmentTree st = new SegmentTree(arr);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (a == 1) {
                st.update(1, 0, n - 1, b - 1, c);
            } else {
                int[] num = st.query(1, 0, n - 1, b - 1, c - 1);
                System.out.println(num[1] + 1);
            }
        }
    }
}
