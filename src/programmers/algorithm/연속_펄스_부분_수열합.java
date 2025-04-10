package programmers.algorithm;

public class 연속_펄스_부분_수열합 {
    public static long solution(int[] sequence) {
        long answer = 0;

        int [] s1 = new int[sequence.length];
        int [] s2 = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                s1[i] = sequence[i] * -1;
                s2[i] = sequence[i] * 1;
            } else if (i % 2 != 0){
                s1[i] = sequence[i] * 1;
                s2[i] = sequence[i] * -1;
            }

        }

        long maxSum1 = Integer.MIN_VALUE;
        long currentSum1 = 0;
        long maxSum2 = Integer.MIN_VALUE;
        long currentSum2 = 0;

        for (int i = 0; i < sequence.length; i++) {
            currentSum1 = Math.max(s1[i], currentSum1 + s1[i]);
            maxSum1 = Math.max(maxSum1, currentSum1);

            currentSum2 = Math.max(s2[i], currentSum2 + s2[i]);
            maxSum2 = Math.max(maxSum2, currentSum2);

        }




        return Math.max(maxSum1, maxSum2);
    }



    public static void main(String[] args) {
        int [] a = new int[]{2, 3, -6, 1, 3, -1, 2, 4};
        long re = solution(a);

        System.out.println(re);
    }
}
