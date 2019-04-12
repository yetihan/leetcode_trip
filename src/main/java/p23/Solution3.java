package p23;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 难度 hard
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 * <p>
 * k的最小堆
 */

public class Solution3 {
    public static ListNode mergeKLists(ListNode[] lists) {


        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing((ListNode o) -> o.val));

        for (ListNode head : lists) {
            if(head==null) continue;
            minHeap.add(head);
        }

        ListNode dumy = new ListNode(0); //哨兵
        ListNode cur = dumy;                //游标
        while (minHeap.size() > 0) {
            cur.next = minHeap.poll();

            if(cur.next.next!=null) minHeap.add(cur.next.next);
            cur = cur.next;
        }

        return dumy.next;
    }

    public static void main(String[] args) {


        int[][] arr = new int[][]{{-2, 1, 4, 5}, {-2, 5, 6}, {-2, 0}};
//        int[][] arr = new int[][]{{1,4,5},{1,3,4},{2,6}};

        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = ListNode.arr2list(arr[i]);
        }
        System.out.println("mergeKLists:" + mergeKLists(lists).toString());

    }
}

