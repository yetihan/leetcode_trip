package medium.p15_3sum;

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
                if(nums[i+1]+nums[i+2]>sum) break;//最小值已经超出目标,当前i以及更右边的i都没有满足条件的解了
                if(nums[hi]+nums[hi-1]<sum) continue; //最大值还还是小鱼目标,i右移

                while (lo<hi){
                    if(nums[lo]+nums[hi]==sum){
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        lo++;hi--;
                        while (nums[lo]==nums[lo-1]&&lo<hi) lo++; //skip same result
                        while (nums[hi]==nums[hi+1]&&lo<hi) hi--; //skip same result,两个skip 可以只保留一个
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
