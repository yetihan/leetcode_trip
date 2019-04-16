package easy.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanzhou on 2018/1/25.
 */
// 1.Two Sum

//Given an array of integers, return indices of the two numbers
// such that they add up to a specific target.

//You may assume that each input would have exactly one solution,
// and you may not use the same element twice.

//    Given nums = [2, 7, 11, 15], target = 9,
//    Because nums[0] + nums[1] = 2 + 7 = 9,
//    return [0, 1].

//  two-pass hashTable


public class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = map.getOrDefault(target - nums[i], -1);
            if (idx != -1 && idx != i) return new int[]{i, idx};
        }
        throw new IllegalArgumentException("No two sum solition");
    }

    public static void main(String[] args) {
        int[] res;

//        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
//        System.out.println(twoSum(new int[]{-10,-1,-18,-19}, -19));
        res = twoSum(new int[]{3, 2, 4}, 6);
        res = twoSum(new int[]{3,3}, 6);


        System.out.println(new int[]{1, 2});

    }
}
