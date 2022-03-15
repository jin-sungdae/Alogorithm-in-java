package classification.stack;

import java.util.*;
import java.io.*;

public class P9012 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int check = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.add(str.charAt(j));
					check++;
				} else if (str.charAt(j) == ')' && check > 0) {
					stack.pop();
					check--;
				}
			}
			if (check == 0) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
	}
}
