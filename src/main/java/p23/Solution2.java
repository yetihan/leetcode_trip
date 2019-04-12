package p23;

import util.ListNode;

import java.util.PriorityQueue;
import java.util.Comparator;

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

public class Solution2 {
    public static ListNode mergeKLists(ListNode[] lists) {

        //以下三种写法等价

        PriorityQueue<ListNode> minHeap1 = new PriorityQueue<>(new ListNodeComparator());
        PriorityQueue<ListNode> minHeap2 = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((ListNode o1, ListNode o2 )-> o1.val - o2.val);



        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) continue;
            minHeap.add(node);
            lists[i] = node.next;
        }

        ListNode mergedList = new ListNode(Integer.MIN_VALUE);
        ListNode node = mergedList;
        while (!minHeap.isEmpty()){
            ListNode pollNode = minHeap.poll();
            if(pollNode.next!=null) minHeap.add(pollNode.next);
            node.next = pollNode;
            node = node.next;
            System.out.println("poll:"+node.val);


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
        System.out.println("mergeKLists:" + mergeKLists(lists).toString());

    }
}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode s1, ListNode s2) {
        return s1.val - s2.val;
    }

}
