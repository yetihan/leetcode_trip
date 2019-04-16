package hard.p23;

import util.ListNode;

import java.util.HashMap;
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

public class Solution1 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode mergedList = new ListNode(Integer.MIN_VALUE);
        HashMap<Integer, ListNode> map = new HashMap<>(); //key是数值 value是数组下标的链表

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) continue;
            minHeap.add(node.val);
            lists[i] = node.next;

            if (!map.containsKey(node.val)) map.put(node.val, new ListNode(i));
            else {
                ListNode tmp = map.get(node.val);
                while(tmp.next!=null){
                    tmp = tmp.next;
                }
                 tmp.next = new ListNode(i);
            }

        }

        ListNode node = mergedList;

        while (!minHeap.isEmpty()) {
            int root = minHeap.poll();

            node.next = new ListNode(root);
            node = node.next;

//            System.out.println(root);

            int idx = map.get(root).val;

            ListNode newNodeList = map.get(root).next;
            if (newNodeList != null) map.put(root, newNodeList);
            else map.remove(root);

            ListNode pushNode = lists[idx];
            if (pushNode == null) continue;
            minHeap.add(pushNode.val);
            if (!map.containsKey(pushNode.val)) map.put(pushNode.val, new ListNode(idx));
            else {
                ListNode tmp = map.get(pushNode.val);
                while(tmp.next!=null){
                    tmp = tmp.next;
                }
                tmp.next = new ListNode(idx);
            }

            lists[idx] = pushNode.next;
        }

        return mergedList.next;
    }

    public static void main(String[] args) {


        int[][] arr = new int[][]{{-2, 1, 4, 5}, {-2, 5, 6}, {-2, 0}};
//        int[][] arr = new int[][]{{1,4,5},{1,3,4},{2,6}};

        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = ListNode.arr2list(arr[i]);
        }


        System.out.println("mergeKLists:"+mergeKLists(lists).toString());
    }
}
