package medium.p31;


/**
 * 存在nextPermutation的情况:(不是最大的permutation),整个数组不是降序的.
 * 从右往左遍历,总能能找到一个nums[idx] < nums[idx + 1],
 * 然后把nums[idx]和nums[idx:]中比nums[idx]的大的最小的数,互换.
 * 此时nums[idx+1:]还是满足降序的,把nums[idx+1:]做一个reverse即可
 * <p>
 * 不存在nextPermutation的情况:nums[:]是最大的Permutation,也就是满足降序
 */


public class Solution2 {
    public static void nextPermutation(int[] nums) {
        int idx = nums.length - 2;
        for (; idx >= 0; idx--) {
            if (nums[idx] < nums[idx + 1]) break;
        }

        if (idx == -1) reverseArray(nums, 0, nums.length - 1);
        else {
            for (int i = nums.length - 1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums, i, idx);
                    reverseArray(nums, idx + 1, nums.length - 1);
                    break;
                }
            }
        }

    }

    private static void reverseArray(int[] nums, int begin, int end) {
        int lo = begin, hi = end;
        for (; lo < hi; lo++, hi--) {
            swap(nums,lo,hi);
        }
    }

    private  static void swap(int[] nums, int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);

        }


    }

}
