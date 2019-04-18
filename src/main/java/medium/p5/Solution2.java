package medium.p5;

/**
 * Created by hanzhou on 2018/1/31.
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * AC 42%
 * <p>
 * <p>
 * 遍历一遍字符串,把指针当做是回文的中点,每一步分回文长度是 奇或偶 两种情况
 */


public class Solution2 {
    private int begin;
    private int maxLen;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        char[] charArr = s.toCharArray();
        for (int middle = 0; middle < s.length(); middle++) {
            findMaxPalindrome(charArr, middle, middle); //回文长度是奇数
            findMaxPalindrome(charArr, middle, middle + 1); //回文长度是偶数
        }

        return s.substring(begin, begin + maxLen);

    }

    /**
     * 从lo和hi开始向两边寻找最大的回文
     */
    void findMaxPalindrome(char[] charArr, int lo, int hi) {
        while (lo >= 0 && hi < charArr.length) {
            if (charArr[lo] == charArr[hi]) {
                lo--;
                hi++;
            } else break;
        }

        if (hi - lo - 1 > maxLen) {
            maxLen = hi - lo - 1;
            begin = lo + 1;
        }

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
