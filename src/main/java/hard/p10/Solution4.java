package hard.p10;

/**
 * DP bottom-top 解法
 * dp[i][j] 记录的是isMatch(s[i:],p[j:])
 */


public class Solution4 {
    // top-bottom
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean[][]dp = new boolean[s.length() + 1][p.length() + 1]; //长度k的string s,要用到0-k合计k+1个索引
        dp[s.length()][p.length()]=true;

//        为了保证所有的子问题都被解决用,两个for循环,一个while 没法写
        for (int i = s.length(); i >=0 ; i--) { //如果是i取不到s.length() 那么,dp[s.length][x]这个子问题就没法被覆盖
            for (int j = p.length()-1; j >=0; j--) {
                boolean firstMatch = i!=s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if(j+1<p.length()&&p.charAt(j+1)=='*'){
                    dp[i][j] = (dp[i][j+2]) || (firstMatch&&dp[i+1][j]);
                }
                else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        boolean[][] test1 = new boolean[5][5];
        System.out.println("test1[1]:" + test1[1][1]);

        Solution4 solution = new Solution4();
        System.out.println(solution.isMatch("aa", "a*"));

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
