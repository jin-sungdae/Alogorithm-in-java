package inflearnjava.stackandqueue;

import java.util.Scanner;
import java.util.Stack;

public class P3 {
    static int n, nList;
    static int [][] board;
    static int [] list;
    public static void solution(){
        Stack<Integer> stack = new Stack<>();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        nList = sc.nextInt();
        list = new int[nList];
        for (int i = 0; i < nList; i++){
            list[i] = sc.nextInt();
        }

    }
}
