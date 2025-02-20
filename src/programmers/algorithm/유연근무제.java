package programmers.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 유연근무제 {

    class  Solution {
        public static int solution(int[] schedules, int[][] timelogs, int startday) {
            int answer = 0;


            int dayCount = 0;

            List<List<Integer>> arr = new ArrayList<>();

            for (int i = 0; i < timelogs.length; i++) {
                arr.add(new ArrayList<>());
            }
            for (int i = 0; i < timelogs.length; i++) {
                dayCount = startday;
                for (int j = 0; j < timelogs[i].length; j++) {

                    if (!(Math.abs(dayCount - 7) == 0 || Math.abs(dayCount - 6) == 0)) {
                        arr.get(i).add(timelogs[i][j]);

                    }
                    if (dayCount == 7) dayCount = 0;
                    dayCount++;

                }
            }


            for (int i = 0; i < arr.size(); i++) {

                int checkTime = schedules[i];
                int checkTimeHour = checkTime / 100;
                int checkTimeMinute = checkTime % 100;

                checkTimeMinute = checkTimeMinute + 10;

                if (checkTimeMinute >= 60) {
                    checkTimeHour = checkTimeHour + 1;
                    checkTimeMinute = checkTimeMinute - 60;
                }

                int checkDay = 0;

                for (Integer timeLog : arr.get(i)) {
                    int time = timeLog;
                    int hour = time / 100;
                    int minute = time % 100;

                    if (hour >= 11 && minute > 10) {
                        break;
                    }

                    if (hour == checkTimeHour && minute <= checkTimeMinute) {
                        checkDay++;
                    } else if (hour < checkTimeHour) {
                        checkDay++;
                    }
                }



                if (checkDay == 5) {
                    answer++;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

        int[] schedules = new int[]{700, 800, 1100};
        int[][] timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};


        int answer = Solution.solution(schedules, timelogs, 5);

        System.out.println(answer);


    }
}
