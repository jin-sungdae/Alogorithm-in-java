package baekjoon.이분탐색;

import java.util.*;

public class K번째_수_플레 {
    static int N, M;
    static int[] A;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 배열 크기
        M = sc.nextInt(); // 쿼리 수

        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        // 정렬된 값 리스트 생성 (중복 허용 안함)
        int[] sorted = A.clone();
        Arrays.sort(sorted);

        // 정렬 세그먼트 트리 생성
        tree = new ArrayList[N * 4];
        build(1, 0, N - 1);

        // 쿼리 처리
        for (int m = 0; m < M; m++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int k = sc.nextInt();

            int left = 0, right = N - 1;
            int answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                int val = sorted[mid];
                int count = query(1, 0, N - 1, i, j, val);

                if (count >= k) {
                    answer = val;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            System.out.println(answer);
        }
    }

    // 세그먼트 트리 빌드
    static void build(int node, int l, int r) {
        tree[node] = new ArrayList<>();

        if (l == r) {
            tree[node].add(A[l]);
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // 두 리스트 정렬 병합
    static ArrayList<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) merged.add(left.get(i++));
            else merged.add(right.get(j++));
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }

    // 구간 [ql, qr]에서 x 이하 값 개수 반환
    static int query(int node, int l, int r, int ql, int qr, int x) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) {
            return upperBound(tree[node], x);
        }

        int mid = (l + r) / 2;
        return query(node * 2, l, mid, ql, qr, x) +
                query(node * 2 + 1, mid + 1, r, ql, qr, x);
    }

    // x 이하 원소의 개수 = upperBound
    static int upperBound(List<Integer> list, int x) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= x) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}