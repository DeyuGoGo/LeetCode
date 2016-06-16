/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private void swap(ListNode[] lists , int k){
        for(int i = 0 ; i <= k - i - 1 ; i ++){
            int t = lists[i].val;
            lists[i].val = lists[k - i - 1].val;
            lists[k - i - 1].val = t;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode n = head;
        while(n!=null){
            int s = 0;
            ListNode[] u =  new ListNode[k];
            for(int i = 0 ; i< k ; i ++){
                if(n==null)break;
                u[i] = n;
                s++;
                n=n.next;
            }
            if(s!=k)break;
            swap(u,s);
        }
        return head;
    }
}
