package medium.p17;

/**
 * bfs
 */

import java.util.*;

public class Solution2 {
    private static String[] mapping = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};


    public static List<String> letterCombinations(String digits) {
        int digitsLen = digits.length();
        List<String> res = new ArrayList<>();
        if(digitsLen==0) return res;

        char digit = digits.charAt(0);
        for (int i = 0; i < mapping[digit-'0'].length(); i++) {
            res.add(mapping[digit-'0'].substring(i,i+1));
        }
        for (int i = 1; i < digitsLen; i++) {
            List<String> tmp = new ArrayList<>();
            digit = digits.charAt(i);
            for (String s: res) {
                for (int j = 0; j < (digit=='9'||digit=='7'?4:3); j++) {
                    tmp.add(s + mapping[digit-'0'].substring(j,j+1));
                }
            }
            res = tmp;
        }

        return res;
    }
}

