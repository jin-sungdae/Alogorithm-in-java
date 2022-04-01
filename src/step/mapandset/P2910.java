package step.mapandset;

import java.util.*;

public class P2910 {
	
	public static void solution(Map<Integer, Integer> map) {
		StringBuilder sb = new StringBuilder();
		
		for (Integer x : map.keySet()){
			int tmp = map.get(x);
			while (tmp-- > 0)
				sb.append(x + " ");
		}
		System.out.println(sb);
	}
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num <= C) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}
		solution(map);
	}
}
