/**
 * Created by hanzhou on 2018/1/31.
 */
//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).
//    归并排序
//    AC 25%

public class Solution004_1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] mergedNums = new int[nums1.length + nums2.length];
        for (int k = 0; k < mergedNums.length; k++) {
            if(i==nums1.length){
                for (;k < mergedNums.length; k++) {
                    mergedNums[k] = nums2[j];
                    j++;
                }
                break;
            }

            if(j==nums2.length){
                for (;k < mergedNums.length; k++) {
                    mergedNums[k] = nums1[i];
                    i++;
                }
                break;
            }


            if(nums1[i]<nums2[j]){
                mergedNums[k] = nums1[i];
                i++;
            }
            else {
                mergedNums[k] = nums2[j];
                j++;
            }
        }

        if(mergedNums.length%2==1)return mergedNums[(mergedNums.length-1)/2];
        else return (mergedNums[mergedNums.length/2] + mergedNums[mergedNums.length/2 -1])/2.0;

    }

    public static void main(String[] args) {
        Solution004_1 solution = new Solution004_1();
        Double median = solution.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println("median:"+median);
    }
}
