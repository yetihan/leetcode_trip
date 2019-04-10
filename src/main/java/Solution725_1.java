/**
 * Created by hanzhou on 2018/8/2.
 */

public class Solution725_1 {
    public ListNode[] splitListToParts(ListNode root, int k) {

    ListNode curr = root;
    int len = 0;
    if(curr != null) len += 1;
    int size = len/k;
    int remainder = len%k;
    ListNode[] res = new ListNode[k];

    curr = root;
    for(int i=0;i<k;i++){
        res[i] = curr;
        for(int j=0;j<size+(i<remainder?1:0);j++){
            curr = curr.next;
        }
        curr.next = null;
    }

    return res;
    }

}
