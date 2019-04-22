package medium.p22;

/**
 * bfs
 *
 * Runtime: 9 ms, faster than 5.33% of Java online submissions for Generate Parentheses.
 */

import javafx.util.Pair;
import java.util.*;

public class Solution1 {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Queue<Pair<String,Pair<Integer, Integer>>> queue = new LinkedList<>();
        queue.add(new Pair<>("(",new Pair<>(1,0)));
        while (!queue.isEmpty()){
            Pair<String,Pair<Integer, Integer>> p = queue.poll();
            Integer open = p.getValue().getKey();
            Integer close = p.getValue().getValue();

            String s1 = p.getKey() + "(";
            String s2 = p.getKey() + ")";
            Pair<String,Pair<Integer, Integer>> p1 = new Pair<>(s1,new Pair<>(open+1,close));
            Pair<String,Pair<Integer, Integer>> p2 = new Pair<>(s2,new Pair<>(open,close+1));

            if(s1.length()==2*n){
                if(open+1==n) ans.add(s1);
                else ans.add(s2);
            }else {
                if(open+1<=n)queue.add(p1);
                if(open>=close+1)queue.add(p2);
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
