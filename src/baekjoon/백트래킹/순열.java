package baekjoon.백트래킹;

import java.util.ArrayList;
import java.util.List;

//같은 원소라도 순서가 다르면 다른 경우로 본다.
public class 순열 {

    public static void generatePermutations(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                generatePermutations(nums, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 예제 입력
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(nums, new boolean[nums.length], new ArrayList<>(), result);

        // 결과 출력
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }


}
