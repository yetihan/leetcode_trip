package hard.p25.repeat;

import util.ListNode;

/**
 * k = 3
 * 1->2->3,other   other'
 * 2->3->other     1->other'
 * 3->other        2->1->other'
 * other           3->2->1->other'(返回这一坨)
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        for (int i = 0; i < k; i++) {
            if (cur == null) return head;
            else cur = cur.next;
        }


        ListNode other = reverseKGroup(cur,k);

        for (int i = 0; i < k; i++) {
            ListNode n = head.next;
            head.next = other;
            other = head;
            head = n;
        }

        return other;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.arr2list(new int[]{1,2,3,4,5,6});
        System.out.println("head: "+ head);
        System.out.println("after swap: "+ reverseKGroup(head,5));

        head = ListNode.arr2list(new int[]{1,2});
        System.out.println("head: "+ head);
        System.out.println("after swap: "+ reverseKGroup(head,2));
    }
}
