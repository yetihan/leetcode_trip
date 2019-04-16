package hard.p10;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * 难度 Hard
 *
 * NOT accept
 *
 * 2019年04月13日08:50:50
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 */

public class Solution1 {

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (!p.contains("*")) return matchWithOutStar(s, p);
        else {
            String[] pArr = p.split("\\*");
            int cur = 0;
            for (int i=0; i < pArr.length; i++) {
                String subPattern = pArr[i];

                int subStrEndIndex = cur+subPattern.length();
                if(subStrEndIndex>=s.length()) return false;
                if(!matchWithOutStar(s.substring(cur,subStrEndIndex),subPattern)) return false;
                cur += subPattern.length();

                char charStared = s.charAt(cur-1);
                if(i==pArr.length-1 && p.charAt(p.length() - 1) != '*') break;

                boolean charStaredMoreThenOne = false;
                while (s.charAt(cur)==charStared) {
                    cur++;
                    charStaredMoreThenOne = true;
                    if(cur==s.length()) break;
                }
                if(i+1<pArr.length&&charStaredMoreThenOne&&pArr[i+1].charAt(0)==charStared) cur--; // a*a这种要留一个a给后面的subPatter

            }

            if(cur==s.length()) return true;
            else {
                if (p.charAt(p.length() - 1) != '*') return false;
                else {
                    for (int i=cur; i<s.length(); i++){
                        if(s.charAt(i)!=s.charAt(cur-1)) return false;
                    }
                    return true;
                }

            }
        }
    }


    private static boolean matchWithOutStar(String s, String p) {
        if (s.length() != p.length()) return false;
        else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '.') return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {
//        String[] res = "a*h*dd*h".split("\\*");
//        System.out.println("12345".substring(0,3));
//        System.out.println("res.length:" + res.length);
//        System.out.println(res[3]);

//        System.out.println(isMatch("aaabb", "a*b"));
//        System.out.println(isMatch("aaabb", "a*b*"));
//        System.out.println(isMatch("aaa", "a*a"));
//        System.out.println(isMatch("a", "ab*"));
//        System.out.println(isMatch("bbbba", ".*a*a"));
        System.out.println(isMatch("ab", ".*"));
    }
}
