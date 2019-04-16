package medium.p560;

// https://leetcode.com/problems/subarray-sum-equals-k/
// 难度 Medium


public class Solution {
    public static int subarraySum(int[] nums, int k) {
        int targetSubarrayNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int subarraySum = 0;
            for (int j = i; j < nums.length; j++) {
                subarraySum += nums[j];
                if(subarraySum==k) {
                    targetSubarrayNum++;
                }

            }

        }

        return targetSubarrayNum;
    }

    public static void main(String[] args) {
        int[] nums = {28,54,7,-70,22,65,-6};
        int k = 100;
        System.out.println(subarraySum(nums, k));
    }

}
