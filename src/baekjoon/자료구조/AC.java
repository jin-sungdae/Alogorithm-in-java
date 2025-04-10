package baekjoon.자료구조;

import java.util.*;

public class AC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String cmd = sc.nextLine();
            int k = sc.nextInt();
            sc.nextLine();
            String numLine = sc.nextLine();

            Deque<Integer> arr = new ArrayDeque<>();

            numLine = numLine.replaceAll("\\]", "").replaceAll("\\[", "");


            if (!numLine.isEmpty()) {
                for (String s : numLine.split(",")) {
                    arr.add(Integer.parseInt(s));
                }
            }

            boolean ch = false;
                boolean errorCh = false;
                for (Character x : cmd.toCharArray()) {

                    if (x == 'R') {
                       ch = !ch;

                    } else if (x.equals('D') ) {
                        if (arr.size() == 0) {
                            errorCh = true;
                            break;
                        }
                        if (ch == false) {
                            arr.pollFirst();
                        } else if (ch == true) {
                            arr.pollLast();
                        }
                    }
                }

            if (errorCh) {
                System.out.println("error");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                Iterator<Integer> it = ch ? arr.descendingIterator() : arr.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    if (it.hasNext()) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }



            }

    }
}
