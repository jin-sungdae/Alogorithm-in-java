package baekjoon.이분탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 가장_긴_증가하는_부분_수열_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int x : arr) {
            int idx = findMid(lis, x);

            if (idx == lis.size()) {
                lis.add(x);
            } else {
                lis.set(idx, x);
            }
        }

        System.out.println(lis.size());
    }

    static int findMid(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size();

        while (left < right) {
            int mid = (left + right) / 2;
            if (lis.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
