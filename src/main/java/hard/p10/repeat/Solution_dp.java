package hard.p10.repeat;

/**
 * dp top-bottom
 *
 * memo[i][j] 代表 s[i:]与p[j:]的结果
 */

public class Solution_dp {

    enum MATCH{
        TRUE,FALSE;
    }

    MATCH[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new MATCH[s.length()+1][p.length()+1];
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j){
        if(memo[i][j]!=null) return memo[i][j]==MATCH.TRUE;
        boolean ans;
        if(j>=p.length())  ans = i>=s.length();
        else {
            boolean firstMatch = (i<s.length()) && (p.charAt(j) == s.charAt(i) || p.charAt(j)=='.');
            if(j+1<p.length() && p.charAt(j+1)=='*'){
                ans = dp(s, p, i, j+2) || (firstMatch && dp(s,p,i+1,j));
            }
            else ans = firstMatch && dp(s,p,i+1, j+1);
            memo[i][j] = ans? MATCH.TRUE:MATCH.FALSE;
        }

        return ans;
    }


}
