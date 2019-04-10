package mess;

/**
 * Created by hanzhou on 2018/1/25.
 */

// AC 15%

public class Solution002_1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int digitSum = 0;
        int digit;
        ListNode p = new ListNode(0);
        ListNode dummy = p;

        while (l1!=null || l2!=null || digitSum !=0){
            if(l1!=null){digitSum+=l1.val;l1=l1.next;}
            if(l2!=null){digitSum+=l2.val;l2=l2.next;}


            if(digitSum>=10){digit = digitSum - 10;digitSum=1;}
            else            {digit = digitSum;     digitSum=0;}

            p.next = new ListNode(digit);

            p = p.next;
            
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution002_1 solution002 = new Solution002_1();
        ListNode l = solution002.addTwoNumbers(l1,l2);
        while (l != null){
            System.out.println(""+l.val);
            l = l.next;
        }
    }

}
