package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        Map<Long, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            long num = Long.parseLong(st.nextToken());

            int left = 0, right = arr.length, count = 0;

            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] == num) {
                    count = map.getOrDefault(num, 0);
                    break;
                }
                else if (arr[mid] > num) right = mid;
                else left = mid + 1;
            }

            sb.append(count).append(' ');
        }
        System.out.println(sb);
    }
}
