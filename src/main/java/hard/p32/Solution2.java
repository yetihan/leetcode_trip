package hard.p32;

/**
 * DP top-bottom 二维数组
 * 解决父问题 并不需要解决 所有的子问题
 *
 */

import java.util.Stack;


public class Solution2 {

    enum ValidEnum {
        TRUE, FALSE
    }

    ValidEnum[][] memo;

    public int longestValidParentheses(String s) {
        memo = new ValidEnum[s.length()][s.length()];
        dp(s.toCharArray(), 0, s.length() - 1);
        int maxLen = 0;
        for (int lo = 0; lo < s.length(); lo++) {
            for (int hi = lo; hi < s.length(); hi++) {
                if (memo[lo][hi] == ValidEnum.TRUE && hi - lo + 1 > maxLen) maxLen = hi - lo + 1;
            }
        }


        return maxLen;
    }


    public boolean dp(char[] charArr, int lo, int hi) {
        if (memo[lo][hi] != null) return memo[lo][hi] == ValidEnum.TRUE;
        ValidEnum ans;

        if (charArr[lo] == '(' && charArr[hi] == ')' && (hi - lo) % 2 == 1) {
            if (hi - lo == 1) {
                ans = ValidEnum.TRUE;
            } else {
                ans = dp(charArr, lo+1,hi-1) ? ValidEnum.TRUE: ValidEnum.FALSE;
            }
        } else ans = ValidEnum.FALSE;
        memo[lo][hi] = ans;
        return ans == ValidEnum.TRUE;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.longestValidParentheses("((())("));
    }
}
