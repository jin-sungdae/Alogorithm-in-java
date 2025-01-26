package baekjoon.백트래킹;

import java.util.*;

public class 암호_만들기 {

    public static List<String> resList = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int C = sc.nextInt();

        String [] alpaList = new String[C];

        for (int i = 0; i < C; i++) {
            String a = sc.next();
            alpaList[i] = a.charAt(0) + "";
        }

        Arrays.sort(alpaList);

        boolean [] visited = new boolean[C];
        combination(alpaList, visited, 0, L);

        Collections.sort(resList);
        for (String x : resList) {
            System.out.println(x);
        }
    }

    public static void combination(String [] alpaList, boolean[] visited, int start, int r) {
        if (r == 0) {
            print(alpaList, visited);
            return;
        }

        for (int i = start; i < alpaList.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(alpaList, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    public static void print(String[] alpaList, boolean[] visited) {

        String res = "";
        for (int i = 0; i < alpaList.length; i++) {
            if (visited[i]) {
                res += alpaList[i];
            }
        }

        int vowelCount = 0; // 모음 개수
        int consonantCount = 0; // 자음 개수
        boolean isCh = false;
        for (int i = 0; i < res.length(); i++) {

            char c = res.charAt(i);

            // 모음 체크
            if (isVowel(c)) {
                vowelCount++;
            }
            // 자음 체크
            else if (isConsonant(c)) {
                consonantCount++;
            }

            if (vowelCount >= 1 && consonantCount >= 2) {

                isCh = true;
            }
        }

        if (isCh) {
            resList.add(res);
        }
    }


    // 모음인지 확인
    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0; // 모음이면 true
    }

    // 자음인지 확인
    public static boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c); // 알파벳이면서 모음이 아니면 자음
    }
}
