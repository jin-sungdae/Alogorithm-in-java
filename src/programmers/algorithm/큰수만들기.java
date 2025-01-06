package programmers.algorithm;

public class 큰수만들기 {

    public static String solution(String number, int k) {
        StringBuilder stack = new StringBuilder(); // 결과를 저장할 스택 역할
        int n = number.length(); // 숫자의 길이

        for (int i = 0; i < n; i++) {
            char digit = number.charAt(i); // 현재 숫자

            // 스택의 마지막 숫자가 현재 숫자보다 작고, 제거할 수 있다면 제거
            while (stack.length() > 0 && stack.charAt(stack.length() - 1) < digit && k > 0) {
                stack.deleteCharAt(stack.length() - 1); // 스택에서 제거
                k--; // 제거할 숫자 감소
            }

            stack.append(digit); // 현재 숫자를 스택에 추가
        }

        // 남은 제거 수 만큼 뒤에서 자르기
        stack.setLength(stack.length() - k);

        return stack.toString(); // 최종 결과 반환
    }

    public static void main(String[] args) {
        String test = solution("4177252841", 4);
        System.out.println(test);
    }
}
