package baekjoon.자료구조;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 수_찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, 1);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if (map.containsKey(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
