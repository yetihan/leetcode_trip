package easy.p27;

/**
 * 双指针
 * my solution
 *
 * nums[lo]==val时从后面找一个不等的换上来
 */

class Solution1 {
    public int removeElement(int[] nums, int val) {
        if(nums.length<1) return nums.length;
        int lo=0;int hi = 0;
        while(lo<nums.length){
            if(nums[lo]==val){
                while(hi<nums.length&&nums[hi]==val) hi++;
                if(hi<nums.length) {
                    nums[lo]=nums[hi];
                    nums[hi]=val;
                    lo++;hi++;

                }
                else break;
            }
            else {
                lo++;
                hi++;
            }
        }

        return lo;
    }
}