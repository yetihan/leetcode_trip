/**
 * Created by hanzhou on 2018/1/26.
 */


//  没什么思路,google一下,看了一眼别人的思路,
//  双指针法,s[i,j] 移动j为j+1,s[j]不在s[i,j]中移动成功,自己写了看看
//

public class Solution003_2 {

    public static  int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int maxLen = 1;
        String dString;
        Boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            if(maxLen>(s.length()-i)) break;
            for (int j = i + 1; j <= s.length(); j++) {
                dString = s.substring(i,j-1);
                flag = dString.contains(s.substring(j-1,j));
                if(flag) {
                    if((j-i)>maxLen) maxLen = j - i -1;
                    break;
                }
            }

            if(!flag) return s.length() - i;

        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println("" + lengthOfLongestSubstring("abcabcbb"));
    }
}

//还是超时了
