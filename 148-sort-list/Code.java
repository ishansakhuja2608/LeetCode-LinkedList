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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            temp = slow;                // temp will be the end of the first half list
            slow = slow.next;           // slow -> head of second half
            fast = fast.next.next;      // fast -> end of the second half
        }
        temp.next = null;               // divided the list into two halves
        
        // Recursive calls
        ListNode leftHalf = sortList(head);
        ListNode rightHalf = sortList(slow);
        
        return  merge(leftHalf, rightHalf);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode sortedHead = new ListNode(0); 
        ListNode currentNode = sortedHead; // Reference to the head
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        // edge cases -> if any of the lists head null
        if(l1 != null) {
            currentNode.next = l1;
            l1 = l1.next;
        }
        
        if(l2 != null) {
            currentNode.next = l2;
            l2 = l2.next;
        }
        
        return sortedHead.next;            
    }
}
