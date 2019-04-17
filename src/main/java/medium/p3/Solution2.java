package medium.p3;

/**
 * 尝试改进Solution1,
 * str转成ArrayList再计算
 * 效率反而变低了
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int lo = 0;
        int hi = 1;
        int max = 1;
        List<String> str = new ArrayList<>(Arrays.asList(s.split("")));
        while (hi < s.length()) {
            int idx = str.subList(lo, hi).indexOf(str.get(hi));
            if (idx != -1) {
                lo = lo + idx + 1;
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
        System.out.println(s + ": " + lengthOfLongestSubstring(s));

        System.out.println("pwwkew: " + lengthOfLongestSubstring("pwwkew"));
        s = "pwwkewa";
        System.out.println(s + ": " + lengthOfLongestSubstring(s));
    }
}
