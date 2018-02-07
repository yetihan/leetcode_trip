/**
 * Created by hanzhou on 2018/2/1.
 */

//Palindrome Number
// Determine whether an integer is a palindrome. Do this without extra space.

//123321 变成 123 和 1*100+2*10+3=123
//12321  变成 123 和 1*10+2*1=12

public class Solution009_1 {
    public boolean isPalindrome(int x) {
        if (x<0|| (x % 10 == 0 && x != 0)) return false;

        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }


    public static void main(String[] args) {
        Solution009_1 solution = new Solution009_1();

        System.out.println(solution.isPalindrome(10));
    }
}
