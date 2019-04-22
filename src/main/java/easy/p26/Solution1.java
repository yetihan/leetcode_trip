package easy.p26;

/**
 * 双指针
 */

public class Solution1 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[i]) nums[++i] = nums[j++];
            else j++;
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] list = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(list));

        list = new int[]{0, 1, 2};
        System.out.println(removeDuplicates(list));
    }
}
