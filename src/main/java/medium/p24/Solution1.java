package medium.p24;


/**
 * 抄的,递归用的真是溜啊
 *
 * 1->2->other  -->
 * 2->other  1->other'  对other递归调用得到other'
 * 2-1->other'
 *
 */

import util.ListNode;

public class Solution1 {
    public static  ListNode swapPairs(ListNode head) {
        // base case
        if(head==null || head.next==null) return head;

        //递归
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.arr2list(new int[]{1,2,3,4,5});
        System.out.println("head: "+ head);

        System.out.println("after swap: "+ swapPairs(head));
    }


}
