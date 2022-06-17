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
        if(head.next == null || k == 1) {
            return head;
        }
            
        // prev and curr pointer
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
            
        // reverse the list
        while(curr != null) {
            boolean canReverse = ifPossible(k, curr);
            if(canReverse) {
                prev = reverse(prev, curr, k);
                curr = prev.next;
            }
            else {
                break;
            }
        }
        return dummy.next;
    }
    
    private boolean ifPossible(int k, ListNode curr) {
        for(int i=1; i<=k; i++) {
            if(curr == null)
                return false;
            curr = curr.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode prev, ListNode curr, int k) {
        for(int i = 0; i < k-1; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return curr;
    }
}
