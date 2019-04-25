package hard.p32;

/**
 * DP bottom-top 二维数组
 * 错误 两个for循环遍历的时候,子问题未解决就先用子问题的解了.
 */


public class Solution3 {


    public static int longestValidParentheses(String s) {
        char[] charArr = s.toCharArray();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int lo = 0; lo < s.length(); lo++) {
            for (int hi = lo; hi < s.length(); hi++) {
                if ((hi - lo) % 2 == 0) dp[lo][hi] = false;
                else {
                    if (charArr[lo] == '(' && charArr[hi] == ')') {
                        if ((hi - lo == 1)) dp[lo][hi] = true;
                        else dp[lo][hi] = dp[lo + 1][hi - 1];
                    }
                }
            }

        }
        int maxLen = 0;
        for (int lo = 0; lo < s.length(); lo++) {
            for (int hi = lo; hi < s.length(); hi++) {
                if (dp[lo][hi] && hi - lo + 1 > maxLen) maxLen = hi - lo + 1;
            }
        }


        return maxLen;
    }


    public static void main(String[] args) {

        System.out.println(longestValidParentheses("((())("));
    }
}
