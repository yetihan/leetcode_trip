package hard.p352;

import java.util.TreeMap;


/**
 * 这个方法超时,可能是对int[] 操作毕竟耗时
 */
public class SummaryRanges1 {

    private TreeMap<Integer, int[]> tree;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges1() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if (tree.containsKey(val)) return;
        Integer lo = tree.lowerKey(val);
        Integer hi = tree.higherKey(val);

        // 情况1: [1,3] [5,6]  4   -> [1,6]
        if (lo != null && hi != null && tree.get(lo)[1] + 1 == val && tree.get(hi)[0] == val + 1) {
            tree.get(lo)[1] = tree.get(hi)[1];
            tree.remove(hi);
        }
        // [1,3]  4    -> [1,4]
        else if (lo != null && tree.get(lo)[1] + 1 == val) {
            tree.get(lo)[1] = val;
        }
        // [5,6]  4    -> [4,6]
        else if (hi != null && tree.get(hi)[0] == val + 1) {
            tree.put(val, new int[]{val, tree.get(hi)[1]});
            tree.remove(hi);
        }
        // 两边都不沾
        else {
            tree.put(val, new int[]{val, val});
        }


    }

    public int[][] getIntervals() {
        int[][] arr = new int[tree.size()][];
        return tree.values().toArray(arr);
    }


    public static void main(String[] args) {
        SummaryRanges1 summaryRanges = new SummaryRanges1();
        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(2);
        summaryRanges.addNum(7);
        summaryRanges.addNum(9);
        for (int[] nums : summaryRanges.getIntervals()) {
            System.out.println("" + nums[0] + ", " + nums[1]);
        }

    }
}
