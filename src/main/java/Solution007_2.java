/**
 * Created by hanzhou on 2018/2/1.
 */
public class Solution007_2 {
    public int reverse(int x) {
        int result = 0;

        while (x!=0){
            int tail = x%10;
            int newresult = result*10 + tail;
            if((newresult-tail)/10!=result)return 0;

            result = newresult;
            x = x/10;

        }
        return result;

    }

    public static void main(String[] args) {
        Solution007_2 solution = new Solution007_2();

        System.out.println(solution.reverse(1534236461));
    }
}
