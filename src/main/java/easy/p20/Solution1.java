package easy.p20;

import java.util.*;

public class Solution1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> leftBrackets = new ArrayList<Character>(Arrays.asList('(', '{', '['));
        List<Character> rightBrackets = new ArrayList<Character>(Arrays.asList(')', '}', ']'));
        for (int i = 0; i < s.length(); i++) {
            char token = s.charAt(i);
            if (leftBrackets.contains(token))
                stack.add(token);
            else  {
                int idx = rightBrackets.indexOf(token);
                if(idx!=-1){
                    if(stack.empty()||stack.pop()!=leftBrackets.get(idx)) return false;
                }
                else throw new IllegalArgumentException("wrong string");
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(s+" "+isValid(s));
        s = "()[][";
        System.out.println(s+" "+isValid(s));
        s = "(";
        System.out.println(s+" "+isValid(s));
        s = "([)]";
        System.out.println(s+" "+isValid(s));
    }
}
