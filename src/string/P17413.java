package string;

import java.util.*;
import java.io.*;

public class P17413 {
	
	public static String solution(String str) {
		String [] strResult = str.split(" ");
		String result = "";
		for (int i = 0; i < strResult.length; i++) {
			result += new StringBuilder(strResult[i]).reverse().toString();
			result += " ";
		}
		return result;
	}
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		if (str.contains("<")) {
			str = str.substring(str.indexOf(">") + 1, str.lastIndexOf("<"));
		}
		System.out.println(solution(str));
	}
}
