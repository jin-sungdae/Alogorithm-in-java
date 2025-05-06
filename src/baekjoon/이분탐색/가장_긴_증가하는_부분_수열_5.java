package baekjoon.이분탐색;

import java.util.*;

public class 가장_긴_증가하는_부분_수열_5 {

    static int[] A, pos, prev;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N];
        pos = new int[N];
        prev = new int[N];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        List<Integer> lis = new ArrayList<>();
        List<Integer> idxList = new ArrayList<>();

        Arrays.fill(prev, -1);

        for (int i = 0; i < N; i++) {
            int val = A[i];
            int idx = lowerBound(lis, val);
            if (idx == lis.size()) {
                lis.add(val);
                idxList.add(i);
            } else {
                lis.set(idx, val);
                idxList.set(idx, i);
            }
            pos[i] = idx;
            if (idx > 0) prev[i] = idxList.get(idx - 1);
        }


        System.out.println(lis.size());

        List<Integer> answer = new ArrayList<>();
        int lastIdx = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (pos[i] == lis.size() - 1) {
                lastIdx = i;
                break;
            }
        }

        while (lastIdx != -1) {
            answer.add(A[lastIdx]);
            lastIdx = prev[lastIdx];
        }

        Collections.reverse(answer);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}