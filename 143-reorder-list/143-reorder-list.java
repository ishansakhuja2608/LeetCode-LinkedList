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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode l1 = head; // head of the first half -> l1
        ListNode slow = head; // head of the second half -> slow
        ListNode fast = head; // tail of the second half -> fast
        ListNode prev = null; // tail of the first half -> prev
        
        while(fast != null && fast.next != null) {
            prev = slow; 
            slow = slow.next; 
            fast = fast.next.next; 
        }
        prev.next = null; // divided the linked list into two lists
        
        ListNode l2 = reverse(slow); // will reverse the second haf
        
        merge(l1, l2);
    }
    
    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        while(current != null) {
            next = current.next; // Before changing the next of current, store the next
            current.next = prev; // chamge the next of the current (reverse the link)
            prev = current; // move prev and current one step forward
            current = next;
        }
        return prev;
    }
    
    public void merge(ListNode l1, ListNode l2) {
        while(l1 != null) {
            ListNode l1Next = l1.next; // l1Next = 2
            ListNode l2Next = l2.next; // l2Next = 5
            
            l1.next = l2; // 1 -> 5  
            if(l1Next == null)
                break;
            l2.next = l1Next; // 5 -> 2
            l1 = l1Next; // l1 = 2
            l2 = l2Next; // l2 = 5
        }
    }
}