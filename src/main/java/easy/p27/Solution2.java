package easy.p27;

/**
 * 双指针
 * copy solution
 *
 * nums[hi]!=val的时候就放到前面去
 * 相当于复制到另一个数组里面
 */

class Solution2 {
    public int removeElement(int[] nums, int val) {
        if (nums.length < 1) return 0;
        int lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            if (nums[hi] != val) {
                nums[lo] = nums[hi];
                lo++;
            }

            }

            return lo;
        }
    }