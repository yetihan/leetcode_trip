/**
 * Created by hanzhou on 2018/1/25.
 */
// 1.Two Sum

//Given an array of integers, return indices of the two numbers
// such that they add up to a specific target.

//You may assume that each input would have exactly one solution,
// and you may not use the same element twice.

//    Given nums = [2, 7, 11, 15], target = 9,
//    Because nums[0] + nums[1] = 2 + 7 = 9,
//    return [0, 1].

// easy, two for loop


public class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[0];
    }

}
