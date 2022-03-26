package inflearnjava.dfsbfs;

import java.util.*;

public class P1 {
	static int [] arr;
	static int [] ch;
	public static void DFS() {
		
	}
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		ch = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	}
}
