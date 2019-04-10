import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by hanzhou on 2018/7/16.
 */

//Input: words = ["time", "me", "bell"]
//        Output: 10
//        Explanation: S = "time#bell#" and indexes = [0, 2, 5]
// 某个单词是另个单词的"后缀"

public class Solution820_1 {
//

    public int minimumLengthEncoding(String[] words) {
        HashSet<String> word_set = new HashSet<String>();
        word_set.addAll(Arrays.asList(words));

        for (String word:words) {
            for (int i = 1; i < word.length(); i++) {
                word_set.remove(word.substring(i));
            }
        }

        int len = 0;
        for (String word:word_set) {
            len += (word.length()+1);
        }


        return len;
    }

//
    public static void main(String[] args) {
        String a = "abcde";
        String b = "cde";
        HashSet<String> word_set = new HashSet<>();
        word_set.add(a);
        word_set.add(b);
        System.out.println(word_set.remove(a.substring(2)));
        for (Object w:word_set) {
            System.out.println(w);

        }

    }

}
