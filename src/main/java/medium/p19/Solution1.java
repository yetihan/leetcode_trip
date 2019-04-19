package medium.p19;


/**
 * two-pass solution
 */

import util.ListNode;

public class Solution1 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            len += 1;
        }

        if(len==n) return head.next;

        cur = head;
        try {
        for (int i = 1; i < len - n; i++) {
            cur = cur.next;
        }

            cur.next = cur.next.next;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("wrong parameter n");
        }

        return head;
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
