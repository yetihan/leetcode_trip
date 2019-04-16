package p15;

import java.lang.reflect.Array;
import java.util.*;

public class Solution1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length-2; i++) {
            if((i>0 && nums[i]!=nums[i-1]) || i==0){
                int sum = 0 - nums[i];
                int lo = i+1;
                int hi = nums.length-1;
                while (lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        lo++;hi--;
                        while (nums[lo]==nums[lo-1]&&lo<hi) lo++;
                        while (nums[hi]==nums[hi+1]&&lo<hi) hi--;
                    }else if(nums[lo]+nums[hi]<sum) lo++;
                    else hi--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-2,0,0,2,2}));
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}
