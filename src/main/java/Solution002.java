import java.util.List;

/**
 * Created by hanzhou on 2018/1/25.
 */
// 2.Add Two Number

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=0;

        int e = 0;
        ListNode l=l1;
        while (l!= null){
            num1 = num1 + l.val*((int) Math.pow(10,e));
            e+=1;
            l = l.next;
        }

        int num2=0;
        l=l2;

        e = 0;
        while (l!= null){
            num2 = num2 + l.val*((int) Math.pow(10,e));
            e+=1;
            l = l.next;
        }

        int num = num1 + num2;
        System.out.println("num1:" + num1 + " num2:" + num2 +"num:"+num);


//        int v;
//        v= num%10;
//        num = num/10;
//        ListNode res = new ListNode(v);
//        ListNode moveNode = res;
//        while (num>0){
//            v = num%10;
//            num = num/10;
//            l = new ListNode(v);
//            moveNode.next = l;
//            moveNode = l;
//        }

//        换成神奇的 l.next = new List(v);l = l.next;
//        对属性进行赋值

        int v;
        ListNode p = new ListNode(0);
        ListNode dummy = p;

        while (num>0){
            v = num%10;
            num = num/10;
            p.next = new ListNode(v);
            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution002 solution002 = new Solution002();
        ListNode l = solution002.addTwoNumbers(l1,l2);
        while (l != null){
            System.out.println(""+l.val);
            l = l.next;
        }

    }

}

// 这个方式测试样例里面有越界的情况,没法通过测试
