package medium.p3;

// 双指针发,s[i:j] :
// s[j]不在s[i:j],右边移动
// s[j]在s[i:j],i移动

public class Solution1 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()) return 0;
        int lo = 0;
        int hi = 1;
        int max = 1;
        while (hi < s.length()) {
            if (s.substring(lo, hi).contains(s.substring(hi, hi + 1))) {
                lo++;
            } else {
                hi++;
                if (hi - lo > max) max = hi - lo;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s;
        s = "abc";
        System.out.println(s + ": "+ lengthOfLongestSubstring(s));

        System.out.println("pwwkew: " + lengthOfLongestSubstring("pwwkew"));
        s = "pwwkewa";
        System.out.println(s + ": "+ lengthOfLongestSubstring(s));
    }
}
