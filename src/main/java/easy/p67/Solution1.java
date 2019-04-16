package easy.p67;

/**
 * https://leetcode.com/problems/add-binary/
 *
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * 难度 easy
 * 2019年04月11日21:40:37
 *
 * 20% 56%
 */

public class Solution1 {
    public static String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int maxLen = Math.max(a.length(), b.length());
        int extra = 0; // 标记是否进位
        int a_bit, b_bit, tmp;
        for (int i = 0; i < maxLen; i++) {
            a_bit = i < a.length() ? Integer.parseInt(a.substring (a.length() -1 - i,a.length()-i)) : 0;
            b_bit = i < b.length() ? Integer.parseInt(b.substring (b.length() -1 - i,b.length()-i)) : 0;
            tmp = a_bit+b_bit+extra;
            extra = 0;
            if(tmp<=1) sum.append(tmp);
            else if(tmp==2){
                sum.append(0);
                extra=1;
            }else {
                sum.append(1);
                extra=1;
            }
        }
        if(extra==1) sum.append(1);
        return sum.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
