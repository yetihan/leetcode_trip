package p23;

// *************
// 错误答案
// *************

import util.ListNode;
import java.util.PriorityQueue;

/**
 *  https://leetcode.com/problems/merge-k-sorted-lists/
 *  难度 hard
 *  Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *  Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * k的最小堆
 */

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)return null;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if(node==null) continue;
            minHeap.add(node.val);
            lists[i] = node.next;
        }

        ListNode dumy = new ListNode(0); //哨兵
        ListNode cur=dumy;                  //游标

        int i = 0;
        while (minHeap.size()>0){
            int emptyNum = 0;

            ListNode tmp = new ListNode(minHeap.poll());
            cur.next = tmp;
            cur = tmp;

            if(emptyNum==lists.length) continue;  //卡住了,不知道为什么idea报always false的 warinig

            ListNode walker = lists[i];
            while (walker==null && emptyNum<lists.length){
                i = (i+1) % (lists.length);
                walker = lists[i];
                emptyNum++;
            }

            if(emptyNum==lists.length) continue;

            minHeap.add(walker.val);
            lists[i] = walker.next;
            i = (i+1) % (lists.length);

        }

        return dumy.next;
    }

    public static void main(String[] args) {
//        ListNode[] lists = new ListNode[3];
//        lists[0] = ListNode.arr2list(new int[]{1,4,5});
//        lists[1] = ListNode.arr2list(new int[]{1,3,4});
//        lists[2] = ListNode.arr2list(new int[]{2,6});

        ListNode[] lists = new ListNode[2];
        lists[0] = ListNode.arr2list(new int[]{1,2,3});
        lists[1] = ListNode.arr2list(new int[]{4,5,6,7});

        System.out.println("mergeKLists:"+mergeKLists(lists).toString());
    }
}
