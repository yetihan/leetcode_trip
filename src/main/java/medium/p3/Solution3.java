package medium.p3;



/**
 *  双指针法改进:
 *  左边指针移动的时候直接跳到目标位置,而不是一个一个走
 *
 */

public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()) return 0;
        int lo = 0;
        int hi = 1;
        int max = 1;
        while (hi < s.length()) {
            int idx = s.substring(lo,hi).indexOf(s.substring(hi, hi + 1));
            if (idx!=-1) {
                lo = lo + idx + 1;
            } else {
                hi++;
                if (hi - lo > max) max = hi - lo;
            }

//            if((s.length()-lo)<max) break;
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
