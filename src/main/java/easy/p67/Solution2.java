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
 * char相减
 *
 * 99% 41%
 */

public class Solution2 {
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() -1;
        int n = b.length() -1 ;
        int extra = 0; // 标记是否进位
        while (m>=0 || n>=0){
            int sum = extra;
            if(m>=0){
                sum += (a.charAt(m)-'0');
                m--;

            }

            if(n>=0){
                sum += (b.charAt(n)-'0');
                n--;
            }
            // 这一步 比我写的简单多了,^_^
            sb.append(sum%2);
            extra = sum/2;
        }

        if(extra==1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "111"));
    }
}
