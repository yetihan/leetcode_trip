package hard.p10.repeat;

/**
 * recursive 递归
 */

public class Solution_re {

    public boolean isMatch(String s, String p) {
        // p为空
        if (p.isEmpty()) return s.isEmpty();
        // 1. s为空 2. s,p同时不为空
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // a* 的 1. 表示 0个a  2.表示 >=1 个a
            return isMatch(s, p.substring(2))
                    || (firstMatch && isMatch(s.substring(1), p));
        }
        else return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
