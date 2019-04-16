package medium.p11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * medium
 *
 * two for-loop
 *
 * Runtime: 397 ms, faster than 5.01% of Java online submissions for Container With Most Water.
 *
 */

public class Solution1 {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = +1; j < height.length; j++) {
                int area = (j-i)*(height[i] <= height[j] ? height[i] : height[j]);
                if(area > maxArea)  maxArea = area;
            }

        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
