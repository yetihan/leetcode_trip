package hard.p23.repeat;

import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;

//        lambda 写法
//        Queue queue = new PriorityQueue<>((ListNode o1, ListNode o2)-> o1.val-o2.val);

//        comparator.comparing 写法
//        Queue queue = new PriorityQueue<>(Comparator.comparingInt((ListNode o) -> o.val));

//        匿名类写法
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        for (ListNode node : lists) {
            if(node!=null) queue.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }

        }

        return dummy.next;
    }


    public static void main(String[] args) {
//        int[][] arr = new int[][]{{-2, 1, 4, 5}, {-2, 5, 6}, {-2, 0}};

        int[][] arr = new int[][]{{},{1,3,4},{2,6}};

        ListNode[] lists = new ListNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            lists[i] = ListNode.arr2list(arr[i]);
        }


        System.out.println("mergeKLists:" + mergeKLists(lists).toString());
    }
}
