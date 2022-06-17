/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        if(head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head); // dummy.next = head;
        ListNode curr = head;
        int total = 0;
        
        while(curr != null) { 
            total += 1; // length of the linked list
            curr = curr.next;
        }
        
        // reverse
        curr = head;
        ListNode next = null;
        ListNode prev = dummy;
        
        while(total >= k) {
            curr = prev.next;
            next = curr.next; 
            
            for(int i = 1; i < k; i++) {
                curr.next = next.next; // storing the rest of the linked list
                next.next = prev.next; // reverse the link
                prev.next = next;      // next node becomes first (dummy -> next)
                next = curr.next;      // for further reversing
            }
            prev = curr; // to achieve correct links
            total -= k; // keeping a count
        }
        return dummy.next;
    }
}