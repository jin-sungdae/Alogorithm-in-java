package programmers.algorithm;

import java.util.Arrays;
import java.util.Collections;

public class 구명보트 {

    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int light = 0;
        int heavy = people.length - 1;

        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int [] people = new int[]{40, 40, 40, 40};
        int limit = 80;
        int test = solution(people, limit);

        System.out.println(test);
    }
}
