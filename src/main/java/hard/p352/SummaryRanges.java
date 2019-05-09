package hard.p352;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SummaryRanges {

    int max = 0;
    int min = Integer.MAX_VALUE;
    Set<Integer> nums;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        nums = new HashSet<>();
    }

    public void addNum(int val) {
        nums.add(val);
        if (val > max) max = val;
        if (val < min) min = val;
    }

    public int[][] getIntervals() {
        ArrayList<int[]> list = new ArrayList<>();
        boolean open = true;
        int start = min;
        for (int cur = min; cur <= max; cur++) {
            if (!nums.contains(cur + 1)) {
                if (open) {
                    list.add(new int[]{start, cur});
                    open = false;
                }
            } else {
                if (!open) {
                    start = cur+1;
                    open = true;
                }
            }
        }

        int[][] arr = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        summaryRanges.addNum(3);
        summaryRanges.addNum(2);
        summaryRanges.addNum(7);
        summaryRanges.addNum(9);
        for (int[] nums:summaryRanges.getIntervals()) {
            System.out.println(""+nums[0]+", "+nums[1]);
        }

    }
}
