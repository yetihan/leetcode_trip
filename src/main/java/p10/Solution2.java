package p10;

/**
 * 看了python的解法翻译成了java
 *
 * 题目理解还是有问题,b*,可以是0个b
 *
 * 这个方法用的是 递归 Recursion
 */

public class Solution2 {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if(p.length()>=2 && p.charAt(1)=='*'){
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));  //两种情况
        }
        else return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    public static void main(String[] args) {
//        String[] res = "a*h*dd*h".split("\\*");
//        System.out.println("12345".substring(0,3));
//        System.out.println("res.length:" + res.length);
//        System.out.println(res[3]);

        System.out.println(isMatch("aaabb", "a*b"));
        System.out.println(isMatch("aaabb", "a*b*"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("a", "ab*"));
        System.out.println(isMatch("bbbba", ".*a*a"));
        System.out.println(isMatch("ab", ".*"));

        System.out.println(isMatch("ab", ".*"));
    }
}
