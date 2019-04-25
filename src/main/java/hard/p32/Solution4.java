package hard.p32;

/**
 * DP
 * <p>
 * dp[i]的含义是以charArray[i]结尾的合法括号串的长度
 * <p>
 * if s[i-1]='(' 且 s[i]=')' : dp[i] = dp[i-2]+2
 * if s[i-1]=')' 且 s[i]=')' 且 s[i-dp[i-1]]='(' 且 s[i-1-dp[i-1]]='(' : dp[i] = dp[i-1]+2
 */


public class Solution4 {
    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        char[] charArr = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (charArr[i] != ')') continue;
            if (charArr[i - 1] == '(') {
                if (i >= 2) dp[i] = dp[i - 2] + 2;
                else dp[i] = 2;
            } else if (i - 1 - dp[i - 1] >= 0 &&
                    charArr[i - dp[i - 1]] == '(' && charArr[i - 1 - dp[i - 1]] == '(') {
                if ((i - 2 - dp[i - 1]) > 0) dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
                else dp[i] = dp[i - 1] + 2;
            }
        }

        int maxLen = 0;
        for (int len : dp
        ) {
            if (len > maxLen) maxLen = len;

        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = ")()()()";
        System.out.println(s+": " + longestValidParentheses(s));
        s = "()(())";
        System.out.println(s+": " + longestValidParentheses(s));
        s = "(()())";
        System.out.println(s+": " + longestValidParentheses(s));
    }
}
