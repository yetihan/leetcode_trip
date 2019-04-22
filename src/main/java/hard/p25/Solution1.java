package hard.p25;


/**
 * k=5
 *
 * 假设前五个后面的已经完成reverse
 * 只要负责反转当前的五个就行了
 * head                    cur
 * 1->2->3->4->5->other'   other' -->
 * 2->3->4->5->other'   1->other' -->
 * 3->4->5->other'   2->1->other' -->
 *
 * ...
 * other'   5->4->3->2->1->other'
 */

import util.ListNode;

public class Solution1 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;

        }
        if (cnt == k) {
            cur = reverseKGroup(cur, k);
            while (cnt>0){
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
                cnt--;
            }

            head = cur;  //不能返回cur,如果没进这个if分支的话,cur 是 null
        }

        return head;
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
