package programmers.algorithm;

public class 서버_증설_횟수 {
    static class Solution {
        public static int solution(int[] players, int m, int k) {
            int answer = 0;

            int [] serverNum = new int[players.length];


            int server = 0;
            int count = 0;;
            for (int i = 0; i < players.length; i++) {

                if (serverNum[i] > 0) {
                    server = server - serverNum[i];
                    serverNum[i] = 0;
                }

                if (players[i] / m > server) {
                    int beforeServer = server;

                    server = server + (players[i] / m - server);
                    int time = 0;
                    if (i + k > 23) {
                        time = 23;
                    } else {
                        serverNum[i + k] += players[i] / m - beforeServer;
                    }


                        count = count + (players[i] / m - beforeServer);






                }

            }

            System.out.println(server + " " + count);




            return answer;
        }
    }

    public static void main(String[] args) {
        int [] t = new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        System.out.println(Solution.solution(t, 3, 5));
    }
}
