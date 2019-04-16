package hard.p23;

import util.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution4 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(null == lists){
            return null;
        }else if(lists.length == 1){
            return lists[0];
        }

//        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparing((ListNode o) -> o.val));

        PriorityQueue<ListNode> minHeap = new PriorityQueue( new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });

        for (ListNode head : lists) {
            if(head!=null) minHeap.add(head);
        }

        ListNode dumy = new ListNode(0); //哨兵
        ListNode cur = dumy;                //游标
        while (minHeap.size() > 0) {
            cur.next = minHeap.poll();

            if(cur.next.next!=null) minHeap.add(cur.next.next);
            cur = cur.next;
        }

        return dumy.next;
    }
}