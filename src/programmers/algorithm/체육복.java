package programmers.algorithm;

import java.util.Arrays;

public class 체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            lost[i] = lost[i] - 1;
            arr[lost[i]] = 0;
        }

        for (int i = 0; i < reserve.length; i++) {
            reserve[i] = reserve[i] - 1;
            arr[reserve[i]] = arr[reserve[i]] + 1;
        }



        for (int i = 0; i < lost.length; i++) {

            if (arr[lost[i]] == 1) {
                arr[lost[i]] = 1;
            } else if (lost[i] - 1 >= 0 && arr[lost[i] - 1] > 1) {
                arr[lost[i] - 1] = 1;
                arr[lost[i]] = 1;
            } else if (lost[i] + 1 < n && arr[lost[i] + 1] > 1) {
                arr[lost[i]] = 1;
                arr[lost[i] + 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] lost = new int[]{1,2,3,4,5};
        int[] reserve = new int[]{6};
        int answer = solution(30, lost, reserve);

        System.out.println(answer);
    }
}
