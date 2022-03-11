package classification.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int Nun = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < Nun; j++){
                int M = Integer.parseInt(st.nextToken());
                queue.add(M);
                int z = 0;
                while (z != K){

                }
            }

        }
    }
}
