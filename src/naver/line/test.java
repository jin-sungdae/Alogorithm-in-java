package naver.line;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        int[] test = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt();
        }

        List<Integer> test1 = new ArrayList<>(test.length);
        for (int i = 0; i < test.length; i++) {
            test1.add(test[i]);
        }

        int max = Integer.MIN_VALUE;
        Long stime = System.nanoTime();
        for (int i = 0; i < test.length; i++) {
            if (max < test[i]) {
                max = test[i];
            }
        }
        Long etime = System.nanoTime();
        System.out.println("For loop max: " + max);
        System.out.println("For loop time: " + (etime - stime) / 10000000.0 + " ms");

        long startReduce = System.nanoTime();
        OptionalInt max1 = Arrays.stream(test).reduce(Integer::max);
        long endReduce = System.nanoTime();

        System.out.println("Reduce max: " + max1.orElse(Integer.MIN_VALUE));
        System.out.println("Reduce time: " + (endReduce - startReduce) / 10000000.0 + " ms");


        Integer sum = test1.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        Stream.iterate(0, n-> n + 2)
                .forEach(System.out::println);
    }
}
