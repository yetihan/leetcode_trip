package hard.p10;

/**
 * DP top-bottom 解法
 */


public class Solution3 {

    //不直接用boolean,是为了避免基本类型的自动初始化
    enum ResultEnum {
        TRUE, FALSE;
    }

    private ResultEnum[][] memo;
    //为了本地测试方便总是把目标函数写成static,dp的时候一直在纠结,memo怎么办,难道要写函数内的函数嘛 -_- 傻了

    // top-bottom
    public boolean isMatch(String s, String p) {
        memo = new ResultEnum[s.length() + 1][p.length() + 1]; //长度k的string s,要用到0-k合计k+1个索引
        return dp(0, 0, s, p);
    }


    private boolean dp(int i, int j, String s, String p) {
        if (memo[i][j] != null) return memo[i][j] == ResultEnum.TRUE;
        boolean ans;
        if (p.substring(j).isEmpty()) ans = s.substring(i).isEmpty();
        else {
            boolean firstMatch = !s.substring(i).isEmpty() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if (p.length() >= (j + 2) && p.charAt(j + 1) == '*') {
                ans = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
            } else {
                return firstMatch && dp(i + 1, j + 1, s, p);
            }

        }

        memo[i][j] = ans ? ResultEnum.TRUE : ResultEnum.FALSE;
        return ans;
    }

    public static void main(String[] args) {
        boolean[][] test1 = new boolean[5][5];
        System.out.println("test1[1]:" + test1[1][1]);

        ResultEnum[][] test2 = new ResultEnum[5][5];
        System.out.println("test2[1]:" + test2[1][1]);

        Solution3 solution = new Solution3();
        System.out.println(solution.isMatch("aaabb", "a*b"));
        System.out.println(solution.isMatch("aaabb", "a*b*"));
        System.out.println(solution.isMatch("aaa", "a*a"));
        System.out.println(solution.isMatch("a", "ab*"));
        System.out.println(solution.isMatch("bbbba", ".*a*a"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
    }
}
