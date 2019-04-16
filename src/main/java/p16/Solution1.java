package p16;

import java.util.Arrays;
//先排序再双指针

public class Solution1 {
    public static int threeSumClosest(int[] nums, int target) {
//        先排序
        Arrays.sort(nums);
        int res = 0;
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                if (Math.abs(nums[lo] + nums[hi] - sum) < gap) {
                    gap = Math.abs(nums[lo] + nums[hi] - sum);
                    res = nums[i]+nums[lo] + nums[hi];
                }
                if (nums[lo] + nums[hi] > sum) hi--;
                else if (nums[lo] + nums[hi] < sum) lo++;
                else return target;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        ;
    }
}
