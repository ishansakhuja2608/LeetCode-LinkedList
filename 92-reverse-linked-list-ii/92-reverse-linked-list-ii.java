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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if(head.next == null || left == right)
            return head;
        
        // define prev and current pointer
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        
        // moving the prev and curr to the right position
        for(int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }
        
        // reverse the sublist
        int connection = right - left;
        ListNode nex;
        for(int i=0; i<connection; i++) {
            nex = curr.next;
            curr.next = nex.next;
            nex.next = prev.next;
            prev.next = nex;
        }
        
        //return the head
        return dummy.next;
    }
}