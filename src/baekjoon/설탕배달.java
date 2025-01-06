package baekjoon;

import java.util.Scanner;

public class 설탕배달 {


    // 봉지를 적게 가져가야되고 딱 맞춰서 N 킬로그램을 배달해야한다

    // 5 kg 을 남겨 먹을 변수
    // 3 kg 을 남겨 먹을 변수
    public static void Main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int temp = sc.nextInt();
        int three = 0;
        int five = 0;


        five = temp / 5;   // 이거랑 별개여야 하는데...?
        temp = temp % 5; // 5 kg 로 남은 나머지는 3kg 으로 나누어야 한다

        three = temp / 3;
        temp = temp % 3;

        if (temp != 0) {
            System.out.println(-1);
        } else {
            System.out.println(three + five);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;

        while (true) {
            // N 이 5로 나누어 떨어지면 바로 계산
            if (N % 5 == 0) {
                count += N / 5;
                System.out.println(count);
                break;
            }

            N -= 3;
            count++;

            if (N < 0) {
                System.out.println(-1);
                break;
            }
        }


    }
}
