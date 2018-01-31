/**
 * Created by hanzhou on 2018/1/31.
 */
// 在2方案的双指针的基础上,不是遍历i,而是单循环同时更新,j
// AC java 42%

public class Solution003_3 {
    public  int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        int i = 0;
        int j = 1;
        int len = 1;
        while (j<s.length()){
            String dString = s.substring(i,j);
            int pos = dString.indexOf(s.substring(j,j+1));
            if(pos!=-1){
                if(j -i > len) len = j - i;
                i = i + pos + 1;
            }
            j++;

        }
        if(j -i > len) len = j - i ;

        return len;
    }

    public static void main(String[] args) {
        System.out.println(""+"123".indexOf("1"));
        Solution003_3 solution = new Solution003_3();
        System.out.println("b res:" + solution.lengthOfLongestSubstring("b"));
        System.out.println("bbbb res:" + solution.lengthOfLongestSubstring("bbbb"));
        System.out.println("abcabcbb res:" + solution.lengthOfLongestSubstring("abcabcbb"));
    }

}

// AC 60ms