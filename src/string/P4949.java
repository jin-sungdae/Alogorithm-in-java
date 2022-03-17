package string;

import java.util.*;
import java.io.*;
public class P4949 {
	
	public static String solution(String str) {
		String result = "";
		Stack<Character> stack = new Stack<>();
		
		
		
		for (char x : str.toCharArray()) {
			if (x == '(' || x == '[') {
				stack.push(x);
			} else if (x == ')') {
			
				if (stack.isEmpty() || stack.peek() != '(') {
					result = "no";
					break;
				} else
					stack.pop();
			} else if (x ==']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					result = "no";
					break;
				}else 
					stack.pop();
				
			}
		}
		if(stack.empty()) {
			result = "yes";
		}
		else {
			result = "no";
		}
		return result;
	}
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		String s;

		while (true) {
			s = br.readLine();
			
			if(s.equals(".")) {	 
				break;
			}
			sb.append(solution(s)).append('\n');
		}
		System.out.println(sb);
	}
}
