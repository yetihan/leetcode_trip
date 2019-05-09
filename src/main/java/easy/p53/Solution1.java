package easy.p53;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * easy
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 神奇的O(n)的解法,分类的时候按照,A[:i]的最大子数组扩展到A[:i+1]是,的最大子数组要么不变 要么一定是一个以A[i]结尾的子数组
 * 所以我们总记住两个值 最大子数组的和以 endHere的最大子数组
 *
 */
public class Solution1 {
    public static  int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxEndHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndHere = Math.max(maxEndHere+nums[i], nums[i]);
            max = Math.max(max, maxEndHere);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
