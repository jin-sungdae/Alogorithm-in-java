package baekjoon.백트래킹;

import java.util.*;


public class 조합 {

    public static void generateCombinations(int[] nums, int start, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            generateCombinations(nums, i + 1, k, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; // 예제 입력
        int k = 2; // 2개를 선택하는 조합
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(nums, 0, k, new ArrayList<>(), result);

        // 결과 출력
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}
