package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 수들의합_7_세그먼트트리 {

    static class SegmentTree {
        long[] tree, arr;
        int n;

        SegmentTree(long[] a) {
            this.arr = a;
            this.n = a.length;
            this.tree = new long[n * 4];

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
            return query(node * 2, start, mid , l, r) + query(node * 2 + 1, mid + 1, end, l, r);

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


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        SegmentTree stree = new SegmentTree(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (b > c) {
                    int tmp = b;
                    b = c;
                    c = tmp;
                }
                System.out.println(stree.query(1, 0, n - 1, b - 1, c - 1));
            } else {
                stree.update(1, 0, n - 1, b - 1, c);
            }
        }
    }
}


