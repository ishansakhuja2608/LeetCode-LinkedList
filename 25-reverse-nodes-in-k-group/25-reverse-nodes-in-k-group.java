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
        ListNode reference = new ListNode(0, head);
        ListNode curr = head;
        ListNode prev = reference;
        
        while(curr != null) {
            ListNode tail = curr;
            int index = 0;
            
            while(curr != null && index < k) { // for group of k
                curr = curr.next;
                index += 1;
            }
            if(index != k) {
                prev.next = tail; //(prev -> tail), revered -> curr
            }
            else {
                prev.next = reverse(tail, k);
                prev = tail; // prev is at the new node (reversed)
            }
        }
        return reference.next;
    }
    
    private ListNode reverse(ListNode head, int k) { // simple reverse method
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null && k-- > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}