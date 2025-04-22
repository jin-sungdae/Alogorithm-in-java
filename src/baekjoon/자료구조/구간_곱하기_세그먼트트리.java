package baekjoon.자료구조;

public class 구간_곱하기_세그먼트트리 {

    static class SegmentTree {
        int[] tree, arr;
        int n;

        SegmentTree(int[] a) {
            this.n = a.length;
            this.arr = new int[n];
            this.tree = new int[n * 4];
            build(1, 0, n - 1);
        }

        void build(int node, int start, int end) {
            if (start == end) {

            } else {

            }
        }
    }

    public static void main(String[] args) {

    }
}
