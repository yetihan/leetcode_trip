package p560;

// https://leetcode.com/problems/subarray-sum-equals-k/
// 难度 Medium
// 数组和 + hashmap, 抄的

import java.util.HashMap;

public class Solution1 {
    public static int subarraySum(int[] nums, int k) {
        int sum = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

}
