package medium.p34;

import java.util.Arrays;

public class Solution1 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        boolean found = false;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            }
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        int first = -1;
        int last = -1;
        if (found) {
            lo = mid;
            hi = mid;
            while (lo - 1 >= 0 && nums[lo - 1] == target) lo--;
            while (hi+1 < nums.length && nums[hi + 1] == target) hi++;
            first = lo;
            last = hi;
        }
        return new int[]{first,last};


    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] res = searchRange(nums, target);
//        System.out.println("res: "+res[0]+", "+res[1]);
        assert (Arrays.equals(res, new int[]{3, 4})) : "错误答案";

        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        res = searchRange(nums, target);
        assert (Arrays.equals(res, new int[]{-1, -1})) : "错误答案";

        nums = new int[]{1};
        target = 1;
        res = searchRange(nums, target);
        assert (Arrays.equals(res, new int[]{0, 0})) : "错误答案";

        nums = new int[]{0};
        target = 1;
        res = searchRange(nums, target);
        assert (Arrays.equals(res, new int[]{-1, -1})) : "错误答案";


        System.out.println("DONE");
    }
}
