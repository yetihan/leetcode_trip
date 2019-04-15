package p11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * medium
 *
 * divide-and-conquer 分治
 *
 * 和 最大子数组问题类似,分为三类
 * 1. 都在mid 左边
 * 2. 都在mid 右边
 * 3. 跨越mid
 *
 * Runtime: 397 ms, faster than 5.01% of Java online submissions for Container With Most Water.
 *
 */

public class Solution2 {
    public static int maxArea(int[] height) {
        int maxArea = 0;

        return maxArea;
    }

    public static int maxArea(int[] nums, int low, int high){
        if(low+1==high) return Math.max(nums[low], nums[high]);
        int mid = (low+high)/2;
        int maxAreaLeft = maxArea(nums, low, mid);
        int maxAreaRight = maxArea(nums, mid, high);

        return Math.max(maxAreaLeft, maxAreaRight);

    }
//我擦这好像是一个 n^2 复杂度,不写了 -_-
    public static int maxAreaCross(int[] nums, int low, int mid,int high){
        int maxArea = 0;
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
