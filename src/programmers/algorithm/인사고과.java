package programmers.algorithm;

import java.util.*;

public class 인사고과 {

    static class Employee {
        int a, b, sum;
        boolean isWonho;

        public Employee(int a, int b, boolean isWonho) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
            this.isWonho = isWonho;
        }
    }

    public static int solution(int[][] scores) {
        List<Employee> arr = new LinkedList<>();

        for (int i = 0; i < scores.length; i++) {
            int a = scores[i][0];
            int b = scores[i][1];
            boolean isWonho = (i == 0);
            arr.add(new Employee(a, b, isWonho));
        }


        arr.sort((e1, e2) -> {
            if (e1.a != e2.a) return e2.a - e1.a;
            return e1.b - e2.b;
        });


        int maxB = -1;
        Iterator<Employee> it = arr.iterator();
        while (it.hasNext()) {
            Employee cur = it.next();
            if (cur.b < maxB) {
                if (cur.isWonho) return -1;
                it.remove();
            } else {
                maxB = Math.max(maxB, cur.b);
            }
        }

        arr.sort((e1, e2) -> e2.sum - e1.sum);


        int answer = 1;
        int rank = 1;
        int prevSum = -1;

        for (int i = 0; i < arr.size(); i++) {
            Employee e = arr.get(i);

            if (e.sum != prevSum) {
                rank = i + 1; // 공동 등수 반영
                prevSum = e.sum;
            }

            if (e.isWonho) {
                answer = rank;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int [][] a = new int[][]{{2,2},{1,4},{3,2},{3,2},{2,1}};
        int answer = solution(a);
        System.out.println(answer);
    }
}
