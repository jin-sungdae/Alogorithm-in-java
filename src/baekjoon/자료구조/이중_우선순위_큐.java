package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 이중_우선순위_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            PriorityQueue<Long> rPq = new PriorityQueue<>(Comparator.reverseOrder());
            Map<Long, Integer> check = new HashMap<>();
            int len = 0;
            int opLen = 0;
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                long x = Long.parseLong(st.nextToken());

                if (op.equals("I")) {
                    pq.add(x);
                    rPq.add(x);
                    check.put(x,check.getOrDefault(x, 0) + 1);
                    len++;
                } else if (op.equals("D")) {
                    if (x == 1 && opLen != len) {
                        while (!rPq.isEmpty()) {
                            Long a = rPq.poll();
                            Integer isExist = check.getOrDefault(a, 0);
                            if (isExist != 0) {
                                int num = check.get(a) - 1;
                                if (num == 0) {
                                    check.remove(a);
                                } else {
                                    check.put(a, check.get(a) - 1);
                                }
                                opLen++;
                                break;
                            }
                        }



                    } else if (x == -1 && opLen != len) {
                        while (!pq.isEmpty()) {
                            Long a = pq.poll();
                            Integer isExist = check.getOrDefault(a, 0);
                            if (isExist != 0) {
                                int num = check.get(a) - 1;
                                if (num == 0) {
                                    check.remove(a);
                                } else {
                                    check.put(a, check.get(a) - 1);
                                }
                                opLen++;
                                break;
                            }
                        }


                    }
                }

            }

            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;

            boolean ch = false;
            for (Map.Entry<Long, Integer> entry : check.entrySet()) {
                Long key = entry.getKey();
                Integer value = entry.getValue();
                if (value > 0) {
                    ch = true;
                    max = Math.max(max, key);
                    min = Math.min(min, key);
                }
            }

            if (ch == false) {
                System.out.println("EMPTY");
            } else {
                System.out.println(max + " " + min);
            }


        }
    }
}
