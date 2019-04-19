package medium.p19;


/**
 * two-pass with dummy
 */

import util.ListNode;

public class Solution2 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            cur = cur.next;
            len += 1;
        }


        cur = dummy;
        try {
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }

            cur.next = cur.next.next;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("wrong parameter n");
        }

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
