// You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
//
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
//
// Subscribe to see which companies asked this questions
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
        return null;
        if(l1==null)
        return l2;
        if(l2==null)
        return l1;
        ListNode result = new ListNode(0);
        ListNode head = result ;
        for( ;l1!=null || l2!=null; ){
            if(l1!=null){
             head.val +=l1.val;
             l1=l1.next;
            }
            if(l2!=null){
                head.val +=l2.val;
                l2 = l2.next;
            }

            int big = head.val/10;
            if(big >0)
               head.next = new ListNode(head.val/10);
            else if(l1!=null||l2!=null){
                head.next = new ListNode(0);
            }
            head.val = head.val%10;
            head = head.next;
        }
        return result;
    }
}
