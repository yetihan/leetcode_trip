package mess;

/**
 * Created by hanzhou on 2018/1/31.
 */
//Given a string s, find the longest palindromic substring in s.
// You may assume that the maximum length of s is 1000.

//    AC 42%

// 字符串增加一位,最大回文长度 变化 只能是 0,1,2 基于这种假设只要遍历,s,每次只要写两个if即可
//    使用反证法即可,假设>=3,去掉收尾的两个字符,矛盾

public class Solution005_1 {
    public String longestPalindrome(String s) {
        if(s.length()<=1) return s;

        int begin = 0;
        int maxLen = 1;
        String s1,s2;

        for (int i = 1; i < s.length() ; i++) {
            s1 = s.substring(i - maxLen, i + 1);

            if (new StringBuffer(s1).reverse().toString().equals(s1)) {
                begin = i - maxLen;
                maxLen += 1;
                continue;
            }

            if(i - maxLen-1<0) continue;

            s2 = s.substring(i - maxLen-1, i + 1);


            if (new StringBuffer(s2).reverse().toString().equals(s2)) {
                begin = i - maxLen - 1;
                maxLen += 2;
            }

        }

        return s.substring(begin,begin+maxLen);

    }

    public static void main(String[] args) {
        Solution005_1 solution = new Solution005_1();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}
