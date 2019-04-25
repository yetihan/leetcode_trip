package hard.p32;

/**
 * 仿照 最大回文的思路
 *
 * 每增加一个字符,最长的合法括号串长度要么不变,要么增加2 -- 结论是错的
 * ------
 * 错的
 */

import java.util.Stack;

public class Solution1 {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        char[] charArr = s.toCharArray();
        for (int end = 1; end < s.length(); end++) {
            if(end-maxLen-1>=0 && isValid(charArr, end-maxLen-1, end)){
                maxLen += 2;
            }
        }

        return maxLen;
    }

    public static boolean isValid(char[] charArr, int lo, int hi) {
        Stack<Character> stack = new Stack<>();

        for (int i = lo; i <= hi; i++) {
            if (charArr[i] == '(') stack.push('(');
            else {
                if (stack.empty()) return false;
                else stack.pop();
            }

        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(longestValidParentheses(")()()()"));
        System.out.println(longestValidParentheses("()(())"));

    }
}
