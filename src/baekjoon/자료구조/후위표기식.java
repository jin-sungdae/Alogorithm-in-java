package baekjoon.자료구조;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 후위표기식 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder calcStr = new StringBuilder();

        Deque<Character> deque = new ArrayDeque<>();
        Boolean check = false;

//        1.	피연산자(피연산자 = A, B, C, …)
//        그대로 출력 (즉, 결과 리스트에 append)
//        2.	연산자(+ - * /)
//        스택에 push 하기 전에,
//        스택 top에 있는 연산자의 우선순위와 비교하여,
//        top 연산자의 우선순위가 현재보다 높거나 같다면 pop해서 결과에 append
//        그 후 현재 연산자를 스택에 push
//        3.	괄호가 있다면 추가 처리:
//	•	( → 무조건 push
//	•	) → ( 나올 때까지 pop해서 결과에 append
//        4.	for문 종료 후 stack 비우기
//        스택에 남은 연산자를 모두 결과에 append

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {
                deque.push(str.charAt(i));

            } else if (str.charAt(i) == ')') {
                while (deque.peek() != '(') {
                    answer.append(deque.poll());
                }

                if (deque.peek() == '(') {
                    deque.pop();
                }
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/') {
                Character calc = deque.peek();
                while (calc != null && ((calc == '*' || calc == '/') || ((calc == '+' || calc == '-') && (str.charAt(i) == '+' || str.charAt(i) == '-')))) {
                    answer.append(deque.poll());
                    calc = deque.peek();
                }

                deque.push(str.charAt(i));


            } else {
                answer.append(str.charAt(i));
            }
        }

        while (!deque.isEmpty()) {
            answer.append(deque.pop());
        }
        System.out.println(answer);
    }
}
