package p11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * medium
 * <p>
 * 双指针 tow-pointer
 * 一个从最左边开始,一个从最右边开始,都逐渐往中间移动,
 * 面积取决于宽度和高度,移动过程中,宽度总是在减小,故我们总是选择移动目前比较矮的那个;
 * 因为,目前的面积取决于矮边的高度,那么固定矮边,长边所有的其他情况与现在相比,
 * 高度一定只会<=目前的高度,长度<目前的长度,所以面积只会减小. 证毕!!!
 * <p>
 * Runtime: 397 ms, faster than 5.01% of Java online submissions for Container With Most Water.
 */

public class Solution3 {
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = (height.length - 1) * Math.min(height[left], height[right]);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else right--;

            int area = (right - left) * Math.min(height[left], height[right]);
            if (area > maxArea) maxArea = area;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
