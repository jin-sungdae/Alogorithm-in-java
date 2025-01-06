package programmers.algorithm;

import java.util.Arrays;

public class 단속카메라 {

    public static int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int lastCameraPosition = Integer.MIN_VALUE;
        for (int i = 0; i < routes.length; i++) {

            if (lastCameraPosition < routes[i][0]) {
                answer++;
                lastCameraPosition = routes[i][1];
            }
        }


        return answer;

    }

    public static void main(String[] args) {

        int[][] routes = {{1,2}, {2,3}};
    }

}
