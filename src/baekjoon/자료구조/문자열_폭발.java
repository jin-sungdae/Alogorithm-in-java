package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        int len = bomb.length();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            sb.append(c);

            // 마지막 문자가 폭탄 끝과 같고 길이가 충분할 때만 검사
            if (sb.length() >= len && sb.substring(sb.length() - len).equals(bomb)) {
                sb.delete(sb.length() - len, sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
