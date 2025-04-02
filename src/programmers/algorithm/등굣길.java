package programmers.algorithm;

public class 등굣길 {

    class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static int solution(int m, int n, int[][] puddles) {


        int [][] map = new int[n][m];

        for (int[] p : puddles) {
            map[p[1] - 1][p[0] - 1] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (map[i][0] == -1) break;
            map[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            if (map[0][j] == -1) break;
            map[0][j] = 1;
        }




        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] != -1) {
                    int a = map[i - 1][j];
                    int b = map[i][j - 1];

                    if (map[i - 1][j] == -1) {
                        a = 0;
                    }
                    if (map[i][j - 1] == -1) {
                        b = 0;
                    }
                    map[i][j] = (a + b) % 1000000007;
                }

            }
        }





        return map[n - 1][m - 1];
    }

    public static void main(String[] args) {

        int[][] ar = new int[][]{{}};

        int a = solution(4, 3, ar);
        System.out.println(a);
    }
}
