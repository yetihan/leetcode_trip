package medium.p17;

/**
 * 9可能要单独处理
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    static Map<Byte, String> map = new HashMap<>();
    static {
        map.put((byte) 2, "abc");
        map.put((byte) 3, "def");
        map.put((byte) 4, "ghi");
        map.put((byte) 5, "jkl");
        map.put((byte) 6, "mno");
        map.put((byte) 7, "pqrs");
        map.put((byte) 8, "tuv");
        map.put((byte) 9, "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        int digitsLen = digits.length();
        List<String> res = new ArrayList<>();
        if(digitsLen==0) return res;

        byte digit = Byte.valueOf(digits.substring(0,1));
        for (int i = 0; i < map.get(digit).length(); i++) {
            res.add(map.get(digit).substring(i,i+1));
        }
        for (int i = 1; i < digitsLen; i++) {
            List<String> tmp = new ArrayList<>();
            digit = Byte.valueOf(digits.substring(i,i+1));
            for (String s: res) {
                for (int j = 0; j < (digit==9||digit==7?4:3); j++) {
                    tmp.add(s + map.get(digit).substring(j,j+1));
                }
            }
            res = tmp;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println(s + ": "+letterCombinations(s));
        System.out.println("1244: "+letterCombinations("244"));
        s="";
        System.out.println(s + ": "+letterCombinations(s));
        s="5678";
        System.out.println(s + ": "+letterCombinations(s));
    }
}

