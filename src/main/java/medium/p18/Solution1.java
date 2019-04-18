package medium.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 循环i,对nums[i+1:]做3sum
 */
public class Solution1 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums); //先排序
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]) continue; //重复忽略
            threeSumForFourSum(nums, i+1, target -nums[i], ans);

        }
        return ans;
    }


    public static void  threeSumForFourSum(int[] nums, int from, int target, List<List<Integer>> ans){
        List<List<Integer>> res = new ArrayList<>();
        for (int i = from; i < nums.length-2; i++) {
            if(i>from&&nums[i]==nums[i-1]) continue; //重复忽略
            int lo=i+1; int hi = nums.length-1;
            if(nums[i]+nums[i+1]+nums[i+2]>target)  break; //最小值也超出了
            if(nums[i]+nums[hi]+nums[hi-1]<target)  continue; //最大值还不够


            while (lo<hi){
                if(nums[i]+nums[lo]+nums[hi]==target){
                    ans.add(Arrays.asList(nums[from-1],nums[i], nums[lo], nums[hi]));
                    lo++;hi--;
                    while(nums[lo] == nums[lo-1]&&lo<hi)lo++;
                    while(nums[hi] == nums[hi+1]&&lo<hi)hi--;
                }
                else if(nums[i]+nums[lo]+nums[hi]<target) lo++;
                else hi--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-3,-1, 0, 2,4,5};
        int target = 1;
        System.out.println(fourSum(nums, target));

        int[] nums1 = {0,0,0,0};
        target = 0;
        System.out.println(fourSum(nums1, target));

    }
}
