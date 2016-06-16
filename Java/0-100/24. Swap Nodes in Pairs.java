// 得瑜點評：非常簡單的交換.......
public class Solution {
    private void swapHeadTwo(ListNode n){
        int t = n.val;
        n.val = n.next.val;
        n.next.val = t;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode n = head;
        while(n!=null&&n.next!=null){
            swapHeadTwo(n);
            n = n.next.next;
        }
        return head;
    }
}
