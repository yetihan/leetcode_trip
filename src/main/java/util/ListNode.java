package util;

public class ListNode {
    public Integer val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static ListNode arr2list(int[] arr){
        if(arr.length==0) return null;
        ListNode node;
        ListNode head = new ListNode(arr[0]);
        node = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            node.next = tmp;
            node = tmp;
        }

        return head;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode node = null;
        if (next != null){
            node = next;
            sb.append("->");
            sb.append(node.val);
        }

        while (node!=null && node.next != null){
            node = node.next;
            sb.append("->");
            sb.append(node.val);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(arr2list(new int[]{1,4,13}));
    }
}
