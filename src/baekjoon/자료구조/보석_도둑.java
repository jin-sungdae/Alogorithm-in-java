package baekjoon.자료구조;

import java.util.*;

public class 보석_도둑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();


        List<long[]> list = new ArrayList<>();
        long[] C = new long[K];

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list.add(new long[]{a, b});
        }

        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();

            C[i] = a;
        }

        Arrays.sort(C);
        list.sort(Comparator.comparingLong(a -> a[0]));
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;

        int j = 0;

        for (int i = 0; i < K; i++) {

            long bag = C[i];

            while (j < N && bag >= list.get(j)[0]) {
                pq.offer(list.get(j)[1]);
                j++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }

        }

        System.out.println(answer);



    }
}
