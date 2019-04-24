package medium.p31;


/**
 * 存在nextPermutation的情况:(不是最大的permutation),整个数组不是降序的.
 * 从右往左遍历,总能能找到一个nums[idx] < nums[idx + 1],
 * 然后把nums[idx]和nums[idx:]中比nums[idx]的大的最小的数,互换.
 * 此时nums[idx+1:]还是满足降序的,把nums[idx+1:]做一个reverse即可
 *
 * 不存在nextPermutation的情况:nums[:]是最大的Permutation,也就是满足降序
 *
 */


public class Solution1 {
    public static void nextPermutation(int[] nums) {
        boolean noNext = true;
        int idx = nums.length - 2;
        while (idx >= 0) {
            if (nums[idx] < nums[idx + 1]) {
                noNext = false;
                break;
            }
            idx--;
        }

        if (noNext) {
            reverseArray(nums, 0, nums.length - 1);
        } else {
            int replaceIdx = idx + 1;
            while (replaceIdx + 1 < nums.length && nums[replaceIdx + 1] > nums[idx]) replaceIdx++;
            int temp = nums[idx];
            nums[idx] = nums[replaceIdx];
            nums[replaceIdx] = temp;
            reverseArray(nums, idx + 1, nums.length - 1);
        }

    }

    public static void reverseArray(int[] nums, int begin, int end) {
        for (int lo = begin, hi = end; lo < hi; lo++, hi--) {
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int i : nums) {
            System.out.println(i);

        }



    }

}
