/**
 * Created by hanzhou on 2018/1/25.
 */


import java.util.HashSet;

//Given a string, find the length of the longest substring without repeating characters.
//
//Example
//Given "abcabcbb", the answer is "abc", which the length
//Given "bbbbb", the answer is "b", with the length
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



//运算时间超时


public class Solution003_1 {

     private Boolean notRepeat(String s){
        char[] c=s.toCharArray();
        HashSet<Character>  set = new HashSet<Character>();
        for(char cc:c){
            boolean flag1 = set.add(cc);
            if(!flag1) return false;

        }
//        System.out.println(s);

        return true;
    }


    public int lengthOfLongestSubstring(String s) {
        for (int i = s.length(); i > 0; i--) {
//            System.out.println("i:"+i);
            int k = i;
            for (int j = 0; j <= (s.length() - i); j++) {
                if (notRepeat(s.substring(j, k))) {
                    return i;
                }
                k++;
                }
            }
        return 0;
        }




    public static void main(String[] args) {

//        System.out.println("lengthOfLongestSubstring:"+lengthOfLongestSubstring("abcabcbb"));

    }
}


