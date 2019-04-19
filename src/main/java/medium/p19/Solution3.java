package medium.p19;


/**
 * one-pass
 */

import util.ListNode;

public class Solution3 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        //first 先走n步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        //first 和 second 一起走,first是null的时候,second.next就是要remove的node
        while (first.next!=null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.arr2list(new int[] {1});
        System.out.println("list: "+list);
        System.out.println("after remove: "+removeNthFromEnd(list,1));
        list = ListNode.arr2list(new int[] {1,2});
        System.out.println("list: "+list);
        System.out.println("after remove: "+removeNthFromEnd(list,2));

    }
}
