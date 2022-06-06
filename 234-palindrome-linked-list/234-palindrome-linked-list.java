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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        
        // find the middle of the linked list
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the right half of the linked list
        slow = reverseList(slow);
        fast = head; // make fast as head to compare the values of both the halves of the list
        
        // check whether left half and right half are same or not
        while(slow != null) {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null; // previous node before the head
        while(head != null) {
            ListNode next = head.next;
            head.next = prev; // set the head to null
            prev = head;
            head = next;
        }
        return prev;
    }
}