package medium.p22;

import java.util.LinkedList;
import java.util.List;

/**
 * backtracking
 * 类似于dfs
 */

public class Solution2 {
    public  List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>(); //引用类型 用于保存结果
        backTracking("(", 1, 0, ans, n);
        return ans;
    }

    private void backTracking(String s, int open, int close, List<String> ans, int max){
        if(s.length()==max*2){
            ans.add(s);
        }else {
            if(open<max) backTracking(s+"(", open+1, close, ans, max);
            if(close<max&&close<open) backTracking(s+")", open, close+1, ans, max);
        }

    }




    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.generateParenthesis(3));
    }
}
