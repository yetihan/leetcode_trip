package medium.p5;

/**
 * Created by hanzhou on 2018/1/31.
 * <p>
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * <p>
 * AC 42%
 * <p>
 * 字符串增加一位,最大回文长度 变化 只能是 0,1,2  (状态变化中的"不变量"),
 * 其中增加的那位字符不起作用的时候是0,可以不考虑,起作用的时候时候是1或者2 [begin:end] -> [begin:end+1] 或 [begin-1:end+1]
 * 使用反证法即可,假设>=3,首掉收尾的两个字符,矛盾
 * <p>
 * 基于这种结论只要遍历一遍s,(遍历指针是回文的终点),每次只要写两个if判断是否是回文
 * <p>
 * 这种方法不好理解不好记忆
 */


public class Solution1 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;
        char[] charArr = s.toCharArray();

        int begin = 0;int maxLen = 1;

        for (int end = 1; end < s.length() ; end++) {
            //maxLen 增加1的情况
            if (isPalindrome(charArr, end-maxLen,end)) {
                begin = end - maxLen;
                maxLen += 1;
                continue;
            }

            if(end - maxLen-1<0) continue;
            //maxLen增加2的情况
            if (isPalindrome(charArr, end-maxLen-1,end)) {
                begin = end - maxLen - 1;
                maxLen += 2;
            }

        }

        return s.substring(begin,begin+maxLen);

    }

    /**
     *
     * @param charArr
     * @param lo
     * @param hi 包含在内
     * @return
     */
    boolean isPalindrome(char[] charArr, int lo, int hi){
        while (lo<hi){
            if(charArr[lo]!=charArr[hi]) return false;
            lo++;hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
