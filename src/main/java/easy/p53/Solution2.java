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
 * 分治
 *
 */
public class Solution2 {
    public static  int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length);
    }


    private static int maxSubArray(int[] nums, int begin, int end){
        if(begin==end-1) return nums[begin];
        int mid = (begin+end)/2;

        int maxLeft = maxSubArray(nums, begin,mid);
        int maxRight = maxSubArray(nums, mid,end);
        int maxCrossMid = maxSubArrayCrossMid(nums, begin, mid, end);
        return Math.max(Math.max(maxLeft, maxRight),maxCrossMid);
    }


    private static int maxSubArrayCrossMid(int[] nums, int begin, int mid, int end){
        int sum = nums[mid-1];
        int maxLeft=sum;
        for (int i = mid-2; i >= begin ; i--) {
            sum+=nums[i];
            if(sum>maxLeft) maxLeft=sum;
        }

        sum = nums[mid];
        int maxRight = sum;
        for (int i = mid+1; i < end ; i++) {
            sum+=nums[i];
            if(sum>maxRight) maxRight=sum;
        }
        return maxLeft+maxRight;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,-1}));
        System.out.println(maxSubArray(new int[] {1,2,3}));
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
