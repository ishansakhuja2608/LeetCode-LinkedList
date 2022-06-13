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
    // If we encounter distinct elements, we move both, the head and prev pointer, if we encounter duplicates, 
    // we move head only and keep the prev on last distinct node, when head and head.next are not same, make
    // prev.next = head.next
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode reference = new ListNode(0);
        reference.next = head;
        ListNode prev = reference; // Last distinct value till now
        
        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                // Skip the nodes with the same value
                
                while(head.next != null && head.val == head.next.val) {
                    head = head.next; // skip the nodes and keep the prev to the last distince node
                }
                prev.next = head.next;
            }
            else {
                prev = prev.next; // if there are no duplicates, move the prev
            }
            
            head = head.next;
        }
        return reference.next;
    }
}