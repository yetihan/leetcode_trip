package medium.p33;

/**
 * 先找到 rotate的点
 * [3,4,5,6,1,2] 先找到 1,index是4,相当于所有的元素向右移动了4个位置, new_index = (origin_index + rot)%n
 * <p>
 * lo hi rot,  mid = ((lo+hi)/2+rot)%n
 */

public class Solution1 {
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        int rot = lo;
        System.out.println("rot:"+rot);

        lo = 0;hi=nums.length-1;

        while (lo<=hi){
            int mid = (lo+hi)/2;
            int realMid = (mid+rot)%(nums.length);
            if(nums[realMid]==target) return realMid;
            if(nums[realMid]>target) hi = mid-1;
            else lo = mid+1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
        nums = new int[]{1};
        target=1;
        System.out.println(search(nums, target));
    }
}
