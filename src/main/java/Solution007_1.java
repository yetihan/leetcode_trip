/**
 * Created by hanzhou on 2018/2/1.
 */
//Given a 32-bit signed integer, reverse digits of an integer.

//    runtime error
//    int 取值范围在+-2^31,正负21亿多

public class Solution007_1 {
    public int reverse(int x) {
        String s = String.valueOf(x);
        if(s.charAt(0)=='-')
            return Integer.parseInt("-"+new StringBuffer(s.substring(1)).reverse().toString());
        else
            return Integer.parseInt(new StringBuffer(s).reverse().toString());
    }


    public static void main(String[] args) {
        Solution007_1 solution = new Solution007_1();

        System.out.println(""+solution.reverse(1534236469));
    }

}
